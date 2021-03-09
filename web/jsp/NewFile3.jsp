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
<form action="${pageContext.request.contextPath}/term3.net" method="post">
    <label>조회기간</label>
    <input type="date" name="startday" min="1980-01-01" max="1987-12-31">
    ~<input type="date" name="endday" min="1980-01-01" max="1987-12-31"><br>

    <label>부서번호</label>
    <select name="deptno">
        <option value="">부서번호를 선택하세요</option>
        <option value="10">10</option>
        <option value="20">20</option>
        <option value="30">30</option>
        <option value="40">40</option>
    </select>
    <input type="submit" value="검색">
</form>
</body>
</html>
