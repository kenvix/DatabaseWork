package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.enums.ArticleStatus
import com.kenvix.bookmgr.orm.tables.daos.ArticleDao
import com.kenvix.bookmgr.orm.tables.pojos.Article
import org.jooq.Configuration


@OptIn(SingletonModel::class)
object ArticleModel : ArticleDao(AppConstants.globalJooqConfiguration), BaseModel {
    private val table
        get() = com.kenvix.bookmgr.orm.tables.Article.ARTICLE

    fun deleteArticleWithAttachmentsAndComments(id: Int) = transactionThreadLocal { _ ->
        ArticleAttachmentModel.deleteAllArticleAttachmentsByArticleId(id)
        CommentModel.deleteAllCommentsByArticleId(id)
        ArticleModel.deleteById(id)
    }

    fun getArticlesDesc(num: Int, offset: Int, status: ArticleStatus = ArticleStatus.normal): List<Article>? {
        return dsl.select().from(table).where(table.STATUS.eq(status)).limit(offset, num)
                .fetch()?.into(Article::class.java)
    }

    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }
}