<%--
  Created by IntelliJ IDEA.
  User: Bahish
  Date: 08.08.2021
  Time: 21:38
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
  <link rel="stylesheet" href="resources/css/notFound.css" type="text/css">
  <title>Not Found</title>
</head>
<body>
  <div class="container">
    <div class="wrapper">
      <h4 class="upPage">The Page you are looking for can't be found.</h4>
      <h1 class="middlePage">404</h1>
      <h2 class="downPage">${message}</h2>
    </div>
  </div>
</body>
</html>
