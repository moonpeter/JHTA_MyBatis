<%--
  Created by IntelliJ IDEA.
  User: moonpeter
  Date: 2021/03/05
  Time: 4:48 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="updatePro.net">
        <h1>정보 수정</h1>
        <hr>
        <div class="form-group">
            <b>아이디</b>
            <input type="text" name="id" value="${id}" maxlength="10" readonly class="form-control">
            <b>Password</b>
            <input type="text" name="password" value="${password}" class="form-control">
        </div>
        <div class="clearfix">
            <button type="submit">변경</button>
            <button type="button" onclick="history.go(-1)">취소</button>
        </div>
    </form>
</div>
</body>
</html>
