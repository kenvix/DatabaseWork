//--------------------------------------------------
// Class HomeBaseController
//--------------------------------------------------
// Written by Kenvix <i@com.kenvix.com>
//--------------------------------------------------

package com.kenvix.bookmgr.http.controller.home

import com.kenvix.bookmgr.http.controller.BaseController
import com.kenvix.web.utils.plus
import java.nio.file.Path

abstract class HomeBaseController : BaseController() {
    override val baseTemplatePath: Path
        get() = super.baseTemplatePath + "home"
}