/*** (1) ***/
const button1 = document.getElementsByClassName('btn1');
button1[0].addEventListener('click', function(e) {
    console.log(e.target); // e : 버튼 요소 자체(this)를 가져옴.
    e.target.nextElementSibling.style.backgroundColor = 'lightblue'; // 버튼 다음 요소의 스타일 변경.
});


/*** (2) ***/
const div = document.querySelector('div');
div.addEventListener('click', function (e) {
    console.log(e.target);
    console.log(e.currentTarget);
    e.target.style.backgroundColor = 'lightgreen'; // 이벤트를 실행하는 객체 -> 버튼
    e.currentTarget.style.backgroundColor = 'green'; // e 객체 -> 버튼의 부모 요소 div
});

const button2 = document.getElementsByClassName('btn2');

