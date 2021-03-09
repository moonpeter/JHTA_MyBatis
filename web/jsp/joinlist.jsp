<%--
  Created by IntelliJ IDEA.
  User: moonpeter
  Date: 2021/03/09
  Time: 4:32 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <c:if test="${!empty list }">
        <table class="table table-striped">
            <tr>
                <td>조건문</td>
                <td colspan="5">
                    <c:if test="${!empty start && !empty end}">
                        <div class="red">
                            입사일:${start} ~ ${end}
                        </div>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>이름</td>
                <td>사원번호</td>
                <td>직업</td>
                <td>입사일</td>
                <td>커미션</td>
                <td>부서번호</td>
                <td>지역</td>
                <td>부서명</td>
            </tr>
            <c:forEach items="${list}" var="join">
                <tr>
                    <td>${join.emp.ename}</td>
                    <td>${join.emp.empno}</td>
                    <td>${join.emp.job}</td>
                    <td>${join.emp.hiredate}</td>
                    <td>${join.emp.comm}</td>
                    <td>${join.emp.deptno}</td>
                    <td>${join.dept.loc}</td>
                    <td>${join.dept.dname}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty list }">
        조건을 만족하는 데이터가 없습니다.
    </c:if>
</div>
</body>
</html>
