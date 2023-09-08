let textarea = document.querySelector('textarea');
let [button1, button2, button3] = document.getElementsByTagName('button');

/*** (1) ***/
function change_color1() {
    textarea.style.backgroundColor = 'purple';
}

// button2.onclick = change_color();
// 괄호 있을 시 함수를 항시 실행... (리턴값을 받음.)
// 따라서 콜백함수를 대입해야 함.
button2.onclick = change_color2;
function change_color2() {
    textarea.style.backgroundColor = 'green';
}


// addEventListener 또한 콜백함수를 전달해야 함~
button3.addEventListener('click', change_color3);
function change_color3() {
    textarea.style.backgroundColor = 'grey';
}
function change_text() {
    textarea.style.color = 'white';
}


/*** (2) ***/
// 함수 여러 개 실행~
// 1) 모든 함수를 실행하는 함수를 따로 만듦.
function all() {
    change_color3();
    change_text();
}
// 2) 이벤트 리스너 여러개 실행~
button3.addEventListener('click', change_color3);
button3.addEventListener('click', change_text);


// 이벤트 함수에 매개변수를 받을 때 => 콜백함수를 써야 한다면...?
// 매개변수를 전달하는 함수를 추가로 작성하거나,
// 이름 없는 함수, 화살표 함수를 만들어 쓰기.
function change_color4(bgColor) {
    textarea.style.backgroundColor = bgColor;
}
function test() {
    change_color4('blue');
}
button3.addEventListener('click', test);
button3.addEventListener('click', function () {}); // 함수 때려넣기 !
button3.addEventListener('click', () => {}); // 화살표 함수 때려넣기 !




/*** (3) ***/
// onclick 속성에 넣을 함수 매개변수에 this
function change_color5(element) {
    element.style.backgroundColor = 'red';
    // element(this)는 요소 자체를 가리킴
    // onclick 속성이 들어간 요소 자체의 스타일을 설정함.
}



