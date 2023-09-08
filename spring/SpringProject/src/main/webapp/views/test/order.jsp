<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>order.jsp</title>
</head>
<body>
    ${error}
    <h1>IT 카테고리</h1>
    <form action="/order/it">
        Order : <input type="text" name="order">
        Wanted Price(under) : <input type="text" name="price">
        <button>send</button>
    </form>

    <h1>FOOD 카테고리</h1>
    <form action="/order/food">
        Order : <input type="text" name="order">
        Wanted Price(under) : <input type="text" name="price">
        <button>send</button>
    </form>
</body>
</html>