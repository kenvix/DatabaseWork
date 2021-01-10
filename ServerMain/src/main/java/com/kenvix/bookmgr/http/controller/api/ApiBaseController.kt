//--------------------------------------------------
// Class ApiBaseController
//--------------------------------------------------
// Written by Kenvix <i@com.kenvix.com>
//--------------------------------------------------

package com.kenvix.bookmgr.http.controller.api

import com.kenvix.bookmgr.http.controller.BaseController
import java.nio.file.Path
import com.kenvix.web.utils.plus

abstract class ApiBaseController : BaseController() {
    override val baseTemplatePath: String
        get() = super.baseTemplatePath + "api/"
}