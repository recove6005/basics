let checkBoxes = document.getElementsByTagName('input');
let cntSpan = document.querySelector('span');

// input에 이벤트 설정
[...checkBoxes].forEach(box => {
    box.onclick = change_count;
});

// 체크박스가 클릭되었을 때 실행될 함수
function change_count() {

    let cnt = 0;
    [...checkBoxes].forEach(item => {
        // .checked : input태그의 체크박스가 체크되어 있으면 true, 아니면 false
        if(item.checked) cnt++;
    });
    cntSpan.textContent = cnt+"";
}