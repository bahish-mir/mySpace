<%--
  Created by IntelliJ IDEA.
  User: Bahish
  Date: 08.08.2021
  Time: 21:42
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
    <link rel="stylesheet" href="resources/css/main.css" type="text/css">
    <title>MySpace</title>
</head>
<body>

    <div class="container">
            <c:if test="${empty articles}">
                <div class="someContent">
                    <span class="emptyArticles">${user.name} don't have articles!</span>
                </div>
            </c:if>
            <c:if test="${not empty articles}">
                <div class="wrapper">
                    <c:forEach var="article" items="${articles}">
                        <div class="card">
                            <div class="header">
                                <span class="sample">header</span>
                                <span>${article.header}</span>
                            </div>

                            <div class="dateCreate">
                                <span class="sample">date create</span>
                                <span>${article.dateCreate}</span>
                            </div>

                            <div class="author">
                                <span class="sample">author</span>
                                <span>${article.author}</span>
                            </div>

                            <a href=" <c:url value="/showArticle"/> ">read more...</a>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
    </div>

</body>
</html>
