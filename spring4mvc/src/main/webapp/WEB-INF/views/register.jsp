<%--
  Created by IntelliJ IDEA.
  User: CS
  Date: 2018/4/11
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="/spittles/register" method="post">
    name:<input type="text" name="name"/><br/>
    id:<input type="text" name="id"/><br/>
    <%--file: <input type="file" name="mfile" accept="*/*"><br/>--%>
    <input type="submit" value="register">
</form>
</body>
</html>
