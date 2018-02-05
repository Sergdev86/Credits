<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 29.01.2018
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

  <h1>USER PAGE</h1>
<%--<a href="<c:url value="/logout" />">Logout</a>--%>
  <a onclick="document.forms['logoutForm'].submit()">Logout</a>
</body>
</html>
