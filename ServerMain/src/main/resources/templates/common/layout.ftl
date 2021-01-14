<#setting date_format="yyyy-MM-dd">
<#setting time_format="HH:mm:ss">
<#setting datetime_format="yyyy-MM-dd HH:mm:ss">
<#setting locale="zh_CN">
<#macro layout title="[ERROR:NO TITLE]">
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8">
    <link rel="stylesheet" href="${public}/css/main.css">
    <script src="${public}/js/main.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Ubuntu:400,600">
    <title>${title} - ${siteName}</title>
</head>

<body>
<#include "navbar.ftl" />

<script type="text/javascript">
    page = 1;
    totalPage = 10;
</script>

<div class="container container-main flex-grow-1">
    <div class="row">
        <#include "sidebar.ftl" />

        <div class="col-lg main" role="main" >
        <#if msg??>
            <div class="alert alert-info alert-dismissible" role="alert" style="display: block;">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <div class="ajax-info-text">${msg}</div>
            </div>
        </#if>
        <#nested />
        </div>
    </div>
</div>

<#include "footer.ftl" />
</body>
</html>
</#macro>