const stickerWrap = document.getElementById('sticker-wrap');
const stickerNote = document.getElementsByClassName('sticker-note');
const colorListObj = {'c1': ['black','white'], 'c2': ['blue', 'green']}

function StickerNote(){
    this.note = null; // 현재 노트의 Element - HTML
    this.titleDiv = null; //현재 노트의 제목 부분 === ID

    this.addBtn = null; // 노트 추가 버튼
    this.removeBtn = null; //노트 삭제 버튼
    this.textListBtn = null; //텍스트 리스트 버튼

    this.noteColorDiv = null; // 색 설정 구역
    this.textUL = null; //저장되어있는 노트 리스트 UL

    this.sideNav = null; // 왼쪽에서 나오는 사이드바
    this.topNav = null; //상단 메뉴 바
}

// 스티커 노트의 유전자에 전체 HTML 문구를 저장한다
StickerNote.prototype.elementText = `<div class="sticker-note">
            <div>UNTITLED</div>
            <nav class="top-nav">
                <a href="#" class="add"><i class="fa-solid fa-plus"></i></a>
                <div class="nav-right">
                    <a href="#" class="list"><i class="fa-solid fa-list-ul"></i></a>
                    <a href="#" class="save"><i class="fa-solid fa-floppy-disk"></i></a>
                    <a href="#" class="remove"><i class="fa-solid fa-xmark"></i></a>
                </div>
            </nav>
            <textarea class="txt"></textarea>
            <nav class="side-nav">
                <div class="sticker-note-color"></div>
                <ul></ul>
            </nav>
        </div>`;

// 스티커 노트의 유전자에 add_note라는 기능을 설정한다
// add_note : 새 노트를 추가하는 기능, + 버튼 눌렀을 때 동작
StickerNote.prototype.add_note = function (){
    // 현재 문서에 새로운 노트 element를 삽입한다 => 노트가 하나 생성됨
    stickerWrap.insertAdjacentHTML('beforeend', StickerNote.prototype.elementText);

    // 새로운 노트 객체를 생성한다 => 방금 생성한 노트와 연결한다
    const newNote = new StickerNote();
    newNote.note = stickerWrap.lastElementChild; //현재 생성된 노트의 HTML요소를 저장해준다

    console.log(getComputedStyle(stickerWrap).width, getComputedStyle(stickerWrap).height)
    console.log(getComputedStyle(newNote.note).width, getComputedStyle(newNote.note).height)


    // 생성된 노트의 위치를 지정한다 (현재 문서의 랜덤 위치)
    const maxLeft = +getComputedStyle(stickerWrap).width.replace('px', '') - (+getComputedStyle(newNote.note).width.replace('px', '')) ;
    const maxTop= -(+getComputedStyle(stickerWrap).height.replace('px', ''))  + (+getComputedStyle(newNote.note).height.replace('px', '')) ;

    newNote.note.style.left = Math.floor(Math.random() * maxLeft) + 'px';
    newNote.note.style.top = Math.floor(Math.random() * maxTop) + 'px';

    // 해당 노트에서 필요한 요소를 가져온다
    get_elements(newNote);

    ///// 생성된 노트의 개별 설정
    // 노트에 설정 가능한 색깔들을 노트에 삽입
    for(let key in colorListObj){
        const bgColor = colorListObj[key][1];
        newNote.noteColorDiv.insertAdjacentHTML('beforeend', `<span class="${key}" style="background-color: ${bgColor}"></span>`);
    }

    // 방금 생성한 노트에 각 이벤트를 설정한다 => 해당 노트 객체를 전달
    set_events(newNote);
}

// 해당 노트에서 필요한 요소들을 가져와서 미리 저장해두는 함수
function get_elements(newNote){
    ////////// 텍스트 에리어
    newNote.textArea = newNote.note.querySelector('.txt');

    ////////// 버튼 관련
    newNote.addBtn = newNote.note.querySelector('.add');
    newNote.saveBtn = newNote.note.querySelector('.save');
    newNote.removeBtn = newNote.note.querySelector('.remove');
    newNote.textListBtn = newNote.note.querySelector('.list'); // 노트의 텍스트 리스트 버튼


    ////////// 사이드바 부분
    newNote.sideNav = newNote.note.querySelector('.side-nav');
    newNote.textUL = newNote.note.querySelector('.side-nav ul');

    // 색상 목록
    newNote.noteColorDiv = newNote.note.querySelector('.sticker-note-color');

    ////////// 목록 상단바 부분
    newNote.topNav = newNote.note.querySelector('.top-nav');

    ///////// 노트 제목 부분
    newNote.titleDiv = newNote.note.firstElementChild;
}

