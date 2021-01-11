<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>OK</title>
</head>
<body>
    <h1>OK:${name}</h1>
    <form action="/api/v1/tools/test" method="post">
        <input type="text" name="test_in" value="114514">
        <input type="submit" value="Set Cookie" />
    </form>
    <p><img src="${public}/ktor_logo.svg"></p>
</body>
</html>