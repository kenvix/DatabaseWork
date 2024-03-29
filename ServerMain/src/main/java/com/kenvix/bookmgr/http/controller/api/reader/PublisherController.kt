package com.kenvix.bookmgr.http.controller.api.reader

import com.kenvix.bookmgr.http.controller.api.ApiBaseController
import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.PublisherIDLocation
import com.kenvix.bookmgr.model.mysql.PublisherModel
import com.kenvix.bookmgr.orm.tables.pojos.Publisher
import com.kenvix.web.utils.*
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
object PublisherController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            get("/") {
                middleware(CheckUserToken)
                respondJson(PublisherModel.getAll())
            }

            post("/") {
                middleware(CheckCommonAdminToken)
                val params = call.receiveParameters()
                val data = Publisher().apply {
                    name = params["name"].validateValue { it.length in 1..80 }
                    description = params["description"] ?: ""
                }

                PublisherModel.insert(data)
                respondSuccess("添加出版社成功", data)
            }

            get<PublisherIDLocation> { publisherId ->
                middleware(CheckUserToken)
                val publisher = PublisherModel.fetchOneById(publisherId.id)
                respondJson(publisher)
            }

            put<PublisherIDLocation> { publisherId ->
                middleware(CheckCommonAdminToken)

                val params = call.receiveParameters()
                val data = PublisherModel.fetchOneById(publisherId.id).apply {
                    name = params["name"].validateValue { it.length in 1..80 }
                    description = params["description"] ?: ""
                }

                PublisherModel.update(data)
                respondSuccess("更新出版社信息成功", data)
            }

            delete<PublisherIDLocation> { publisherId ->
                middleware(CheckCommonAdminToken)

                PublisherModel.deleteById(publisherId.id)
                respondSuccess("删除出版社成功")
            }
        }
    }
}