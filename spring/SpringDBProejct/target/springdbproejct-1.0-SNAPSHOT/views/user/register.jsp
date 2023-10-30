<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ko">
<head>
    <title>Title</title>
</head>
<body>
<h1>회원가입창</h1>
${idMessage}
${nickMessage}
<form action="/user/register" method="post">
    ID: <input type="text" name="id"> <br/>
    PW: <input type="text" name="pw"> <br/>
    NICKNAME: <input type="text" name="nickName"> <br/>
    <button>회원가입</button>
</form>
</body>
</html>
