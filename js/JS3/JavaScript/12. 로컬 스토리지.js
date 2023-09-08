const fontColor = document.getElementsByClassName('font_color').item(0);
const bgColor = document.getElementsByClassName('bg_color').item(0);
const textarea = document.getElementsByClassName('textarea').item(0);
fontColor.addEventListener('input', () => {
    textarea.style.color = fontColor.value;
});
bgColor.addEventListener('input', () => {
   textarea.style.backgroundColor = bgColor.value;
});

//     input요소가 변화되는 즉시 값을 반영하기 위해 input type을 input 또는 change 로~
//     1. 클릭 이벤트: "click" 이벤트는 요소를 클릭했을 때 발생합니다.
//     2. 마우스 이벤트: "mouseover", "mouseout", "mousemove" 등 마우스와 관련된 다양한 이벤트가 있습니다.
//     3. 키보드 이벤트: "keydown", "keyup", "keypress" 등 키보드와 관련된 이벤트입니다.
//     4. 폼 이벤트: "submit", "input", "change" 등 폼 요소와 관련된 이벤트가 있습니다.
//     5. 로드 이벤트: "load" 이벤트는 문서나 이미지 등이 로드되었을 때 발생합니다.
//     6. 양식 이벤트: "focus", "blur", "select" 등 양식 요소와 관련된 이벤트입니다.
//     7. 스크롤 이벤트: "scroll" 이벤트는 요소의 스크롤 위치가 변경될 때 발생합니다.


// 저장 -> 로컬 스토리지에 텍스트, 텍스트 색, 배경 색 저장.

const saveBtn = document.getElementsByClassName('save_btn').item(0);
const loadBtn = document.getElementsByClassName('load_btn').item(0);
saveBtn.onclick = () => {
    localStorage.setItem('font_color', fontColor.value);
    localStorage.setItem('bg_color', bgColor.value);
    localStorage.setItem('textarea', textarea.value);
}
loadBtn.onclick = () => {
    textarea.value = localStorage.getItem('textarea');
    textarea.style.color = localStorage.getItem('font_color');
    textarea.style.backgroundColor = localStorage.getItem('bg_color');
}

console.log(document.querySelectorAll('input[type="button"]'));