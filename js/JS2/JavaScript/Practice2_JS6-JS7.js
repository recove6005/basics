let div = document.getElementsByClassName('text');

let inputLists = document.getElementsByTagName('input');

let bold_check = document.getElementById('bold_check');
let bg_check = document.getElementById('bg_check');
let center_check = document.getElementById('center_check');
let border_check = document.getElementById('border_check');

// 모든 input들에 이벤트 리스너 적용~
[...inputLists].forEach(item => {
   item.addEventListener('click', listener);
});

function listener(){
    if (bold_check.checked) div[0].classList.add('bold');
    else div[0].classList.remove('bold');
    if (bg_check.checked) div[0].classList.add('bg');
    else div[0].classList.remove('bg');
    if (center_check.checked) div[0].classList.add('center');
    else div[0].classList.remove('center');
    if (border_check.checked) {
      div[0].classList.add('border');

      let radioBorder = document.getElementsByName('border');
          if(radioBorder.item(0).checked) div[0].style.borderStyle = 'dotted';
          if(radioBorder.item(1).checked) div[0].style.borderStyle = 'dashed';
          if(radioBorder.item(2).checked) div[0].style.borderStyle = 'double';
          if(radioBorder.item(3).checked) div[0].style.borderStyle = 'solid';
    } else {
        div[0].classList.remove('border');
        div[0].style.borderStyle = 'none';
    }
}







/*** toggle 로 코드 짜기 ~ ***/

function add_bold() {
    div.classList.toggle('bold');
}
function add_bg() {
    div.classList.toggle('bg');
}

// --- 함수들 합치기
function toggle_class(className) {
    div.classList.toggle(className);
    // border style 계속 확인해주기~
    // radio 각각의 특정 속성에 해당 style 이름을 지정해주고 가져오는 것도 방법임.
}

function change_border(borderStyle) {
    div.style.borderStyle = borderStyle;
}

// checkbox에 onclick 설정
// onclick="toggle_class('bold')"
// onclick="toggle_class('bg')"
// onclick="toggle_class('center')"
// onclick="toggle_class('border')"

// radio에 onclick 설정
// onclick="change_border('solid')"

// onclick의 함수 파라미터에 this를 정의하면 해당 요소 자체를 보냄.