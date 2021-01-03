package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.enums.AttachmentType
import com.kenvix.bookmgr.orm.tables.daos.ArticleAttachmentDao
import com.kenvix.bookmgr.orm.tables.pojos.ArticleAttachment
import com.kenvix.bookmgr.orm.tables.pojos.Attachment
import com.kenvix.utils.exception.NotFoundException
import com.kenvix.web.utils.assertExist
import org.jooq.Configuration
import java.sql.Timestamp

@OptIn(SingletonModel::class)
object ArticleAttachmentModel : ArticleAttachmentDao(AppConstants.globalJooqConfiguration), BaseModel {
    private val table
        get() = com.kenvix.bookmgr.orm.tables.ArticleAttachment.ARTICLE_ATTACHMENT

    fun addArticleAttachment(articleId: Int, attachmentId: Int): ArticleAttachment {
        return transactionThreadLocal { _ ->
            val attachment = AttachmentModel.fetchOneById(attachmentId).assertExist()
            AttachmentModel.setReferenceNum(attachment.id, if (attachment.referenceNum < 0) 1 else attachment.referenceNum + 1)

            val articleAttachment = ArticleAttachment().apply {
                this.articleId = articleId
                this.attachmentId = attachmentId
            }

            insert(articleAttachment)
            articleAttachment
        }
    }

    fun addArticleAttachment(articleId: Int, hash: String, type: AttachmentType, autoCreate: Boolean = false):
            ArticleAttachment {
        return kotlin.run {
            transactionThreadLocal { _ ->
                val attachment = kotlin.run {
                    val att = AttachmentModel.fetchOneAttachmentAllInfo(hash, type)
                    if (att == null) {
                        if (!autoCreate)
                            throw NotFoundException("No such attachment found")

                        val newAtt = Attachment().apply {
                            this.hash = hash
                            this.type = type
                            this.referenceNum = 1
                            this.createTime = Timestamp(System.currentTimeMillis())
                        }

                        AttachmentModel.insert(newAtt)
                        newAtt
                    } else {

                        AttachmentModel.setReferenceNum(att.id, if (att.referenceNum < 0) 1 else att.referenceNum + 1)
                        att
                    }

                }

                val articleAttachment = ArticleAttachment().apply {
                    this.articleId = articleId
                    this.attachmentId = attachment.id
                }

                insert(articleAttachment)
                articleAttachment
            }
        }
    }

    fun deleteArticleAttachment(id: Int) = dsl.transactionResult { ->
        val articleAttachment = fetchOneById(id)

        if (articleAttachment != null) {
            val attachment = AttachmentModel.fetchOneById(articleAttachment.id)
            AttachmentModel.setReferenceNum(attachment.id, attachment.referenceNum - 1)
            //Always use cron to delete not referenced attachments
        }

        delete(articleAttachment)
    }

    fun deleteAllArticleAttachmentsByArticleId(articleId: Int) =
        dsl.deleteFrom(table).where(table.ARTICLE_ID.eq(articleId)).execute()

    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }
}