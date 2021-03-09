<%--
  Created by IntelliJ IDEA.
  User: moonpeter
  Date: 2021/03/05
  Time: 4:47 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <style>
        body{text-align: center}
        a{text-decoration: none}
    </style>
</head>
<body>
<c:if test="${empty sessionScope.id}">
    <script>
        location.href="loginForm.net"
    </script>
</c:if>

<h2>로그인 되었습니다.</h2> <a href="logout.net">로그아웃</a>
<hr>
<c:if test="${sessionScope.id=='admin'}">
    <c:out value="관리자모드!"><br>
    </c:out>
    <a href="list.net">회원명단</a><br>
</c:if>

</body>
</html>
