<#import "../../common/layout.ftl" as layout />
<@layout.layout title="注册页面">
    <!-- Begin Page code -->

            <div class="card">
                <div class="card-header">注册 ${siteName}</div>
                <div class="card-body" id="aboutInfo">
                    <p>您必须先注册一个账户才能使用本系统</p>
                    <p>用户名称最短为 3 位，最长为 20 位，只能包含英文字母、数字或下划线，不能有其他的特殊符号</p>
                    <form onsubmit="if ($('#user-password_confirm').val() != $('#user-password').val()) { alert('两次输入的密码不一致，请重新输入'); return false; } else { return true; }" class="clearfix" id="register-form" action="/user/register/action" method="post" enctype="application/x-www-form-urlencoded">
                        <div class="form-group">
                            <label for="user-username">学号</label>
                            <input type="text" class="form-control" name="username" id="user-username">
                        </div>

                        <div class="form-group">
                            <label for="user-real_name">真实姓名</label>
                            <input type="text" class="form-control" name="real_name" id="user-real_name">
                        </div>

                        <div class="form-group">
                            <label for="user-email">电子邮箱</label>
                            <input type="email" class="form-control" name="email" id="user-email">
                        </div>

                        <div class="form-group">
                            <label for="user-password">密码</label>
                            <input type="password" class="form-control" name="password" id="user-password" placeholder="您的密码将会使用 BCrypt 算法进行高强度不可逆加密，您无需担心密码泄露">
                        </div>

                        <div class="form-group">
                            <label for="user-password_confirm">确认密码</label>
                            <input type="password" class="form-control" name="password_confirm" id="user-password_confirm" placeholder="请再输一次密码">
                        </div>

                        <p><input type="submit" class="btn btn-success" value="立即注册" id="submitBtn"></p>
                    </form>
                </div>
            </div>
    <!-- End of page code -->
</@layout.layout>