// body 내에 있는 자식 요소들을 죽 가져옴.
const [a, span, input1, input2, input3] = document.body.children;

// 항상 요소들을 잘 가져왔는지 확인할 것.
console.log(a);
console.log(span);
console.log(input1);
console.log(input2);
console.log(input3);

// a 태그의 클래스를 a에서 box로 바꿈.
a.setAttribute('class', 'box');
// 기존에 있는 클래스 속성을 그대로 두고 조작하려면??
let v = a.getAttribute('class');
a.setAttribute('class', v + ' box');
// 번거로움. 만약 기존의 calss가 여러 개라면....? split... join... 등등...


// .className : 클래스를 바로 설정이 가능.
a.className = 'a box';


// .classList : 클래스 속성의 리스트들을 바로 가져옴.
// index : 각각의 클래스명
// value : 클래스 전체 스트링
let aList = a.classList;

// 리스트.contains('클래스명') : c라는 클래스명이 포함되어 있다면 출력!
if(aList.contains('c')) console.log('c exsist.');

// 리스트.add('클래스명') : 해당 리스트에 클래스명 추가
// 중복된 요소는 추가되지 않음.
aList.add('b');

// 리스트.remove('클래스명') : 리스트의 해당 요소를 삭제
aList.remove('b');


span.classList.remove('string'); // span의 string 클래스 속성 삭제...


// toggle : 해당 요소에 해당 클래스가 존재하면 삭제, 존재하지 않으면 추가.
input1.classList.toggle('string');
