<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: moonpeter
  Date: 2021/03/08
  Time: 3:21 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function go(id) {
            if (confirm("정말 삭제하시겠습니까?")) {
                location.href = "delete.net?id=" + id
            }
        }
    </script>
</head>
<body>
<div class="container">
    <table class="table">
        <fieldset>
            <legend>회원 리스트</legend>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>수정</th>
            <th>삭제</th>
            <c:forEach var="l" items="${list}">
                <tr>
                    <td>${l.id}</td>
                    <td>${l.password}</td>
                    <td><button class="btn btn-info" type="button" onclick='location.href="updateForm.net?id=${l.id }"'>수정</button></td>
                    <td>
                        <c:if test="${l.id!='admin'}">
                            <button class="btn btn-danger" type="button" onclick="go('${l.id}')">삭제</button>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </fieldset>
    </table>
</div>
<a href="main.net">메인으로</a>
</body>
</html>
