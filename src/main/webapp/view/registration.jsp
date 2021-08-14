<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bahish
  Date: 09.08.2021
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/css/registr.css" type="text/css">
    <title>MySpace</title>
</head>
<body>

    <div class="container">
        <div class="wrapper">
            <h1 class="registration">Authorization</h1>
            <form class="form" method="post" action="<c:url value="/registration"/>">
                <input type="text" name="login" placeholder="Login">
                <input type="password" name="password" placeholder="Password">
                <input class="input-submit" type="submit" value="Reg In">
            </form>
        </div>
    </div>

</body>
</html>
