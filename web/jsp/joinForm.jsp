<%--
  Created by IntelliJ IDEA.
  User: moonpeter
  Date: 2021/03/05
  Time: 4:47 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="joinPro.net" method="post">
    <h1>회원가입</h1>
    <hr>
    <b>아이디</b>
    <input type="text" name="id" maxlength="10" placeholder="Enter ID" required>
    <b>Password</b>
    <input type="password" name="password" placeholder="Enter password" required>
    <div class="clearfix">
        <button type="submit" class="join">회원가입</button>
        <button type="reset" class="cancel">취소</button>
    </div>
</form>
</body>
</html>
