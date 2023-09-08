const outer = document.getElementById('outer');
const inner = document.getElementById('inner2');

outer.addEventListener('click', () => {console.log('outer capture');}, true); // 기본 false
outer.addEventListener('click', () => {console.log('outer bubble');});
inner.addEventListener('click', () => {console.log('inner capture');}, true); // 기본 false
inner.addEventListener('click', () => {console.log('inner bubble');}); // 기본 false




const button = document.querySelector('button');
button.addEventListener('click', (e) => {
    e.target; e.currentTarget; // 같음.
});



const parentDiv = document.getElementById('parent');
parentDiv.onclick = function () {
    parentDiv.style.backgroundColor = 'purple';
}
// 버튼의 부모 요소인 div를 클릭해도 바뀜 (버블링)


button.addEventListener('click', (e) => {
    e.stopPropagation(); // 부모 요소의 이벤트 전파를 막음. 버블링을 막음.
    // e.stopImmediatePropagation(); // 부모요소 뿐만 아니라 자신의 다른 이벤트까지 막음.
});
button.addEventListener('click', () => {
    button.style.background = 'none';
});

