// 입력하는 input들이 들어있는 div
const inputAreaDiv = document.getElementById('input-area');
// 입력하는 input들
const [listTextInput, addListBtn, colorTextInput, chgColorBtn] = inputAreaDiv.getElementsByTagName('input');
// 모든 리스트 넣는 섹션
const listAreaSection = document.getElementById('list-area');
// 목록 순번 정하는 변수
let listCount = 1;

// 추가 버튼을 눌렀을 때 목록 리스트를 생성한다
function add_list(){
    // 입력 내용이 아무것도 없으면 아무것도 안함 (경고해줌)
    if(listTextInput.value === ''){
        alert('내용을 입력해주세요!');
        return; //함수 종료
    }

    // createElement 사용 시
    const div = document.createElement('div');
    const label = document.createElement('label');
    const input = document.createElement('input');
    const idValue = 'text' + listCount; // 현재 input의 id에 설정할 값
    // input의 type을 체크박스로 설정
    input.setAttribute('type', 'checkbox');
    // input의 id를 설정한다 - label하고 연결지을것임
    input.setAttribute('id', idValue);
    // label의 for를 연결할 input의 id와 같게 설정한다
    label.setAttribute('for', idValue);
    // 내가 적은 input의 값을 가져와서 순번과 함께 설정해준다
    label.textContent = listCount + '. ' + listTextInput.value;
    // 실제로 추가한다
    div.appendChild(label);
    div.appendChild(input);
    listAreaSection.appendChild(div);
    // 순번 1 증가
    listCount++;
    // 입력(input) 내부 내용을 지운다
    listTextInput.value = '';


    // innerHTML 사용시
    // listAreaSection.innerHTML +=
    //     '<div>\n' +
    //     '            <label for="text">1. 내용</label>\n' +
    //     '            <input type="checkbox" id="text">\n' +
    //     '</div>'
}

// 체크되어있는 글자의 색상을 바꾸는 함수
function change_text_color(){
    const checkBoxes = document.querySelectorAll("input[type='checkbox']");
    // [...checkBoxes]
    //     .filter(x => x.checked)
    //     .forEach(y => { y.previousElementSibling.style.color = colorTextInput.value; } )

    for(let i = 0; i < checkBoxes.length; i++){
        // 해당 체크박스가 체크되어있는가?
        if(checkBoxes.item(i).checked){
            checkBoxes
                .item(i)
                .previousElementSibling
                .style
                .color = colorTextInput.value;
        }
    }
}










