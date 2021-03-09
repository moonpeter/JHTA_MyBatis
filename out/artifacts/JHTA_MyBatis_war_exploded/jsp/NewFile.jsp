<%--
  Created by IntelliJ IDEA.
  User: moonpeter
  Date: 2021/03/09
  Time: 9:11 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/term.net" method="post">
    <label>조회기간</label>
    <input type="date" name="startday" min="1980-01-01" max="1987-12-31">
    ~<input type="date" name="endday" min="1980-01-01" max="1987-12-31">
    <input type="submit" value="검색">
</form>
</body>
</html>
