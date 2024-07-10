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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
  </head>
  <body>
    <h3>MBTI职业性格测试系统</h3>
<%--    登录表单--%>
    <form action="users?opr=login" method="post">
      用户名:<input name="login"/> <br/>
      密码：<input type="password" name="passwd"/>
      <input type="submit"/>
    </form>
    <div style="width: 500px">
      <form>
        <div class="form-group">
          <label for="exampleInputEmail1">用户名</label>
          <input type="text" name="login" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
          <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">密码</label>
          <input type="password" name="passwd" class="form-control" id="exampleInputPassword1">
        </div>
        <button type="submit" class="btn btn-primary">登录</button>
      </form>
    </div>
    <button type="button" class="btn btn-dark">Dark</button>

  </body>
</html>
