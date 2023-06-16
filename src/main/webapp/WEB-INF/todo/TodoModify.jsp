<%@ page contentType="text/html;charaset=UTF-8" language="java" %>
<html>

<head>
    <title>Todo Modify</title>
</head>

<body>
    <form id="form1" action="/todo/modify" method="post">
    <div>
        <input type="text" name="tno" value="${dto.tno}" readonly />
    </div>
    <div>
        <input type="text" name="title" value="${dto.title}" />
    </div>
    <div>
        <input type="date" name="localDate" value="${dto.localDate}" />
    </div>
    <div>
        <input type="checkbox" name="finished" ${dto.finished ? "checkbox" : "" />
    </div>

    <div>
        <button type="submit">Modify</button>
    </div>
</form>

<form id="form2" action="/todo/remove" method="post">
    <input type="hidden" name="tno" value="${dto.tno}" readonly />
    <div>
        <button type="submit">Remove</button>
    </div>
</form>
</body>

</html>