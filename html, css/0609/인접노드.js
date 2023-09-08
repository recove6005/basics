document.getElementsByTagName('input') // input 태그 전부 가져옴!
let form = document.forms.item(0);
// childNodes는 노드 리스트를 가져옴. 요소 리스트가 아님!
// 노드 리스트는 텍스트, 공백 또한 노드로 판단하여 가져옴
let childNodes = form.childNodes;
console.log('자식노드들 =>', childNodes);

// children은 childNodes와 달리 노드 리스트를 가져오는게 아니라
// 요소들의 리스트를 가져온다!
let children = form.children;
console.log('form의자식요소들 =>', children);
form.childElementCount // 자식요소의 개수

//자식 리스트에서 원하는 요소를 가져옴
let passwordInput = children.item(1) //password input
console.log('passwordInput:',passwordInput);

// ip input 요소를 인접요소 선택으로 바로 가져옴
let idInput = passwordInput.previousElementSibling; //이전요소
console.log('idInput:', idInput);

// form 요소 내부에 있는 input 요소만 가져옴
form.getElementsByTagName('input')
// form 요소 내부에 있는 button 요소만 가져옴
form.querySelector('button')