// 노트 하나에 모든 이벤트를 설정해주는 함수
function set_events(newNote){
    // 노트 클릭 시 최상단으로 올리기
    newNote.note.onclick = function (){
        [...stickerNote].forEach( curtNote => { curtNote.style.zIndex = '1'; } )
        newNote.note.style.zIndex = '99';
    }

    // 새 노트 추가
    newNote.addBtn.onclick = newNote.add_note;

    // 목록 열기 이벤트
    newNote.textListBtn.onclick = function (){
        newNote.sideNav.toggleAttribute('active');
        const noteData = JSON.parse( localStorage.getItem('note') );
        newNote.textUL.innerHTML = '';
        for(let title in noteData) {
            newNote.textUL.insertAdjacentHTML('beforeend', `<li>${title}</li>`);
        }
    }

    // 필요한 모든 정보를 가져와서 현재 상태를 저장한다
    newNote.saveBtn.onclick  = function (){
        const topNavColor = getComputedStyle(newNote.topNav).backgroundColor;
        const textAreaColor = getComputedStyle(newNote.textArea).backgroundColor;
        const text = newNote.textArea.value; // 노트에 적힌 글자 (내용) === value의 text
        const div = newNote.titleDiv; // 현재 노트의 제목 DIV의 내용 === id
        // 내가 저장하고 싶은 내용 ==> { 상단바의 색, 배경색, 내용글자 }
        const value = { topNavColor: topNavColor, textAreaColor: textAreaColor, text: text }
        // 저장할 것인지 판단해서 실제로 저장 / 취소 한다
        save_note_data(div, value);
    }

    // 노트 삭제 이벤트
    newNote.removeBtn.onclick = function (){
        newNote.note.remove();
    }

    //노트의 색을 변경하는 이벤트
    newNote.noteColorDiv.onclick = (e) => {
        const [topColor, mainColor] = colorListObj[e.target.className];
        newNote.topNav.style.backgroundColor = topColor;
        newNote.textArea.style.backgroundColor = mainColor;
    };

    // 현재 저장되어 있는 노트 리스트를 클릭하였을 시
    // 로컬스토리지에 있는 내용을 불러와서 현재 노트에 적용하는 이벤트
    newNote.textUL.onclick = e => {
        // ul 내부에 있는 클릭한 li에 적혀있는 노트 제목
        const key = e.target.textContent;
        // 사용자에게 변경할것인지 여부 확인 후, 변경
        if(!confirm(`'${key}' 노트로 변경하시겠습니까?`)){
            return; // '아니오'를 클릭했으므로 그냥 끝낸다
        }
        // 해당 노트 제목으로 저장되어있는 값을 가져온다
        const value = JSON.parse(localStorage.getItem('note'))[key];
        // 해당 값은 객체이다. 안에는 3개의 값이 저장되어 있음
        const topNavColor = value['topNavColor'];
        const textAreaColor = value['textAreaColor'];
        const text = value['text'];

        // 가져온 값들로 현재 노트의 설정을 변경한다
        newNote.textArea.value = text; //내용
        newNote.titleDiv.textContent = key; //제목
        newNote.topNav.style.backgroundColor = topNavColor;//상단배경
        newNote.textArea.style.backgroundColor = textAreaColor; //텍스트배경

        // 사이드바를 닫아준다
        newNote.sideNav.toggleAttribute('active');
    }
}

// 저장버튼 눌렀을 시 데이터를 저장할것인가 판단 후 저장 / 취소
function save_note_data(div, value){
    // 현재 노트의 제목을 가져온다
    let key = div.textContent;
    // 로컬스토리지에서 기존 모든 노트 내용 데이터를 가져온다
    const noteData = JSON.parse( localStorage.getItem('note') );

    if(key === 'UNTITLED'){
        key = prompt('제목을 입력해주세요');
        if(key !== null && key !== ''){
            // 이미 해당 제목으로 저장되어있는 데이터가 없다면
            if (!(key in noteData)){
                set_localStorage_item(div, noteData, key, value);
            }
            // 기존에 존재하는게 있었다면
            else if(confirm('덮어쓰시겠습니까?')){
                set_localStorage_item(div, noteData, key, value);
            }
        }
    }
    // 제목이 설정되어 있는 상태이다
    else if(confirm('덮어쓰시겠습니까?')){
        set_localStorage_item(div, noteData, key, value);
    }
}

// 로컬 스토리지에 데이터를 저장하는 함수
function set_localStorage_item(div, noteData, key, value){
    // 현재 title으로 저장된 노트 데이터를 update 시킨다
    noteData[key] = value;
    // update 된 객체 내용을 다시 로컬스토리지에 저장한다
    localStorage.setItem('note', JSON.stringify(noteData));
    // 현재 제목을 입력받은 제목으로 변경한다
    div.textContent = key;
}

// 맨 처음 접속 시 노트 하나 생성
new StickerNote().add_note();
// 저장되어있는 노트 하나라도 있는지 검사
if (localStorage.getItem('note') == null){
    localStorage.setItem('note', JSON.stringify({}));
}





