<#import "common/layout_simple.ftl" as layout />
<@layout.layout title="请稍候">
<!-- Begin Page code -->
    <meta http-equiv="refresh" content="0;url=${redirectUrl}">
    <div class="card">
        <div class="card-header">操作成功</div>
        <div class="card-body" id="aboutInfo">
            <p>${msg}</p>
            <p>正在跳转，请稍候</p>
            <p><button type="button" class="btn btn-outline-success btn-xs" onclick="window.location = '${redirectUrl}'">立即前往</button></p>
        </div>
    </div>
    <!-- End of page code -->
</@layout.layout>