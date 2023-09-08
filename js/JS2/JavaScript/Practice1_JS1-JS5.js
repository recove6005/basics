function add_list() {
    // let list_ul = document.getElementsByClassName('list_ul');
    //
    // // input checkbox 요소 생성 및 속성 설정
    // // id 속성은 부모요소 ul의 자식요소 li의 개수로 : .childElementCount
    // // id를 숫자로만 설정하는 것보다는 "text" + 등의 방식으로 String 문자열을 덧붙여주는 게 좋음.
    // let checkboxItem = document.createElement('input');
    // checkboxItem.setAttribute('type', 'checkbox');
    // checkboxItem.setAttribute('class', 'checkbox');
    // checkboxItem.setAttribute('id', list_ul[0].childElementCount.toString());
    // // label 생성 및 설정
    // // for, name(색깔 설정을 위함) 속성은 부모요소 ul의 자식요소 li 개수로 : .childElementCount
    // // id를 숫자로만 설정하는 것보다는 "text" + 등의 방식으로  String 문자열을 덧붙여주는 게 좋음.
    // let labelItem = document.createElement('label');
    // labelItem.setAttribute('for', list_ul[0].childElementCount.toString());
    // labelItem.setAttribute('name', list_ul[0].childElementCount.toString());

    // 사용자가 입력한 텍스트 정보를 가져온 후
    // 생성한 label의 textContent에 삽입
    // let userInput = document.getElementById('add_input');
    // labelItem.textContent = userInput.value;
    //
    // // 새롭게 생성한 li요소에 label과 checkbox 삽입
    // let liItem = document.createElement('li');
    // liItem.appendChild(checkboxItem);
    // liItem.appendChild(labelItem);
    //
    // // ul에 li 삽입
    // list_ul[0].appendChild(liItem);

    let userInput = document.getElementById('add_input');
    // 사용자가 입력한 텍스트 정보를 가져온 후
    // 사용자가 입력한 내용이 없다면 alert
    if(userInput.value === '') {
        alert('내용을 입력해 주세요.');
        return;
    } else {
        let list_ul = document.getElementsByClassName('list_ul');

        // input checkbox 요소 생성 및 속성 설정
        // id 속성은 부모요소 ul의 자식요소 li의 개수로 : .childElementCount
        // id를 숫자로만 설정하는 것보다는 "text" + 등의 방식으로 String 문자열을 덧붙여주는 게 좋음.
        let checkboxItem = document.createElement('input');
        checkboxItem.setAttribute('type', 'checkbox');
        checkboxItem.setAttribute('class', 'checkbox');
        checkboxItem.setAttribute('id', list_ul[0].childElementCount.toString());
        // label 생성 및 설정
        // for, name(색깔 설정을 위함) 속성은 부모요소 ul의 자식요소 li 개수로 : .childElementCount
        // id를 숫자로만 설정하는 것보다는 "text" + 등의 방식으로  String 문자열을 덧붙여주는 게 좋음.
        let labelItem = document.createElement('label');
        labelItem.setAttribute('for', list_ul[0].childElementCount.toString());
        labelItem.setAttribute('name', list_ul[0].childElementCount.toString());

        labelItem.textContent = userInput.value;

        // 새롭게 생성한 li요소에 label과 checkbox 삽입
        let liItem = document.createElement('li');
        liItem.appendChild(checkboxItem);
        liItem.appendChild(labelItem);

        // ul에 li 삽입
        list_ul[0].appendChild(liItem);
    }
}

function set_color() {
    let listItems = document.getElementsByClassName('checkbox');
    let userInput = document.getElementById('color_input');

    for(let i = 0; i < listItems.length; i++) {
        if(listItems.item(i).checked) {
            let label = document.getElementsByName(listItems.item(i).getAttribute('id').toString());
            // 노드 리스트의 0번째에 해당하는 input요소가 들어있기 때문에 0 인덱스로 style 지정.
            label[0].style.color = userInput.value;
        }
    }
}

// 추가하기 생성 시 내용이 없다면 내용을 만들지 않고 alert를 띄움.

// querySelectAll() : 해당되는 모든 태그를 다 가져옴.
// input[type='checkbox'] {} : type 속성이 checkbox인 input
// document.querySeelctAll("input[type='checkbox']");

// 이전 요소 가져오기 previousElementSibling
// checkBoxes.item(i).previousElementSibling
