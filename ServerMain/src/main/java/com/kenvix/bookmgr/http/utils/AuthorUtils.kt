package com.kenvix.bookmgr.http.utils

import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.model.mysql.AuthorModel
import com.kenvix.bookmgr.orm.tables.pojos.Author
import com.kenvix.web.utils.middleware
import com.kenvix.web.utils.respondSuccess
import com.kenvix.web.utils.validateValue
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.util.pipeline.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/{id}")
class AuthorIDLocation(val id: Long)

internal object AuthorControllerUtils {
    internal suspend fun PipelineContext<Unit, ApplicationCall>.getAllAuthors() = withContext(Dispatchers.IO) {
        middleware(CheckUserToken)
        AuthorModel.fetchAll()
    }

    internal suspend fun PipelineContext<Unit, ApplicationCall>.getAuthor(authorId: Long) = withContext(Dispatchers.IO) {
        middleware(CheckUserToken)
        AuthorModel.fetchOneById(authorId)
    }

    internal suspend fun PipelineContext<Unit, ApplicationCall>.addAuthor() = withContext(Dispatchers.IO) {
        middleware(CheckCommonAdminToken)
        val params = call.receiveParameters()
        val data = Author().apply {
            name = params["name"].validateValue { it.length in 1..35 }
            fullname = params["fullname"]?.validateValue { it.length in 1..60 } ?: name
            country = params["country"]?.validateValue { it.length in 1..2 } ?: "CN"
            description = params["description"] ?: ""
        }

        AuthorModel.insert(data)
        respondSuccess("添加作者成功", data)
    }

    internal suspend fun PipelineContext<Unit, ApplicationCall>.deleteAuthor(authorId: Long) = withContext(Dispatchers.IO) {
        middleware(CheckCommonAdminToken)

        AuthorModel.deleteById(authorId)
        respondSuccess("删除作者成功")
    }

    internal suspend fun PipelineContext<Unit, ApplicationCall>.updateAuthor(authorId: Long) = withContext(Dispatchers.IO) {
        middleware(CheckCommonAdminToken)
        val params = call.receiveParameters()
        val data = AuthorModel.fetchOneById(authorId).apply {
            name = params["name"].validateValue { it.length in 1..35 }
            fullname = params["fullname"]?.validateValue { it.length in 1..60 } ?: name
            country = params["country"]?.validateValue { it.length in 1..2 } ?: "CN"
            description = params["description"] ?: ""
        }

        AuthorModel.insert(data)
        respondSuccess("修改作者信息成功", data)
    }
}