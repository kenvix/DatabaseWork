<!DOCTYPE html>
<html lang="zh">
<#include "../../common/header.ftl" />
<body>
<!-- Begin Page code -->
<nav class="navbar navbar-expand-lg navbar-light bg-white navbar-main">
    <div class="container">
        <a class="navbar-brand" href="#">图书管理系统</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">
                        账号管理
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">账户资料</a>
                        <a class="dropdown-item" href="#">皮肤管理</a>
                        <a class="dropdown-item" href="#">个性化设置</a>
                        <a class="dropdown-item" href="#">邀请注册</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">
                        借阅信息
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">借阅历史</a>
                        <a class="dropdown-item" href="#">预约图书</a>
                        <a class="dropdown-item" href="#">新书浏览</a>
                        <a class="dropdown-item" href="#">常见问题疑难解答</a>
                        <a class="dropdown-item" href="#">资料库&帮助</a>

                    </div>
                </li>
                <!--<li class="nav-item"><a class="nav-link" href="/Home/Mc/about">关于</a></li>-->
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link pr-0 bg-transparent dropdown-toggle" data-toggle="dropdown"
                       role="button" aria-haspopup="true" aria-expanded="false">
                        安全选项 &emsp; admin <img src="img/usericon.png" class="rounded-circle align-top ml-1"
                                               width="20" height="20" />
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#"> 注销</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">修改密码</a>
                        <a class="dropdown-item" href="#">修改邮箱</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<script type="text/javascript">
    page = 1;
    totalPage = 10;
</script>
<div class="container container-main flex-grow-1">
    <div class="row">
        <!-- 侧边导航，宽屏设备可见 -->
        <div class="col-lg-3">
            <div class="card hidden-print d-none d-lg-block nav-side" role="complementary">
                <ul class="nav flex-column">
                    <li class="nav-item"><a class="nav-link" href="#">首页</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">账户资料</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">口令修改</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">个性化设置</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">邀请注册</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">资料库&帮助</a></li>
                    <!--<li class="nav-item"><a class="nav-link" href="/Home/Mc/about">关于</a></li>-->
                </ul>
            </div>
            <script type="text/javascript">
                $(".nav-link[href$='/Home/Index/index']").addClass('active');
            </script>
        </div>
        <div class="col-lg main" role="main">
            <div class="alert alert-info" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                注销成功
            </div>
            <div class="card">
                <div class="card-header">登录 MoeCraft 用户中心</div>
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
    </div>
</div>





<!-- End of page code -->
<#include "../../common/footer.ftl" />
</body>
</html>