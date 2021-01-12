<#import "../../common/layout.ftl" as layout />
<@layout.layout title="系统简介">
    <!-- Begin Page code -->
    <!-- Begin Page code -->
            <div class="col-lg main" role="main">
                <div class="alert alert-info" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                    注销成功
                </div>
                <div class="card">
                    <div class="card-header">登录 library 用户中心${siteName}</div>
                    <div class="card-body" id="loginData">
                        <form action="/Home/User/loginact" ajax="true" onsubmit="return checkPwdOnSubmit();"
                              method="post">
                            <div class="alert alert-info ajax-info" role="alert">
                                <div class="ajax-info-text"></div>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="name" required maxlength="25"
                                       placeholder="昵称或邮箱">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="pw" id="pw" required placeholder="密码">
                            </div>
                            <div class="form-group">
                                <div class="custom-control custom-checkbox">
                                    <input class="custom-control-input" type="checkbox" name="rem" id="rem" value="1">
                                    <label class="custom-control-label" for="rem">记住我 [ 7天内有效 ]</label>
                                </div>
                            </div>
                            <p><input type="submit" class="btn btn-primary" value="立即登录"></p>
                            <a href="/Home/User/reg">没有账号？点击注册</a>
                            <input type="hidden" name="MOERCEXTREDG"
                                   value="78fb64ba92c1d179f22bf9301603b094_0f17a73d26a4447b57e3fba226c46523" />
                        </form>
                    </div>
                </div>
            </div>
    <!-- End of page code -->
</@layout.layout>