<#import "../common/layout.ftl" as layout />
<@layout.layout title="首页">
    <!-- Begin Page code -->

    <div class="card">
        <div class="card-body" id="aboutInfo">
            <img title="你的 Gravatar 头像" src="https://cn.gravatar.com/avatar/${userEmailMd5}?s=128&d=mm" width="100" height="100"
                 class="img-thumbnail mb-3 ml-3 float-right d-none d-md-block">

            <h3 class="mb-3">首页</h3>
            <p>欢迎使用 ${siteName}</p>
            <p>当前共有 ${userTotalCount} 名用户，${bookTotalCount} 本藏书，累计借书 ${bookBorrowTotalCount} 次</p>
        </div>
    </div>

    <#if hasBookExpired??>
        <div class="alert alert-warning" role="alert" onclick="location = '/reader/book/borrow'">
        <p><span class="glyphicon glyphicon-warning-sign"></span> <b>有图书超期</b></p>
        您有图书超期，超期罚款将会不断累积，请及时还书。点击查看详情
    </div>
    </#if>

    <div class="card">
        <div class="card-header">账户资料 #${user.getUid()}</div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">
                <b>学号和姓名：</b>
                ${user.getSerialId()} - ${user.getRealName()}
            </li>
            <li class="list-group-item">
                <b>账户余额：</b>
                ${moneyInYuan}
            </li>
            <li class="list-group-item">
                <b>注册时间：</b>
                ${user.getCreatedAt()} IP: ${user.getIpCreation()}
            </li>
            <li class="list-group-item">
                <b>注册邮箱：</b>
                ${user.getEmail()!""}
            </li>
            <li class="list-group-item">
                <b>部门：</b>
                ${userExtra.getDepartment()!"无"} <#if userExtra.getStartYear()??>(${userExtra.getStartYear()?short?c})</#if>
            </li>
            <li class="list-group-item">
                <b>身份：</b>
                ${userExtra.getAccessLevelDescription()!"无"}
            </li>
        </ul>
    </div>

    <!-- End of page code -->
</@layout.layout>