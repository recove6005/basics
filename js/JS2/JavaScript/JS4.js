let ul = document.querySelector('ul');

// 새로운 요소를 생성
function create_li() {
    let li = document.createElement('li');
    li.textContent = "List " + (ul.childElementCount + 1);
    ul.appendChild(li);
    alert('li가 하나 삽입되었음.');
}

// 기존에 있는 요소를 삽입 (옮기기)
function move_li() {
    // querySelect : 위에서 훑으면서 해당되는 요소 하나를 찾으면 바로 가져옴.
    let li = document.querySelector('li');
    // 기존의 요소를 선택하여 appendChild를 하면 맨 마지막 자식으로 이동시킴.
    ul.appendChild(li);
    alert('기존의 li를 추가함.');
}

// 리스트 복제하기
function clone_li() {
    // querySelect : 위에서 훑으면서 해당되는 요소 하나를 찾으면 바로 가져옴.
    let li = document.querySelector('li');
    // 진짜 복사
    // cloneNode()는 default가 false(li 내용은 복사x).
    let newLi = li.cloneNode(true);
    ul.appendChild(newLi);
    alert('기존의 li를 복제함.');
}

// 리스트 숨기기 나타내기
function pre_toggle_li() {
    let li = document.querySelector('li');
    let newLi = li.cloneNode(true);

    // 속성 설정!
    newLi.textContent = 'new list';
    newLi.setAttribute('active', 'true');

    ul.appendChild(newLi);
}
function toggle_li() {
    let lies = ul.getElementsByTagName('li');
        /**** ****/
        // 유사배열(HTMLCollection) lies는 forEach 못 돎. -> 배열로 바꿔야 함.
        // Array.from();
        var liArr = Array.from(lies);

        // 또는 스프레드 문법 사용
        var liArr = [...lies];

        // 또는
        // [...ul.getElementsByTagName('li')].forEach ( li => {
        //     li.toggleAttribute('active');
        // });

    for(let i = 0; i < lies.length; i++) {
        // // lies[i] = lies.item(i)
        // // 속성이 있는지 검사 : hasAttribute()
        // if(lies.item(i).hasAttribute('active'))
        //     // 속성 삭제 : removeAttrivute()
        //     lies.item(i).removeAttribute('active');
        // else lies.item(i).setAttribute('active', true);

        /**** ****/
        // toggleAttribute : 속성이 있으면 없애고, 없으면 생성.
        lies.item(i).toggleAttribute('active');
    }
}


// CSS 스타일 바꾸기 : style
function change_color() {
    // input에 입력한 값을 가져옴.
    /***  .value  기억해두기. ***/
    let inputContent = document.querySelector('input').value;

    let lies = ul.getElementsByTagName('li');
    [...lies].forEach(li => {
       li.style.color = inputContent;
       li.style.fontWeight = 'bold';
    });
}