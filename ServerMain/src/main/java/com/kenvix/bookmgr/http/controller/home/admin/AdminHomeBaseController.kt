//--------------------------------------------------
// Class AdminHomeBaseControl
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.bookmgr.http.controller.home.admin

import com.kenvix.bookmgr.http.controller.home.HomeBaseController

abstract class AdminHomeBaseController : HomeBaseController() {
    override val baseTemplatePath: String
        get() = super.baseTemplatePath + "admin/"
}