<%@ page contentType="text/html; charset=UTF-8"  isELIgnored="false" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>

    <head>
        <title>Login</title>
    </head>

    <body>
        <c:if test="${param.result == 'error'}">
            <h1>로그인 에러</h1>
        </c:if>
        <h2>${loginInfo}</h2>
        <h3>${loginInfo.mname}</h3>

        <form action="/login" method="post">
            <input type="text" name="mid" />
            <input type="text" name="mpw" />
            <input type="checkbox" name="auto" />
            <button type="submit">LOGIN</button>
        </form>
    </body>

</html>