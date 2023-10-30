<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login.jsp</title>
</head>
<body>
    ${message}

    <form action="/user/login" method="post">
        <input type="text" name="id" value="korea">
        <input type="password" name="pw" value="a123">
        <button>Go!</button>
    </form>
</body>
</html>
