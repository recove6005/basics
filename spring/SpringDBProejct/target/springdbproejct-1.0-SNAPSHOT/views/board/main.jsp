<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ko">
<head>
    <title>게시판</title>
</head>
<body>

<h1>게시판!</h1>
<table border="1" width="500" align="center">
    <thead>
    <tr align="center">
        <td>번호</td>
        <td>제목</td>
        <td>작성자</td>
        <td>작성일</td>
        <td>조회수</td>
    </tr>
    </thead>

    <tbody align="center">
    <c:forEach var="board" items="${boards}" varStatus="index">
        <tr>
            <td>${index.count}</td>
            <td><a href="/board/view?no=${board.no}">${board.title}</a></td>
            <td>${board.userID}</td>
            <td>${board.writeDate}</td>
            <td>${board.count}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div align="center">
    <a href="/board/insert">글쓰기</a>
</div>
</body>
</html>
