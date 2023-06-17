<%@ page contentType="text/html; charset=utf8" isELIgnored="false" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>list</title>
    <body>
        <h2>list page</h4>
        <h2>"${appName}"</h2>
        <h3>"${loginInfo}"</h3>
        <h3>"${loginInfo.mname}"</h3>
        <ul>
            <c:forEach var="dto" items="${dtoList}">
                <li>
                    <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
                    <span>${dto.title}</span>
                    <span>${dto.tno}</span>
                    <span>${dto.finished ? "DONE" : "NOT YET"}</span>
                </li>
            </c:forEach>
        </ul>
        <form action="/logout" method="post">
           <button>Logout</button>
        </form>
    </body>
</head>
</html>