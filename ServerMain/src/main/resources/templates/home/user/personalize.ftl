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
                <div class="card-header">邀请其他读者注册 library ${siteName}</div>
                <div class="card-body" id="aboutInfo">
                    <p>当你注册达到 10 天后，你可以通过生成邀请码来邀请其他玩家游戏</p>
                    <p>
                        每隔 4 天可以获得1个邀请码，			每成功邀请一次获得 450 萌币
                    </p>
                    <p><button class="btn btn-primary" data-toggle="modal" data-target="#createInviteCodeModal">创建邀请码</button></p>
                    <p><a href="/Home/User/invitecode?export=1" target="_blank">导出可用的邀请码</a></p>
                </div>
            </div>
            <div class="card">
                <div class="card-header">已创建的邀请码</div>
                <table class="table table-hover table-borderless mb-0">
                    <thead>
                    <tr>
                        <th style="width:60%">邀请码</th>
                        <th>创建时间</th>
                        <th style="width:20%">状态/操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <script>
                function delInviteCode(id) {
                    if(confirm('你确定要删除邀请码 #'+id+' 吗？\n删除邀请码不退还萌币，但是你可以立即重新生成邀请码')) {
                        location = "/Home/User/createInviteCode&del=" + id;
                    }
                }
            </script>
            <!-- Modal -->
            <div class="modal fade" id="createInviteCodeModal" tabindex="-1" role="dialog" aria-labelledby="createInviteCodeModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form action="/Home/User/createInviteCode" method="post" ajax="true">
                            <div class="modal-header">
                                创建邀请码
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            </div>
                            <div class="modal-body">
                                <div class="alert alert-info ajax-info" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <div class="ajax-info-text"></div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">要创建邀请码个数</span>
                                        </div>
                                        <input class="form-control" type="number" value="1" disabled>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary">继续创建</button>
                            </div>
                            <input type="hidden" name="MOERCEXTREDG" value="4fd5f00d4a74d5392a8ac2370389ee9c_a4e1673d9e4249b0a8028192ba5432db" /></form>
                    </div>
                </div>
            </div>
        </div><!-- .main -->
    </div><!-- .row -->
</div><!-- .container-main -->


    <!-- End of page code -->
</@layout.layout>