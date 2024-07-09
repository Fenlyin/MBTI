<%--
  Created by IntelliJ IDEA.
  User: jinxi
  Date: 2024/7/8
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h3>MBTI职业性格测试系统</h3>
<%--    登录表单--%>
    <form action="users?opr=login" method="post">
      用户名:<input name="login"/> <br/>
      密码：<input type="password" name="passwd"/>
      <input type="submit"/>
    </form>
  </body>
</html>
