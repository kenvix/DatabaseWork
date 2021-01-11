<#import "../../common/layout.ftl" as layout />
<@layout.layout title="标题">
    <!-- Begin Page code -->



        <div class="col-lg main" role="main">
            <div class="card">
                <div class="card-header">更改 library 用户中心 密码 ${siteName}</div>
                <div class="card-body" id="aboutInfo">
                    <p>你正在修改你在用户中心的密码。如果你不需要修改密码，请离开此页面。</p>
                    <p>修改密码后需要重新在启动器输入密码</p>
                </div>
            </div>

            <div class="card">
                <div class="card-header">更改 library 用户中心 密码</div>
                <div class="card-body" id="changePwInfo">
                    <form ajax="true" action="/Home/User/changePwAction" method="post"
                          onsubmit="return checkPwdOnSubmit();">
                        <div class="alert alert-info ajax-info" role="alert">
                            <div class="ajax-info-text"></div>
                        </div>

                        <div class="form-group">
                            <input type="password" class="form-control" name="oldpw" required="" maxlength="20"
                                   placeholder="原密码">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="newpw" id="pw" required=""
                                   placeholder="新密码">
                        </div>

                        <div class="form-group">
                            <input type="password" class="form-control" name="newpw2" id="pw2" placeholder="再次输入密码"
                                   required="">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control ajax-code-input" name="code"
                                   placeholder="输入下图的验证码，看不清可以点击图片更换" required="" maxlength="5">
                        </div>
                        <p>
                            <img src="img/genVerifyCode1.gif" id="changePwdVC" onclick="this.src = this.src;"
                                 title="点击更换验证码" width="220" height="62" class="img-thumbnail ajax-code-img">
                        </p>
                        <input type="submit" class="btn btn-success" value="提交更改">
                        <input type="hidden" name="MOERCEXTREDG"
                               value="a0519252763c39c18a652fd593124bdc_66bfaa637b9b3952eaa11f295bed5d43" />
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
            </script>        </div><!-- .main -->
    </div><!-- .row -->
</div><!-- .container-main -->


    <!-- End of page code -->
</@layout.layout>