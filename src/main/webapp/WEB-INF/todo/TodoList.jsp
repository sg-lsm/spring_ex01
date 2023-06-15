<%@ page contentType="text/html; charset=utf8" isELIgnored="false" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>list</title>
    <body>
        <h2>list page</h4>
        <ul>
            <c:forEach var="dto" items="${dtoList}">
                <li>${dto}</li>
            </c:forEach>
        </ul>
    </body>
</head>
</html>