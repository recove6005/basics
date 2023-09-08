<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ko">
<head>
    <title>게시물작성</title>
</head>
<body>
<h1>!게시물 작성!</h1>
<form action="/board/insert" method="post" enctype="multipart/form-data">
    제목 <input type="text" value="${board.title}" name="title"> <br/>
    작성자 <input type="text" value="${board.userID}" name="userID"> <br/>
    업로드파일 <input type="file" name="fileDTO.fileName" multiple> <br/>
    메인이미지 <input type="file" name="fileDTO.mainImage"> <br/>
    내용 <textarea rows="5" cols="20" name="content"></textarea> <br/>
    <a href="/board/main">돌아가기</a> <input type="submit" value="확인">
</form>
</body>
</html>