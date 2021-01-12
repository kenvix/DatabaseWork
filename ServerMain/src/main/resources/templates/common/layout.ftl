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




<nav class="navbar navbar-expand-lg navbar-light bg-white navbar-main">
    <div class="container">
        <a class="navbar-brand" href="#">高级图书管理系统</a>
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

<#nested />
<body>


</body>

<footer>
    <div class="footer bg-white">
        <div class="container">
            <p>HTTPS Enabled.</p>
            <p>Copyright © 2020~2021 library. All Rights Reserved. library User Center Team
                | <a href="javascript:;" onclick="contactUs();">Contact us & Report bug</a></p>
            <p>Theme <a href="#" target="_blank">Icarus</a> is licensed under the MIT License.</p>
            <p>2021-01-06 14:54 Processed in 0.00091s.</p>
        </div>
    </div>
    <div class="modal fade" id="alert_modal" tabindex="-1" role="dialog" aria-labelledby="watitle" aria-hidden="true">
        <div id="alert_modal_dialog" class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <span class="modal-title" id="watitle"></span>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body" id="watext" style="word-wrap: break-word"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="waclose" data-dismiss="modal" style="width:100px;">关闭</button>
                </div>
            </div>
        </div>
    </div>

</footer>
</html>
</#macro>