<nav class="navbar navbar-expand-lg navbar-light bg-white navbar-main">
    <div class="container">
        <a class="navbar-brand" href="/">${siteName}</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <#if user??>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">
                            读者工具
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="/reader/book">图书列表</a>
                            <a class="dropdown-item" href="/reader/book/search">检索图书</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/reader/book/borrow">我的借阅</a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">
                            设置和资料
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="/user/profile">账户资料</a>
                            <a class="dropdown-item" href="/user/personalize">个性化设置</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">常见问题疑难解答</a>
                            <a class="dropdown-item" href="/public/openapi/index.html">外部 API 参考手册</a>
                        </div>
                    </li>

                    <#if user.getAccessLevel() gte 100>
                        <li class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">
                                管理工具
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="/admin/book">图书管理</a>
                                <a class="dropdown-item" href="/admin/book/search">检索图书</a>
                                <a class="dropdown-item" href="/admin/book/add">添加新图书</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/admin/user">用户管理</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/admin/setting">系统设置</a>
                            </div>
                        </li>
                    </#if>
                    <!--<li class="nav-item"><a class="nav-link" href="/Home/Mc/about">关于</a></li>-->
                <#else>
                    <li class="nav-item"><a class="nav-link" href="/user/login">登录</a></li>
                    <li class="nav-item"><a class="nav-link" href="/user/register">注册</a></li>
                    <li class="nav-item"><a class="nav-link" href="/user/password/reset"> 忘记密码</a></li>
                </#if>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="javascript:window.history.go(-1);" class="nav-link" role="button">
                        <i class="bi bi-skip-backward-fill"></i>
                        返回上页
                    </a>
                </li>

                <#if user??>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link pr-0 bg-transparent dropdown-toggle" data-toggle="dropdown"
                           role="button" aria-haspopup="true" aria-expanded="false">
                            安全选项 &emsp; ${user.getRealName()} <img
                                    src="https://cn.gravatar.com/avatar/${userEmailMd5}?s=128&d=mm"
                                    class="rounded-circle align-top ml-1" width="20" height="20"/>
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="javascript:;"> 学号: ${user.getSerialId()}</a>
                            <a class="dropdown-item" href="javascript:;"> 姓名: ${user.getRealName()}</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/user/logout"> 注销</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/user/profile">修改个人资料</a>
                        </div>
                    </li>
                </#if>
            </ul>
        </div>
    </div>
</nav>