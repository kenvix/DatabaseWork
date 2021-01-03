package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.tables.daos.CommentDao
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object CommentModel : CommentDao(AppConstants.globalJooqConfiguration), BaseModel {
    private val table
        get() = com.kenvix.bookmgr.orm.tables.Comment.COMMENT

    fun deleteAllCommentsByArticleId(articleId: Int) =
        dsl.deleteFrom(table).where(table.ARTICLE_ID.eq(articleId)).execute()

    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }
}