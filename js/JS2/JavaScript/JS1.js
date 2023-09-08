// document == window.document
//
// 경고 팝업창
// window.alert("hiyo!");
// alert('mr.');
//
// 확인 취소 버튼이 있고, true | false 반환
// let result = confirm('Are you sure?');
// alert("boolean : " + result);
//
// 사용자에게 값을 입력 받음
// 취소 시 null 반환
// 값을 입력하지 않고 확인 시 빈 문자열 반환
// let text = prompt('----');
// alert('????? : ' + text);
//
// window.name = '???';
// alert('현재 창의 이름은 : ', window.name);
//


let divs = document.getElementsByTagName('div');
console.log(divs);
// getElementsByTagName ---> 유사 배열
// divs의 div가 하나뿐이더라도 index를 적어줘야 함.
let innerHtml = divs[0].innerHTML;
let innertext = divs[0].innerText;
let textContent = divs[0].textContent;
console.log("::: "+innerHtml); //
console.log("::: "+innertext); //
console.log("::: "+textContent); // 공백까지 같이 가져옴

let h1tag = document.getElementById('title');
h1tag.innerText = "바뀐 제목 입니다.";

divs.item(0).innerText = "구글 입니다.";
divs.item(0).innerContent = "구글 입니다.";
divs.item(0).innerHTML= '<b>구글 입니다  b</b>' + '  <a href ="https://www.google.com">to google</a>';

let [divBox, pBox] = document.getElementsByClassName('box');
console.log(divBox, pBox);

let pName = document.getElementsByName('pName');
let selectName = document.getElementsByName('choo');
console.log(selectName[0]);

// 요소의 CSS 문법으로 하나의 요소 특정해서 가져오기
document.querySelector('div.box');
document.querySelector('.box');
document.querySelectorAll('.box');
document.querySelectorAll('.box[active]'); // 속성까지 캐치해서 가져옴.













