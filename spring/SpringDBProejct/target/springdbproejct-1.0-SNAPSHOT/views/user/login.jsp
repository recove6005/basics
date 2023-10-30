<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ko">
<head>
    <title>LOGIN창</title>
</head>
<body>
<form action="/user/login" method="post">
    ID: <input type="text" name="id"> <br/>
    PW: <input type="text" name="pw"> <br/>
    <button>로그인</button>
    <a href="/user/register">회원가입</a>
</form>
</body>
</html>
