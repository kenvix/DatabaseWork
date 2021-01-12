<#import "../../common/layout.ftl" as layout />
<@layout.layout title="标题">
    <!-- Begin Page code -->
    <nav class="navbar navbar-expand-lg navbar-light bg-white navbar-main">
        <div class="container">
            <a class="navbar-brand" href="/Home/Index/index">library 用户中心</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- Begin Page code -->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"><a class="nav-link" href="/user/login">登录</a></li>
                    <li class="nav-item"><a class="nav-link" href="/user/register">注册</a></li>
                    <li class="nav-item"><a class="nav-link" href="/Home/Apply/applyInviteCode">申请邀请码</a></li>
                    <li class="nav-item"><a class="nav-link" href="/user/password_reset"> 忘记密码</a></li>
                    <li class="nav-item"><a class="nav-link" href="/Doc/Public/duoshuo">评论</a></li>
                    <li class="nav-item"><a class="nav-link" href="/Doc/Public/status">实时服务器状态</a></li>
                    <li class="nav-item"><a class="nav-link" href="/Doc/Public/play">了解 library</a></li>
                    <!--<li class="nav-item"><a class="nav-link" href="/Home/Mc/about">关于</a></li>-->      </ul>
            </div>
        </div>
    </nav>
    <script type="text/javascript">
        page = 1;
        totalPage = 1;
    </script>
    <div class="container container-main flex-grow-1">
        <div class="row">
            <!-- 侧边导航，宽屏设备可见 -->
            <div class="col-lg-3">
                <div class="card hidden-print d-none d-lg-block nav-side" role="complementary" >
                    <ul class="nav flex-column">
                        <li class="nav-item"><a class="nav-link" href="https://www.moecraft.net" target="_blank">主页</a></li>
                        <li class="nav-item"><a class="nav-link" href="/user/login"> 登录</a></li>
                        <li class="nav-item"><a class="nav-link" href="/user/register"> 注册</a></li>
                        <li class="nav-item"><a class="nav-link" href="/Home/Apply/applyInviteCode"> 申请邀请码</a></li>
                        <li class="nav-item"><a class="nav-link" href="/user/password_reset"> 忘记密码</a></li>
                        <li class="nav-item"><a class="nav-link" href="/Doc/Public/duoshuo">评论</a></li>
                        <li class="nav-item"><a class="nav-link" href="/Doc/Public/status">实时服务器状态</a></li>
                        <li class="nav-item"><a class="nav-link" href="/Doc/Public/play">了解 library</a></li>
                        <!--<li class="nav-item"><a class="nav-link" href="/Home/Mc/about">关于</a></li>-->    </ul>
                </div>
                <script type="text/javascript">
                    $(".nav-link[href$='user/login']").addClass('active');
                </script>
            </div>
        </div>
    <div class="col-lg main" role="main">
                <div class="card">
                    <div class="card-header">创建 library 账户</div>
                    <div class="card-body" id="aboutInfo">
                        <p>
                            你当前还没有library账户，请先创建一个
                        </p>
                        <p>用户名称最短为 3 位，最长为 20 位，只能包含英文字母、数字或下划线，不能有其他的特殊符号</p>
                        <p>备用密码仅用于紧急情况，不是用户密码，登录系统应使用用户中心登录密码</p>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header">创建/修改数字图书馆系统账户</div>
                    <div class="card-body" id="aboutData">
                        <form ajax="true" action="/Home/Mc/createAct" method="post" class="clearfix">
                            <div class="alert alert-info ajax-info" role="alert">
                                <div class="ajax-info-text"></div>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="name" required="" maxlength="20" placeholder="用户名称">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="pw" required=""
                                       placeholder="备用密码. 仅用于紧急情况, 登录系统使用用户中心登录密码">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control  ajax-code-input" name="code" placeholder="输入右图的验证码，看不清可以点击图片更换"
                                       required="" maxlength="5">
                            </div>
                            <div class="row mb-4">
                                <div class="col-auto">
                                    <input type="submit" class="btn btn-success" style="margin-top: 10px;" value="立即创建">
                                </div>
                                <div class="col ml-auto pl-0 text-right">
                                    <img src="${public}/img/genVerifyCode.gif" id="changePwdVC" onclick="this.src = this.src;" title="点击更换验证码"
                                         width="220" height="62" class="img-thumbnail ajax-code-img">
                                </div>
                            </div>
                            <input type="hidden" name="MOERCEXTREDG"
                                   value="3a8fa4e50bd8a0208fbb777893d9727e_c4f689d67d1c0850de6a37bd46956973" />
                        </form>
                        <p>用户名称不能带有中文，只能包含英文字母、数字或下划线，不能有其他的特殊符号。</p>
                        <p>创建账户后即可进入游戏，用户名为你的用户中心<b>邮箱</b>，密码为你的用户中心登录密码</p>
                        <p>如果你是library正版用户并打算使用正版数字化信息系统名，但是数字化信息系统名称已经被占用，请联系我们。</p>
                        <p><b>禁止使用下列名称</b>：null [sponge] op administrator operator system server notch buildcraft [buildcraft]
                            console caller admin library HookEvent TickRate ClientAA AntiAim</p>
                    </div>
                </div>

            </div><!-- .main -->

        </div><!-- .row -->
    </div><!-- .container-main -->
    <!-- End of page code -->
</@layout.layout>