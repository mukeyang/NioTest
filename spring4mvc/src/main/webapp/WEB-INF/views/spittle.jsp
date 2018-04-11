<%--
  Created by IntelliJ IDEA.
  User: CS
  Date: 2018/4/9
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>spittles</title>
</head>
<body>
<%--<%--%>
    <%--System.out.println("123124");--%>
<%--%>--%>
<label>hh</label>
<c:forEach items="${list}" var="spittle">
    <label value="spittle_<c:out value="spittle.id"/>">"spittle_<c:out value="${spittle.id}"/>"</label>
    </c:forEach>
</body>
</html>
