<#macro layout title="[ERROR:NO TITLE]">
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8">
    <link rel="stylesheet" href="${public}/css/main.css">
    <script src="${public}/js/main.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Ubuntu:400,600">

    <title>${title} - ${siteName}</title>
</head>
<body>
<#nested />
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



<footer>

</footer>
</body>
</html>
</#macro>