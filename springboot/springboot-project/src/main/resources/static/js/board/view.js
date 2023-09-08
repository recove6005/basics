const writeSection = document.getElementById('comment_write');
const commentSection = document.getElementById('comment');
const boardNoInput = document.getElementById('board-no');
const writeBtn = writeSection.querySelector('input[type=button]');
const pagingUl = document.getElementById('paging-ul');


// 페이지 첫 접속시 댓글들을 모두 가져와서 출력
get_comments(1);
writeBtn.onclick = post_comment();

// 게시물 작성
function post_comment() {
    // 내가 필요한 요소들을 가져옴.
    const [titleInput, writerInput, writeBtn] = writeSection.getElementsByTagName('input');
    const contentsArea = writeSection.querySelector('textarea');
    // 가져온 요소들로 원하는 정보를 객체로 생성
    const requestDate = {
        boardNo:boardNoInput.value,
        title:titleInput.value,
        userID:writerInput.value,
        text:contentsArea.value
    };
    const JSONData = JSON.stringify(requestDate);
    // 생성된 데이터를 요청에 실어서 POST요청
    fetch('/comment', {
        method: 'POST',
        headers: {'Content-type': "application/json"},
        body: JSONData
    })
        .then(response => {get_comments();}) // 성공 : 댓글 작성 성공 시, 댓글들을 재로딩
        .catch(); // 실패
}


// 전체 게시물 조회
// 게시물 작성 시, 게시물 read 시 동작
function get_comments() {
    // GET 요청으로 모든 게시물의 모든 댓글 객체를 받아옴
    fetch(`/comment/${boardNoInput.value}?boardNo=1`)
        .then(response => response.json()) // 성공 : 요청의 결과로 받아온 JSON 객체를 JS 객체로 변환
        .then(obj => create_comments_view(obj)) // 변환된 obj(받아온 모든 댓글 리스트)를 views의 댓글 섹션에 전달
        .catch(); // 실패
}

// 하나의 댓글을 수정하는 기능
function update_comments(updateInput, no) {
    // 유저가 수정한 textarea의 value값
    updateInput.parentElement.nextElementSibling.value;
    // 1. 댓글 no 조회
    // 2. DB에 해당 댓글 no 수정 요청 => 수정할 내용 전달
    fetch(`/comment/${no}`, {
        method: "PUT",
        headers: {'Content-type':'application/json'},
        body: JSON.stringify({text: text})
    })
        // 요청 성공 : 댓글 전체 재로딩
        .then(response => { get_comments(); })
        .catch();
}

// 하나의 댓글을 삭제하는 기능
function delete_comments() {
    // 1. 댓글 no 조회
    // 2. DB에 해당 댓글 no 삭제 요청
    fetch(`/comment/${no}`, {
        method: "DELETE"
    })
        //요청이 성공했다면 모든 댓글을 재 로딩한다
        .then(response => { get_comments(); })
        .catch();
}


// 서버에 요청해서 받아온 객체들을 화면에 보여주는 함수 => 화면을 생성
// POST 혹은 GET 요청마다 동작
function create_comments_view(commentSectionObject){
    const commentsList = commentSectionObject.commentDTOList;

    commentSection.innerHTML = ''; //일단 댓글 전부 화면에서 제거한다
    // 댓글 화면 재 생성
    for (const comment of commentsList) {
        commentSection.insertAdjacentHTML('beforeend',
            `<div>
                <div>
                    <span>${comment.title}</span> 
                    <span>${comment.userID}</span> 
                    <span>${comment.writeDate}</span> 
                    <input type="button" value="수정" onclick="update_comments(this, ${comment.no})"> 
                    <input type="button" value="삭제" onclick="delete_comments(${comment.no})">
                </div>
                <textarea cols="50" rows="3">${comment.text}</textarea>
            </div>`);
    }

    // 페이징 화면 재 생성
    pagingUl.innerHTML = '';
    const startIndex = commentSectionObject.startPageNum;
    const endIndex = commentSectionObject.endPageNum;
    for (let i =  startIndex; i <= endIndex; i++) {
        pagingUl.insertAdjacentHTML('beforeend',
            `<li style="display: inline-block">
                    <a href="/comment/${boardNoInput.value}?pageNo=${i}">${i}</a>
                </li>`
        );
    }
}