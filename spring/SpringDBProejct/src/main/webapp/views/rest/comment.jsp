<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comment</title>
</head>
<body>
  <h1>Comment Window</h1>

  <section>
    User : <input type="text" name="userId"> <br>
    <textarea name="text" id="" cols="30" rows="10"></textarea> <br>
    <input type="button" value="comment">
  </section>

  User : <input id="userId" type="text"> <input id="searchBtn" type="button" value="조회">
  <section id="user_comments">
    <div>
      <b>Comment : </b>
      <b>Write Date : </b>
    </div>
  </section>

  <section id="comments">

  </section>
</body>
</html>

<script>
  const userIdSearchInput = document.getElementById('userId');
  const userIdSearchBtn = document.getElementById('searchBtn');
  const userCommentSection = document.getElementById('user_comments');

  const section = document.querySelector('section');
  const userIdInput = section.querySelector('input');
  const commentTextarea = section.querySelector('textarea');
  const submitButton = section.querySelector('input[type=button]');
  const request = new XMLHttpRequest();
  const commentsSection = document.getElementById('comments');

  // get_all_comments();

  submitButton.onclick = () => {
    post_comment_fetch();
  };
  userIdSearchBtn.onclick = () => {
    get_comments_of_user(userIdSearchInput.value);
  }

  function get_comments_of_user(userID){
    if(userID === ''){
      return;
    }
    request.open('GET', '/comment/' + userID);
    request.send();
    request.onload = () => {
      create_comment(userCommentSection, JSON.parse(request.responseText));
    }
  }

  function get_all_comments() {
    request.open('GET', '/comment');
    request.send();
    request.onload = () => {
      const JSONData = JSON.parse(request.responseText);  // 비동기라서 JSONData를 반환하면 안된다??
      create_comment(commentsSection, JSONData);
    }
  }

  get_all_comments_fetch();
  function get_all_comments_fetch() {
    fetch('/comment')
            .then(response => response.json())
            .then(result => {console.log(result)})
            .catch(reason => {console.log('Request is failed. : ' + reason)});

    // request.open('GET', '/comment');
    // request.send();
    // request.onload = () => {
    //   const JSONData = JSON.parse(request.responseText);  // 비동기라서 JSONData를 반환하면 안된다??
    //   create_comment(commentsSection, JSONData);
    // }
  }

  function post_comment() {
    if(commentTextarea.value === '' || userIdInput.value === ''){
      alert('Please write something.');
      return;
    }
    const requestData = { userId: userIdInput.value, text: commentTextarea.value };
    request.open('POST', '/comment');
    request.setRequestHeader("Content-type", 'application/json');
    request.send(JSON.stringify(requestData));
    request.onload = get_all_comments;
    alert("Comment posted successfully.");

    // POST
    // 1. XMLHttpRequest() 객체를 받아온다.
    // 2. open
    // 3. header를 설정한다. content-type은 application/json
    // 4. 전송 !
  }

  function post_comment_fetch(){
    if(commentTextarea.value === '' || userIdInput.value === ''){
      alert("뭐라도 적어라~");
      return;
    }
    const requestData = { userID: userIdInput.value, text: commentTextarea.value }
    fetch('/comment', {
              method: 'POST',
              headers: { "Content-type": "application/json" },
              body: JSON.stringify(requestData)
            }
    ).then(response => {
      if(!response.ok) throw new Error(response.statusText);
      return response.text();
    }).then(result => {get_all_comments();});

    alert("댓글 작성 완료!");
  }


  function create_comment(section, commentList) {
    section.innerHTML = '';
    for(let i = 0; i < commentList.length; i++) {
      section.insertAdjacentHTML('beforeend',
              `<div>
                <h4>No. ` + i + ` </h4>
                <span> ` + commentList[i].userId + `</span>
                <span>` + commentList[i].text + `</span>
                <span>` + commentList[i].writeDate + `</span>
              </div>`
      );
    }
  }

</script>
