<%--
  Created by IntelliJ IDEA.
  User: moonpeter
  Date: 2021/03/09
  Time: 4:23 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/join.net" method="post">
    <label>name</label>
    <input type="text" name="name">
    <input type="submit" value="검색">
</form>
</body>
</html>
