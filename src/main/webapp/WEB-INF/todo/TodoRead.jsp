<%@ page contentType="text/html; charset=UTF-8"  isELIgnored="false" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
    <title>Todo Read</title>
    </head>
    <body>

        <div>${dto.tno}</div>
        <div>${dto.title}</div>
        <div>${dto.localDate}</div>
        <div>${dto.finished}</div>

    </body>
</html>