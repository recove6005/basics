<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ko">
<head>
  <title>수정페이지</title>
</head>
<body>
<main>
  <form action="/board/update" method="post">
    <input type="hidden" value="${board.no}" name="no">
    <b>번호</b> <input type="text" value="${board.no}" readonly disabled> <br/>
    제목 <input type="text" value="${board.title}" name="title"> <br/>
    작성자 <input type="text" value="${board.userID}" readonly disabled> <br/>
    작성일 <input type="text" value="${board.writeDate}" readonly disabled> <br/>
    조회수 <input type="text" value="${board.count}" readonly disabled> <br/>
    <textarea rows="5" cols="20" name="content">
      ${board.content}
    </textarea>
    <a href="/board/view?no=${board.no}">돌아가기</a> <input type="submit" value="확인">
  </form>
</main>
</body>
</html>
