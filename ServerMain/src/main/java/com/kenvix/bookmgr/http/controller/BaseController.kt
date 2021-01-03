//--------------------------------------------------
// Class BaseController
//--------------------------------------------------
// Written by Kenvix <i@com.kenvix.com>
//--------------------------------------------------

package com.kenvix.bookmgr.http.controller

import com.kenvix.web.utils.Controller
import org.slf4j.LoggerFactory

abstract class BaseController : Controller {
    val logger = LoggerFactory.getLogger(this::class.java)!!
}