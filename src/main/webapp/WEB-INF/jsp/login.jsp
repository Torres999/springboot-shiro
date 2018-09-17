<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
</head>
<body>
<form action="/shiro/submitLogin" method="post">
    <p>
        账号：<input type="text" name="username" id="username" value="Mark"/>
    </p>
    <p>
        <%--密码：<input type="text" name="password" id="password" value="73332c2309411ee1eff007207d846712"/>--%>
        密码：<input type="text" name="password" id="password" value="1234567"/>
    </p>
    <p>
        <input type="checkbox" checked="checked" name="rememberMe" id="rememberMe" style="width: 10px; height: 10px;">记住我
        <input type="submit" value="登录"/>
    </p>

</form>
</body>
</html>