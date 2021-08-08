<%--
  Created by IntelliJ IDEA.
  User: Bahish
  Date: 07.08.2021
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>mySpace</title>
</head>
<body>
    <h2>authorization</h2>
    <form method="post" action="<c:url value="/authorization"/>">
        <input type="text" name="login">
        <input type="password" name="password">
        <input type="submit" value="Log In">
    </form>

</body>
</html>
