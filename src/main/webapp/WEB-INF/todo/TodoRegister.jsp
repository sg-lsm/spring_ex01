<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
    <head>
    <title>Todo Register</title>
    </head>
    <body>
        <form action="/todo/regist" method="POST">
            <div>
                <input type="text" name="title" placeholder="제목입력" />
            </div>
            <div>
                <input type="date" name="localDate" />
            </div>
            <div>
                <button type="reset">초기화</button>
                <button type="submit">제출</button>
            </div>
        </form>
    </body>
</html>