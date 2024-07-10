<%--
  Created by IntelliJ IDEA.
  User: jinxi
  Date: 2024/7/9
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
主页,${sessionScope.get("login")}
<a href="users?opr=logout">退出登录</a>
</body>
</html>
