let div = document.querySelector('div');

function add_a_tag() {
    // document.createElement();
    let aTagString = '<a href="https://www.naver.com">네이버로이동</a>'
    div.innerHTML += aTagString;

}
function remove_a_tag() {
    div.innerHTML = '';
}

function create_a_tag() {
    let aTag = document.createElement('a');

    // 태그 속성에 값을 지정 - 가져오기
    aTag.href = "https://www.naver.com";
    aTag.href;

    // 태그의 속성에 값을 지정 - 가져오기
    aTag.setAttribute('href', 'https://google.com');
    aTag.getAttribute('href');

    // a 태그 내부에 글자 넣기
    aTag.textContent = 'to google!';


    div.appendChild(aTag); // div의 자식 요소로 a 태그를 넣음.
}










