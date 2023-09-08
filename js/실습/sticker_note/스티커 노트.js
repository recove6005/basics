const stickerWrap = document.getElementById('sticker_wrap');
const colorListObj = {'c1': ['red','red'], 'c2': ['green', 'green'], 'c3' : ['white', 'white'], 'c4' : ['lightgoldenrodyellow', 'lightgoldenrodyellow']};
let allNoteCount = 0; // 전체 노트 객체 개수 -> addNote() 호출 시 +

let mousePosX = 0; // 현재 마우스의 X 위치값
let mousePosY = 0; // 현재 마우스의 Y 위치값

/* 객체 생성 */
function StickerNote() {
     this.note = null; // 현재 나의 노트 element
     this.addBtn = null; // 노트 추가 버튼
     this.listBtn = null; // 텍스트 리스트
     this.closeBtn = null; // 노트 삭제 버튼
     this.saveBtn = null; // 노트 저장 버튼
     this.noteColorDiv = null; // 색 설정 구역
     this.sideNav = null; // 사이드바
     this.topNav = null; // 상단바
     this.id = 0;

     this.get_element = get_elements;
     this.set_events = set_events;
}

// 스티커 노트 전체 html 설정
StickerNote.prototype.elementText = `<div class="sticker_note">
      <nav class="top_nav">
        <a href="#" class="add_btn" onclick="stickerNote.add_note()"><i class="fa-solid fa-plus"></i></a>
        <div class="inner_right_nav">
          <a href="#" class="list_btn"><i class="fa-solid fa-list-ul"></i></a>
          <a href="#" class="save_btn"><i class="fa-solid fa-floppy-disk"></i></a>
          <a href="#" class="close_btn"><i class="fa-solid fa-xmark"></i></a>
        </div>
      </nav>
      <textarea class="textarea"></textarea>

      <nav class="side_nav" >
        <div class="sticker_note_color">
<!--          <span class="key" style="background-color: red"></span>-->
<!--          <span class="key2" style="background-color: blue"></span>-->
<!--          <span style="background-color: green"></span>-->
        </div>
        <ul>
         
        </ul>
      </nav>
       </div>`;

//스티커 노트의 유전자에 add_note라는 기능을 설정함.
// add_note : 새 노트를 추가하는 기능, + 버튼 클릭 시 동작
StickerNote.prototype.add_note = function () {
    // 현재 문서에 새로운 노트 element를 삽입, insertAdjactentHTML => 노트 하나를 더 추가.
    stickerWrap.insertAdjacentHTML('beforeend', StickerNote.prototype.elementText);
    allNoteCount++;
    // 새로운 노트 객체를 생성 => 방금 생성한 노트와 연결
    const newNote = new StickerNote();
    newNote.id = allNoteCount;
    newNote.note = stickerWrap.lastElementChild;

    // 생성된 노트의 위치를 랜덤으로 지정 (현재 문서의 랜덤 위치)
    // 0~100 사이의 값을 만들려면
    const maxLeft = +getComputedStyle(stickerWrap).width.replace('px', '') - (+getComputedStyle(newNote.note).width.replace('px', '')) ;
    const maxTop= -(+getComputedStyle(stickerWrap).height.replace('px', ''))  + (+getComputedStyle(newNote.note).height.replace('px', '')) ;

    newNote.note.style.left = Math.floor(Math.random() * maxLeft) + 'px';
    newNote.note.style.top = Math.floor(Math.random()*maxTop) + 'px';

    // 해당 노트에서 필요한 요소를 가져옴.
    newNote.get_element(newNote);

    // 노트에 설정 가능한 색깔들을 노트에 삽입
    for(let key in colorListObj) {
        const bgColor = colorListObj[key][1];
        newNote.noteColorDiv.insertAdjacentHTML('beforeend',
            `<span class="${key}" style="background-color: ${bgColor}"></span>`);
    }

    // 방금 생성한 노트에 각 이벤트를 설정함. => 해당 노트 객체를 전달
    newNote.set_events(newNote);
}

// 해당 노트에서 필요한 요소들을 가져와서 미리 저장해두는 함수 get_elements()
// 가져온 노트들에 이벤트를 설정하는 함수 set_events()
function get_elements(newNote) {
    // 텍스트
    newNote.textarea = newNote.note.querySelector('.textarea');
    // 노트 배경색
    newNote.listBtn = newNote.note.querySelector('.top_nav .inner_right_nav .list_btn');
    // 버튼
    newNote.addBtn = newNote.note.querySelector('.top_nav .add_btn');
    newNote.closeBtn = newNote.note.querySelector('.top_nav .inner_right_nav .close_btn');
    newNote.saveBtn = newNote.note.querySelector('.top_nav .inner_right_nav .save_btn');
    // 색
    newNote.noteColorDiv = newNote.note.getElementsByClassName('sticker_note_color').item(0);
    // 목록 상단바
    newNote.topNav = newNote.note.querySelector('.top_nav');
    // 사이드바
    newNote.sideNav = newNote.note.querySelector('.side_nav');
    newNote.textUl = newNote.note.querySelector('.side_nav ul');
}

function set_events (newNote) {
    // 노트 추가
    newNote.addBtn.onclick = newNote.add_note;

    // 목록 열기 이벤트
    newNote.listBtn.onclick = function (){
        newNote.sideNav.toggleAttribute('active');
    }
    // 노트 삭제 이벤트
    newNote.closeBtn.onclick = function (){
        newNote.note.remove();
    }
    // 노트 배경색 변경
    newNote.noteColorDiv.onclick = (e) => {
        const [topColor, mainColor] = colorListObj[e.target.className];
        newNote.topNav.style.backgroundColor = topColor;
        newNote.textarea.style.backgroundColor = mainColor;
    }
    // 현재 상태 저장
    newNote.saveBtn.onclick = function () {
        // 1) 각 노트에 id를 부여 -> 노트가 많아질수록 저장할 값도 많아진다는 단점.
        // 2) 특정 변수에 각각의 노트 객체를 저장 -> json
        const topNavColor = getComputedStyle(newNote.topNav).backgroundColor;
        const textareaColor = getComputedStyle(newNote.textarea).backgroundColor;
        const text = newNote.textarea.value;
        // 저장된 데이터를 미리 가져온 이후 추가로 수정 // 데이터가 없으면 추가, 데이터가 있으면 수정
        const noteData = JSON.parse(localStorage.getItem('note'));
        noteData[newNote.id] = {topNavColor: topNavColor, textareaColor: textareaColor, text: text};
        localStorage.setItem('note', JSON.stringify(noteData));
    }
}


const stickerNote = new StickerNote();
stickerNote.add_note();
// note에 값이 없으면 초기화
if(localStorage.getItem('note') == null) {
    localStorage.setItem('note', JSON.stringify({}));

    const noteData = JSON.parse( localStorage.getItem('note'));
    for(let id in noteData) {
        newNote.textUl.insertAdjacentHTML('beforeend', `<li>${noteData[id]['text']}</li>`);
    }
}





