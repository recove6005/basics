document.getElementsByTagName('input');

let form = document.forms.item(0); // 0 번째 form 태그

// childNodes는 노드 리스트를 가져옴. 요소 리스트가 아님.
// 노드 리스트는 텍스트, 공백 또한 노드로 판단하여 가져옴.
let childNodes = form.childNodes;
console.log(childNodes);


// children은 childNodes와 달리 노드 리스트를 가져오지 않고
// 요소들의 리스트를 가져옴.
let children = form.children;
console.log('form의 자식 요소들 =>', children);

// 자식 요소 개수
form.childElementCount;

//
let passwordInput = children.item(1); // password input
console.log(passwordInput);

// ip input 요소를 인접요소 선택으로 바로 가져옴.
let idInput = passwordInput.previousElementSibling;
console.log('idInput: ', idInput);
idInput = passwordInput.nextElementSibling;
console.log('idInput: ', idInput);

