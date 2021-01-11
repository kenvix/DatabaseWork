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
<#nested />

<footer>

</footer>
</body>
</html>
</#macro>