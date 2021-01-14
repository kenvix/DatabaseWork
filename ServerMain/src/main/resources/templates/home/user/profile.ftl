<#import "../../common/layout.ftl" as layout />
<@layout.layout title="修改个人资料">
    <!-- Begin Page code -->
    <div class="card">
        <div class="card-header">
            <#if isEditOtherProfile??>
                修改用户资料 #${userExtra.getUid()}
                <#else>
                修改我的个人资料
            </#if>
        </div>
        <div class="card-body" id="loginData">
            <p>注册时间: ${userExtra.getCreatedAt()}</p>
            <p>注册 IP: ${userExtra.getIpCreation()}</p>
            <p>上次登录 IP: ${userExtra.getIpLogin()}</p>
            <p>权限：#${userExtra.getAccessLevel()} : ${userExtra.getAccessLevelDescription()}</p>

            <form action="" onsubmit="if ($('#user-password_confirm').val() != $('#user-password').val()) { alert('两次输入的密码不一致，请重新输入'); return false; } else { return true; }" method="post" enctype="application/x-www-form-urlencoded">
                <div class="form-group">
                    <label for="user-email">电子邮箱</label>
                    <input type="email" class="form-control" name="email" id="user-email" value="${userExtra.getEmail()!""}" required="required">
                </div>

                <div class="form-group">
                    <label for="user-serial_id">学号</label>
                    <input type="text" class="form-control" name="serial_id" id="user-serial_id" value="${userExtra.getSerialId()!""}" required="required">
                </div>

                <div class="form-group">
                    <label for="user-real_name">真实姓名</label>
                    <input type="text" class="form-control" name="real_name" id="user-real_name" value="${userExtra.getRealName()!""}" required="required">
                </div>

                <div class="form-group">
                    <label for="user-phone">手机号</label>
                    <input type="number" class="form-control" name="phone" id="user-phone" value="<#if userExtra.getPhone()??>${userExtra.getPhone()?long?c}</#if>">
                </div>

                <div class="form-group">
                    <label for="user-card_serial_id">卡片序列号</label>
                    <input type="number" class="form-control" name="card_serial_id" id="user-card_serial_id" value="<#if userExtra.getCardSerialId()??>${userExtra.getCardSerialId()?long?c}</#if>">
                </div>

                <div class="form-group">
                    <label for="user-start_year">入学年份</label>
                    <input type="number" class="form-control" name="start_year" id="user-start_year" value="<#if userExtra.getStartYear()??>${userExtra.getStartYear()?short?c}</#if>">
                </div>

                <div class="form-group">
                    <label for="user-department">所在部门或学院</label>
                    <input type="text" class="form-control" name="department" id="user-department" value="<#if userExtra.getDepartment()??>${userExtra.getDepartment()!""}</#if>">
                </div>

                <div class="form-group">
                    <label for="user-password">修改密码（如果不需要修改密码请留空）</label>
                    <input type="password" class="form-control" name="password" id="user-password" placeholder="如果不需要修改密码请留空">
                </div>

                <div class="form-group">
                    <label for="user-password_confirm">确认密码（如果不需要修改密码请留空）</label>
                    <input type="password" class="form-control" name="password_confirm" id="user-password_confirm" placeholder="如果不需要修改密码请留空">
                </div>

                <div class="form-group">
                    <label for="user-money">账户余额（单位：分）</label>
                    <input type="number" class="form-control" <#if !isEditOtherProfile??>disabled</#if> name="money" id="user-money" value="${userExtra.getMoney()?int?c!0}" required="required">
                </div>

                <p><input type="submit" class="btn btn-success" value="提交修改" id="submitBtn"></p>
            </form>
        </div>
    </div>

    <#if isEditOtherProfile??>
        <div class="card">
            <div class="card-header">
                危险操作
            </div>

            <div class="card-body" id="loginData">
                <form action="/admin/user/delete" enctype="application/x-www-form-urlencoded" method="post" onsubmit="return confirm('是否确实要删除此用户？此操作不可逆，并且系统将不再追踪借书情况，也不会退还余额。通常情况下您可以对此用户封号');">
                    <input type="hidden" name="uid" value="${userExtra.getUid()}">
                    <button type="submit" class="btn btn-danger">删除用户</button>
                </form>
            </div>
        </div>
    </#if>
</@layout.layout>