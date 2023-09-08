<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ko">
<head>
    <title>파일 업로드 연습창</title>
</head>
<body>
<h1>파일 업로드 하자~</h1>
<form action="/file/upload" method="post" enctype="multipart/form-data">
    파일1 => <input type="file" name="myFile" multiple> <br/>
    파일2 => <input type="file" name="myFile"> <br/>
    파일3 => <input type="file" name="myFile"> <br/>
    <button>전달하기~</button>
</form>
</body>
</html>
