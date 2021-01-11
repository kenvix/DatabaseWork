<#import "../../common/layout.ftl" as layout />
<@layout.layout title="标题">
    <!-- Begin Page code -->
            <div class="col-lg main" role="main">
                <div class="card">
                    <div class="card-header">登录 ${siteName}</div>
                    <div class="card-body" id="loginData">
                        <div class="alert alert-info ajax-info" role="alert" style="display: none;">
                            <div class="ajax-info-text" id="prompt-text">提示信息</div>
                        </div>
                        <form id="login-form" action="/user/login/action" method="post" enctype="application/x-www-form-urlencoded">
                            <div class="alert alert-info ajax-info" role="alert">
                                <div class="ajax-info-text"></div>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="username" id="login-username" required maxlength="25" placeholder="学号或邮箱">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="password" id="login-password" required placeholder="密码">
                            </div>
                            <label>
                                <input type="checkbox" name="remember" id="login-remember" value="1">
                                记住我 [ 30 天内有效 ]
                            </label>
                            <p><input type="submit" class="btn btn-primary" value="立即登录" id="submitBtn"></p>
                            <a href="/user/register">没有账号？点击注册</a>
                            <script>
                                // $(document).ready(function() {
                                //     $("#login-form").submit(function(e) {
                                //         e.preventDefault();
                                //         var obj = $(this);
                                //
                                //         var username = $("#login-username").val();
                                //         var password = $("#login-password").val();
                                //         var remember = $("#login-remember").is(":checked");
                                //         var data = new FormData();
                                //
                                //         // If you want to add an extra field for the FormData
                                //         data.append("username", username);
                                //         data.append("password", password);
                                //         data.append("remember", remember);
                                //
                                //         $.ajax({
                                //             url: "/api/v1/session",
                                //             type: "POST",
                                //             contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                                //             enctype: 'multipart/form-data',
                                //             data: data,
                                //             dataType: "application/json; charset=UTF-8",
                                //             success: function(result) {
                                //                 $("#prompt-text").append(result.info);
                                //                 window.location = "/"; //跳转
                                //             },
                                //
                                //             error: function(result){
                                //                 $("#prompt-text").append(result.info);
                                //             }
                                //         })
                                //         return false;
                                //     })
                                // });
                            </script>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End of page code -->
</@layout.layout>