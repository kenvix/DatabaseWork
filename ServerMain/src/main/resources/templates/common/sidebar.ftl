<!-- 侧边导航，宽屏设备可见 -->
<div class="col-lg-3">
    <div class="card hidden-print d-none d-lg-block nav-side" role="complementary" >
        <ul class="nav flex-column">
            <#if user??>
                    <li class="nav-item"><a class="nav-link" href="/"> 首页</a></li>
                    <li class="nav-item"><a class="nav-link" href="/reader/book/"> 图书列表</a></li>
                    <li class="nav-item"><a class="nav-link" href="/reader/book/search"> 检索图书</a></li>
                    <li class="nav-item"><a class="nav-link" href="/reader/book/borrow/"> 我的借阅</a></li>
                    <li class="nav-item"><a class="nav-link" href="/user/personalize"> 个性化设置</a></li>

                    <#if user.getAccessLevel() gte 100>
                        <li class="nav-item"><a class="nav-link" href="/admin/book/"> 图书管理</a></li>
                        <li class="nav-item"><a class="nav-link" href="/admin/user/"> 用户管理</a></li>
                        <li class="nav-item"><a class="nav-link" href="/admin/setting/"> 系统设置</a></li>
                    </#if>
                <#else>
                    <li class="nav-item"><a class="nav-link" href="/user/login"> 登录</a></li>
                    <li class="nav-item"><a class="nav-link" href="/user/register"> 注册</a></li>
                    <li class="nav-item"><a class="nav-link" href="/user/password/reset"> 忘记密码</a></li>
            </#if>
    </div>
    <script type="text/javascript">
        $(".nav-link[href$='/Home/User/login']").addClass('active');
    </script>
</div>