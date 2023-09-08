<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ko">
<head>
    <title>Title</title>
</head>
<body>
<main>
    <b>번호</b> <input type="text" value="${board.no}" readonly disabled> <br/>
    제목 <input type="text" value="${board.title}" readonly disabled> <br/>
    작성자 <input type="text" value="${board.userID}" readonly disabled> <br/>
    작성일 <input type="text" value="${board.writeDate}" readonly disabled> <br/>
    조회수 <input type="text" value="${board.count}" readonly disabled> <br/>
    메인 이미지: <img src="/board/file/${mainImage}" alt="메인이미지" width="300"> <br/>
    <div>
        첨부파일 리스트 :
        <c:forEach items="${normalFiles}" var="normalFile">
            <a href="/board/file/${normalFile}" download="${normalFile}">${normalFile}</a>
        </c:forEach>
    </div>

    <textarea rows="5" cols="20" readonly disabled>
        ${board.content}
    </textarea>
    <a href="/board/main">돌아가기</a> <a href="/board/delete?no=${board.no}">삭제</a> <a href="/board/update?no=${board.no}">수정</a>
</main>
</body>
</html>
