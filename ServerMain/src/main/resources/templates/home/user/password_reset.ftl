<#import "../../common/layout.ftl" as layout />
<@layout.layout title="密码重置">
    <!-- Begin Page code -->

                <div class="card">
                    <div class="card-header">重置 ${siteName} 密码</div>
                    <div class="card-body" id="aboutInfo">
                        <p>首先，输入你的邮箱来重置密码。</p>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">重置 ${siteName} 密码</div>
                    <div class="card-body" id="changePwInfo">
                        <form ajax="true" action="/Home/User/changePwAction" method="post"
                              onsubmit="return checkPwdOnSubmit();">
                            <div class="alert alert-info ajax-info" role="alert">
                                <div class="ajax-info-text"></div>
                            </div>

                            <div class="form-group">
                                <input type="email" class="form-control" name="oldpw" required="" maxlength="20"
                                       placeholder="电子邮箱">
                            </div>
                            <input type="submit" class="btn btn-success" value="提交">
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
                </script>

    <!-- End of page code -->
</@layout.layout>