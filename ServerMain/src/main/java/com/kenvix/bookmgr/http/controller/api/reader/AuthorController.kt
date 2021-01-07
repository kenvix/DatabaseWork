package com.kenvix.bookmgr.http.controller.api.reader

import com.kenvix.bookmgr.http.controller.api.ApiBaseController
import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.model.mysql.AuthorModel
import com.kenvix.bookmgr.orm.tables.pojos.Author
import com.kenvix.web.utils.*
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
object AuthorController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            get("/") {
                middleware(CheckUserToken)
                respondJson(AuthorModel.fetchAll())
            }

            get<AuthorIDLocation> { authorId ->
                middleware(CheckUserToken)
                val author = AuthorModel.fetchOneById(authorId.id)
                respondJson(author)
            }

            post("/") {
                middleware(CheckCommonAdminToken)
                val params = call.receiveParameters()
                val data = Author().apply {
                    name = params["name"].validateValue { it.length in 1..35 }
                    fullname = params["fullname"]?.validateValue { it.length in 1..60 } ?: name
                    country = params["country"]?.validateValue { it.length in 1..2 } ?: "CN"
                    description = params["description"] ?: ""
                }

                AuthorModel.insert(data)
                respondJson(data)
            }

            put<AuthorIDLocation> { authorId ->
                middleware(CheckCommonAdminToken)
                val params = call.receiveParameters()
                val data = AuthorModel.fetchOneById(authorId.id).apply {
                    name = params["name"].validateValue { it.length in 1..35 }
                    fullname = params["fullname"]?.validateValue { it.length in 1..60 } ?: name
                    country = params["country"]?.validateValue { it.length in 1..2 } ?: "CN"
                    description = params["description"] ?: ""
                }

                AuthorModel.insert(data)
                respondJson(data)
            }

            delete<AuthorIDLocation> { authorId ->
                middleware(CheckCommonAdminToken)

                AuthorModel.deleteById(authorId.id)
                respondSuccess("Deleted")
            }
        }
    }

    @OptIn(KtorExperimentalLocationsAPI::class)
    @Location("/{id}")
    class AuthorIDLocation(val id: Long)
}