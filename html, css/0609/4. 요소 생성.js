let div = document.querySelector('div');

function add_a_tag(){
    let aTagString = '<a href="https://www.naver.com">네이버로 이동!</a>'
    div.innerHTML += aTagString;

    // let aTag = document.createElement('a'); //a 태그 생성
    // // 태그 속성에 값을 지정
    // aTag.href = 'https://www.naver.com';
    // let aHREF = aTag.href; //속성 값 가져오기
    // // 태그의 속성에 값을 지정 (설정만)
    // aTag.setAttribute('href', 'https://google.com');
    // // 태그의 속성에 값을 가져옴 (가져오는것만)
    // aHREF = aTag.getAttribute('href');
    // // 태그 내부에 텍스트를 넣기!
    // aTag.textContent = '구글로 이동하기!';
    // // div에 자식으로 a태그를 넣는다
    // div.appendChild(aTag);
}

function remove_a_tag(){
    div.innerHTML = '';

}