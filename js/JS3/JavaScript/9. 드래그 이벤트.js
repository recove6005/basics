const div = document.querySelector('div');
const a = document.querySelector('a');
// a, img 요소는 기본적으로 draggable이 true
// div.draggable = false; 기본적으로 드래그가 안 됨.
console.log(div.draggable);

// 드래그가 가능하도록 함.
div.draggable = true;

// drag event
div.ondragstart = () => { console.log('Drag start !');}
div.ondragend = () => {console.log('Drag End !');}
div.ondrag = () => {console.log('Drag ...ing.');}

a.ondragstart = () => { console.log('Drag start !');}
a.ondragend = () => {console.log('Drag End !');}
a.ondrag = () => {console.log('Drag ...ing.');}

// dragenter 이벤트는, 드랍할 대상 요소에 적용한다. (마우스가 드래그 중, 이 요소에 들어오면 발동)
const section = document.querySelector('section');
section.draggable = true;
section.ondragenter = () => {console.log('요소에 들어옴.');}
section.ondragleave = () => {console.log('요소에서 나감.');}
section.ondrop = () => {console.log('요소 안에서 드래그가 끝남 : 드랍함.');}

// 드래그 데이터 전달
const dragBox = document.getElementsByClassName('origin').item(0);
const dropBox1 = document.getElementsByClassName('drop1').item(0);
const dropBox2 =document.getElementsByClassName('drop2').item(0);
dragBox.draggable = true;
dropBox1.ondragenter = e => {
    console.log(e.dataTransfer.getData('text/plain'));
    dropBox1.style.backgroundColor = getComputedStyle(dragBox).backgroundColor;
}
dragBox.ondragstart = e => {
    e.dataTransfer.setData('text/plain', 'TRANSFERED!!!');
}
// // 드래그 타깃 요소 위 올라가 있는 상태라면 브라우저 기본 동작을 취소시킴
// // 취소하지 않으면 브라우저의 기본 동작인 drop 이벤트가 있는데, 그 이벤트가 취소되기 때문
// dropBox2.ondragover = e => {
//     e.preventDefault();
// }
// // 드랍하는 순간, 이벤트가 발생하고, 드래그하는 요소에 설정했던 data가 event객체에 저장이 되어 있음
// // 해당 data를 받아서 처리할 수 있게 된다.
// dropBox2.ondrop = e => {
//     e.preventDefault();
//     e.target.textContent = e.dataTransfer.getData('text/plain');
// }

