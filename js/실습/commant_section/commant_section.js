const onOffBtn = document.getElementsByClassName('on_off_btn').item(0);
const commantList = document.getElementsByClassName('commant_list').item(0);
const commantCnt = document.getElementsByClassName('commant_count').item(0);
const charCnt = document.getElementsByClassName('char_count').item(0);
const nickname_input = document.getElementsByClassName('input_nickname').item(0);
const commant_input = document.getElementsByClassName('commant_middle').item(0);
const writeBtn = document.getElementsByClassName('write_btn').item(0);

// on/off 기능
onOffBtn.addEventListener('click', () => {
    commantList.classList.toggle('hidden_item');
});

// 댓글 개수 설정
function set_commnat_cnt() {
    commantCnt.innerText = 'Count : ' + commantList.childElementCount+"";
}
set_commnat_cnt();

// 글자 수, 조건 설정
function set_char_cnt() {
    if(commant_input.value.length > 99) {
        commant_input.value = commant_input.value.substring(0, 99);
        charCnt.innerText = (commant_input.value.length + 1) + "/1000";
        alert('1000자 이하로 작성해 주세요.');
    } else charCnt.innerText = (commant_input.value.length + 1) + "/1000";
}
commant_input.addEventListener('keypress', set_char_cnt);

// nickname, textarea 입력 조건 생성 - nickname
nickname_input.addEventListener('keyup', () => {
   if(/[\s]/g.test(nickname_input.value)) {
       nickname_input.value = nickname_input.value.substring(0, nickname_input.value.length-1);
       alert('공백을 포함할 수 없습니다.');
   }
});

// nickname, textarea 입력 조건 생성 - 댓글 등록
writeBtn.addEventListener('click', () => {
    // nickname과 textarea가 일치하지 않으면 alert
    if(!/[^ ].+/g.test(commant_input.value) || (!/.+/g.test(nickname_input.value))) {
        alert('닉네임과 내용을 입력해 주세요.');
        set_char_cnt();
    } else {
        console.log('uploaded');
    // 댓글 등록
        // 1) insertAdjacentHTML
        // let liItem = `
        //     <li class="commant_item">
        //         <div class="commant_item_head">
        //             <div class="commant_nickname"></div>
        //             <a href="#" class="commant_delete">X</a>
        //         </div>
        //         <div class="commant_item_middle">
        //             <dic class="commant_text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque blanditiis consectetur deserunt ea eum, hic illo impedit ipsa maiores molestias nihil perferendis quasi reiciendis repellendus, reprehenderit repudiandae tempora temporibus voluptatibus.</dic>
        //         </div>
        //     </li>
        // `;
        // commantList.insertAdjacentHTML('beforeend',liItem);
        // commantCnt.innerText = 'Count : ' + commantList.childElementCount+"";

        // 2) create element
        let commant_item = document.createElement('li');
        commant_item.classList.toggle('commant_item');
        let commant_item_head = document.createElement('div');
        commant_item_head.classList.toggle('commant_item_head');
        let commant_nickname = document.createElement('div');
        commant_nickname.classList.toggle('commant_nickname');
        commant_nickname.innerText = nickname_input.value;
        let commant_delete = document.createElement('a');
        commant_delete.classList.toggle('commant_delete');
        commant_delete.innerText = 'X';
        commant_delete.addEventListener('click', e => {
            // 댓글 삭제 이벤트
            e.target.parentElement.parentElement.remove();
            // 댓글 수 설정
            set_commnat_cnt();
        });
        let commant_item_middle = document.createElement('div');
        commant_item_middle.classList.toggle('commant_item_middle');
        let commant_text = document.createElement('div');
        commant_text.innerText = commant_input.value;
        commant_text.classList.toggle('commant_text');

        commantList.appendChild(commant_item);
        commant_item.appendChild(commant_item_head);
        commant_item_middle.appendChild(commant_text);
        commant_item.appendChild(commant_item_middle);
        commant_item_head.appendChild(commant_nickname);
        commant_item_head.appendChild(commant_delete);
    }

    // 댓글 수 설정
    set_commnat_cnt();
    // 글자 수 초기화
    charCnt.innerText = "0/1000";


    // input 초기화~
    nickname_input.value = "";
    commant_input.value = "";
});