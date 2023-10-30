<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ko">
<head>
    <title>Title</title>
</head>
<body>
<%--    ${data1}--%>

    <form action="/user/create" method="post">
        Name : <input type="text" name="name">
        Birth : <input type="date" name="birth">
        Age : <input type="text" name="age">
        <button>send</button>
    </form>

    <form action="/board" method="post">
        Today : <input type="date" name="today">
        C : <input type="checkbox" name="lang" value="C">
        Java : <input type="checkbox" name="lang" value="Java">
        Python : <input type="checkbox" name="lang" value="Python">
        <button>send</button>
    </form>

    <form action="/simple" method="post">
        <input type="text" name="nickName" value="hong gil dong">
        <input type="text" name="age" value="123">
        <button>GO</button>
    </form>
</body>
</html>