<%@ page contentType="text/html; charset=UTF-8"  isELIgnored="false" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
    <title>Todo Read</title>
    </head>
    <body>
        <div>
            <input type="text" name="tno" value="${dto.tno}" readonly />
        </div>
        <div>
            <input type="text" name="title" value="${dto.title}" readonly />
        </div>
        <div>
            <input type="date" name="localDate" value="${dto.localDate}" />
        </div>
        <div>
            <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} readonly />
        </div>

        <div>
            <a href="/todo/modify?tno=${dto.tno}">수정/삭제</a>
            <a href="/todo/list">리스트</a>
        </div>
    </body>
</html>