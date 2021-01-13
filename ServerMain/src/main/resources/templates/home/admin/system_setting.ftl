<#import "../../common/layout.ftl" as layout />
<@layout.layout title="系统设置">
    <!-- Begin Page code -->
    <div class="card">
        <div class="card-header">
            修改系统设置
        </div>
        <div class="card-body" id="loginData">
            <p><b>警告：</b> 错误的设置可能导致某些功能出错，请谨慎修改。有些设置结果已缓存，必须重新启动才能生效</p>

            <form action="" method="post" enctype="application/x-www-form-urlencoded">
                <#list settings as item>
                    <div class="form-group">
                        <label for="setting-${item.getKey()}">${item.getDescription()}</label>
                        <input type="text" class="form-control" name="${item.getKey()}" id="setting-${item.getKey()}" value="${item.getValue()}" required="required">
                    </div>
                </#list>

                <p><input type="submit" class="btn btn-success" value="提交修改" id="submitBtn"></p>
            </form>
        </div>
    </div>
</@layout.layout>