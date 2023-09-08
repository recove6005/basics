let divs = document.getElementsByTagName('div');
let innerHTML = divs[0].innerHTML;
let innerText = divs[0].innerText;
let textContent = divs[0].textContent;

console.log('innerHTML:', innerHTML)
console.log('innerText:', innerText)
console.log('textContent:', textContent)
//divs[0]와 같음
divs.item(0).innerHTML = '<b>구글입니다</b>' + "<a href='http://'>구글로이동</a>";

// id로 정확하게 하나의 요소만 가져오기
let h1Tag = document.getElementById('title');
h1Tag.innerText = '바뀐 제목입니다';

//class 이름으로 가져오기
let [divBox, pBox] = document.getElementsByClassName('box');
console.log(divBox);
console.log(pBox);

//name 으로 가져오기
let select = document.getElementsByName('choose');

console.log(select[0]);

// 요소의 CSS 문법으로 하나의 요소 특정해서 가져오기
document.querySelector('.box')

//CSS 문법에 맞는 요소 전부 가져오기
document.querySelectorAll('.box[active]')










