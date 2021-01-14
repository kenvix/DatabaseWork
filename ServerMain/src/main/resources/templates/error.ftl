<#import "common/layout_simple.ftl" as layout />
<@layout.layout title="操作失败">
<!-- Begin Page code -->
<div class="card">
    <div class="card-header">操作失败</div>
    <div class="card-body" id="aboutInfo">
        <p  style="font-size: 2em; font-weight: bold;">${info}</p>
        <p><b>提示：</b>请检查输入是否有误、操作是否正确。</p>
        <p><button type="button" class="btn btn-outline-success btn-xs" onclick="window.history.go(-1);">返回上一页</button></p>
        <hr/>
        <p><span style="font-size: 1.1em; color: gray;">${code!0} ${description!"No description"}</span></p>

        <p>Additional stack trace information for developers</p>
        <pre>${trace!"No trace information"}</pre>
        <p><span style="font-size: 0.9em; color: gray;">To hide this part, please disable debug mode on Application EnvFile</span></p>
    </div>
</div>
<!-- End of page code -->
</@layout.layout>