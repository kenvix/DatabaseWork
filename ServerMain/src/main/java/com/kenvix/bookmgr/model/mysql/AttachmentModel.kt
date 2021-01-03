package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.enums.AttachmentType
import com.kenvix.bookmgr.orm.tables.daos.AttachmentDao
import com.kenvix.bookmgr.orm.tables.pojos.Attachment
import com.kenvix.web.utils.from
import com.kenvix.web.utils.limit
import com.kenvix.web.utils.select
import com.kenvix.web.utils.where
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object AttachmentModel : AttachmentDao(), BaseModel {
    private val table
        get() = com.kenvix.bookmgr.orm.tables.Attachment.ATTACHMENT

    fun isAttachmentExist(hash: String, type: AttachmentType): Boolean {
        return (dsl select table.ID from table where table.HASH.eq(hash).and(table.TYPE.eq(type)) limit 1)
                .fetchOne() != null
    }

    fun fetchAttachmentsByArticleId(id: Int): List<Attachment>? {
        return ArticleAttachmentModel.fetchByArticleId(id)?.map {
            fetchOneAttachmentBasicInfo(it.attachmentId)
        }?.filterNotNull()
    }

    fun fetchOneAttachmentBasicInfo(hash: String, type: AttachmentType): Attachment? =
            (dsl.select(table.ID, table.HASH, table.TYPE)
                    from table where table.HASH.eq(hash).and(table.TYPE.eq(type)) limit 1)
                    .fetchOneInto(Attachment::class.java)

    fun fetchOneAttachmentBasicInfo(id: Int): Attachment? =
            (dsl.select(table.ID, table.HASH, table.TYPE)
                    from table where table.ID.eq(id) limit 1)
                    .fetchOneInto(Attachment::class.java)

    fun fetchOneAttachmentBasicInfo(hash: String): Attachment? =
            (dsl.select(table.ID, table.HASH, table.TYPE)
                    from table where table.HASH.eq(hash) limit 1)
                    .fetchOneInto(Attachment::class.java)

    fun fetchOneAttachmentAllInfo(hash: String, type: AttachmentType): Attachment? =
            (dsl.select() from table where table.HASH.eq(hash).and(table.TYPE.eq(type)) limit 1)
                    .fetchOneInto(Attachment::class.java)

    fun setReferenceNum(id: Int, num: Int)
            = dsl.update(table).set(table.REFERENCE_NUM, num).where(table.ID.eq(id)).execute()

    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }
}