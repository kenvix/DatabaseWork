<#import "../../common/layout.ftl" as layout />
<@layout.layout title="登录页面">
    <!-- Begin Page code -->

        <div class="card">
            <div class="card-header">登录 Library 用户中心</div>
            <div class="card-body" id="loginData">
                <form id="login-form" action="/user/login/action" method="post" enctype="application/x-www-form-urlencoded">
                    <div class="alert alert-info ajax-info" role="alert">
                        <div class="ajax-info-text"></div>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="username" required maxlength="25"
                               placeholder="昵称或邮箱">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" id="pw" required placeholder="密码">
                    </div>
                    <div class="form-group">
                        <div class="custom-control custom-checkbox">
                            <input class="custom-control-input" type="checkbox" name="remember" id="rem" value="1">
                            <label class="custom-control-label" for="rem">记住我 [ 7天内有效 ]</label>
                        </div>
                    </div>
                    <p><input type="submit" class="btn btn-primary" value="立即登录" id="submitBtn"></p>
                    <a href="/user/register">没有账号？点击注册</a>
                    <input type="hidden" name="MOERCEXTREDG"
                           value="78fb64ba92c1d179f22bf9301603b094_0f17a73d26a4447b57e3fba226c46523" />
                    <script>
                        // $(document).ready(function() {
                        //     $("#login-form").submit(function(e) {
                        //         e.preventDefault();
                        //         var obj = $(this);
                        //         var name = $("input[name='username']").val();
                        //         var passwd = $("input[name='password']").val();
                        //         var data = new FormData(form);
                        //         // If you want to add an extra field for the FormData
                        //         data.append("username", name);
                        //         data.append("password", passwd);
                        //         $.ajax({
                        //             url : "/api/v1/action",
                        //             type : "POST",
                        //             contentType: "application/x-www-form-urlencoded;charset=utf-8",
                        //             enctype: 'multipart/form-data',
                        //             data : data,
                        //             dataType : "text",
                        //             success : function(result) {
                        //                 obj.parents('form').submit();
                        //             },
                        //             error:function(msg){
                        //                 $(".notice").html('Error:'+msg);
                        //             }
                        //         })
                        //         return false;
                        //     })
                        // })(jQuery);
                    </script>
                </form>
            </div>
        </div>

    <!-- End of page code -->
</@layout.layout>