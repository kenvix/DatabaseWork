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
    <title>${title}</title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-white navbar-main">
    <div class="container">
        <a class="navbar-brand" href="/">${title}</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">

            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="javascript:window.history.go(-1);" class="nav-link" role="button">
                        <i class="bi bi-skip-backward-fill"></i>
                        返回上页
                    </a>
                </li>
        </div>
    </div>
</nav>

<script type="text/javascript">
    page = 1;
    totalPage = 10;
</script>

<div class="container container-main flex-grow-1">
    <div class="row">
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