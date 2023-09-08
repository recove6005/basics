let form0 = document.forms.item(0);

// name 속성 : 서버와 연결할 때 씀.
const date = form0.date;
const file = form0.file;
const mobile = form0.mobile;

function get_data() {
    console.log(date.value);
    console.log(file.value);
    console.log(mobile.value);
}

let form1 = document.forms.item(1);

const color = form1.color;
const bgColor = form1.bgcolor;
const area = form1.area;
function set_data() {
    console.log(color.value);
    area.style.color = color.value;
    console.log(bgColor.value);
    area.style.backgroundColor = bgColor.value;
    console.log(area.value);
}

// 데이터 전송 함수 .method
function send_data() {
    form1.action = 'Practice3_JS8.html';
    form1.method = 'post';
    form1.target = '_blank';
    form1.submit(); // .submit() : 폼을 전송하는 메소드
    // form1.reset(); // 리셋 버튼
}


const bodyChild = document.getElementsByTagName('input');
// HTMLCollection을 배열 형태로 ~
[...bodyChild];
Array.from(bodyChild);

// TreeWalker : NodeIterator(위에서 밑으로 정방향) 의 상위 버전




