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
                $(".nav-link[href$='#']").addClass('active');
            </script>
        </div>
        <div class="col-lg main" role="main">
            <div class="card">
                <div class="card-header">更改 library 用户中心 密码</div>
                <div class="card-body" id="aboutInfo">
                    <p>你正在修改你在用户中心的密码。如果你不需要修改密码，请离开此页面。</p>
                    <p>修改密码后需要重新在启动器输入密码</p>
                </div>
            </div>

            <div class="card">
                <div class="card-header">更改 library 用户中心 密码</div>
                <div class="card-body" id="changePwInfo">
                    <form ajax="true" action="/Home/User/changePwAction" method="post"
                          onsubmit="return checkPwdOnSubmit();">
                        <div class="alert alert-info ajax-info" role="alert">
                            <div class="ajax-info-text"></div>
                        </div>

                        <div class="form-group">
                            <input type="password" class="form-control" name="oldpw" required="" maxlength="20"
                                   placeholder="原密码">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="newpw" id="pw" required=""
                                   placeholder="新密码">
                        </div>

                        <div class="form-group">
                            <input type="password" class="form-control" name="newpw2" id="pw2" placeholder="再次输入密码"
                                   required="">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control ajax-code-input" name="code"
                                   placeholder="输入下图的验证码，看不清可以点击图片更换" required="" maxlength="5">
                        </div>
                        <p>
                            <img src="img/genVerifyCode1.gif" id="changePwdVC" onclick="this.src = this.src;"
                                 title="点击更换验证码" width="220" height="62" class="img-thumbnail ajax-code-img">
                        </p>
                        <input type="submit" class="btn btn-success" value="提交更改">
                        <input type="hidden" name="MOERCEXTREDG"
                               value="a0519252763c39c18a652fd593124bdc_66bfaa637b9b3952eaa11f295bed5d43" />
                    </form>
                </div>
            </div>
            <script type="text/javascript">
                function checkPwdOnSubmit() {
                    if($("#pw").val() != $("#pw2").val()) {
                        alert('两次输入的密码不一致，请重新输入');
                        return false;
                    } else {
                        return true;
                    }
                }
            </script>        </div><!-- .main -->
    </div><!-- .row -->
</div><!-- .container-main -->


<!-- End of page code -->
<#include "../../common/footer.ftl" />
</body>
</html>