<#import "common/layout_simple.ftl" as layout />
<@layout.layout title="操作成功">
    <!-- Begin Page code -->
    <div class="card">
        <div class="card-header">操作成功</div>
        <div class="card-body" id="aboutInfo">
            <p>
                ${msg}
            </p>
            <p><button type="button" class="btn btn-outline-success btn-xs" onclick="window.history.go(-1);">返回上一页</button></p>
        </div>
    </div>
    <!-- End of page code -->
</@layout.layout>