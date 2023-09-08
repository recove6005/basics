<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>model.jsp</title>
</head>
<body>
    ${sessionScope.get("id")}
    ${sessionScope.get("pw")}

    <h1>This is model.</h1>

    <%--    @GetMapping("/model")에서 가져온 값을 다시 다른 곳으로 보냄.--%>
    <form action="">
        <input type="hidden" value="${password}">
    </form>

    <%--    @getMapping("/model") 에서 값을 바로 가져옴.--%>
    <b>ADDR : </b> ${requestScope.get("addr")} <br>
    <b>MESSAGE : </b> ${requestScope.get("message")} <br>
</body>
</html>
