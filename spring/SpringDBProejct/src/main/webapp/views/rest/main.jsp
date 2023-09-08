<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rest Main</title>
</head>

<body>
    <input type="text" name="id"> <br>
    <input type="password" name="pw"> <br>
    <input type="text" name="nickName"> <br>
    <input type="date" name="registDate"> <br>
    <input type="button" value="Send!"> <br>

    <form action="/rest/users">
        <button>Go!</button>
    </form>
</body>
</html>

<script>
    const [id, pw, nickName, registDate, button] = document.getElementsByTagName('input');
    // location.href = '/'; // GET요청
    button.addEventListener('click', () => {
        // input 데이터들을 JSON으로 변환
        const JSData = {
            "id": id.value,
            "pw": pw.value,
            "nickName": nickName.value,
            "registDate": registDate.value
        };

        const JSONData = JSON.stringify(JSData);
        const request = new XMLHttpRequest(); // 요청 객체 생성

        // POST 요청
        // request.open('POST', '/rest/user'); // /rest/user로 POST 요청
        // request.setRequestHeader('Content-type', 'application/json'); // POST요청이므로 content-type 설정, 전달하는 데이터는 json
        // request.send(JSONData); // JSON 데이터를 담은 후 post로 전송 및 요청
        // /rest/user는 @RequestBody 어노테이션을 사용해 파라미터를 전달 받음

        // GET 요청 1
        request.open('GET', '/rest/number');
        request.send(); // 비동기 요청이므로 응답이 올 때까지 텀이 있음
        // request.response; // null
        // request.addEventListener('load', () => {});
        request.onload = () => {
          console.log(request.responseText); // /rest/number의 123을 전달 받음
        };

        // GET 요청 2
        request.open('GET', '/rest/users');
        request.send();
        request.onload = () => {
            // /rest/users의 리스트를 JSON 형태로 반환받음
            // JSON.parse : JSON값을 객체 형태로 변환
            const responseData = JSON.parse(request.responseText);
            console.log(responseData);
        };


        console.log(JSONData);

    });
</script>