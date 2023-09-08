const lifeSpan = document.querySelector('.life');
const scoreSpan = document.querySelector('.score');
const alphabetSection = document.querySelector('.alphabets');
const answerSection = document.querySelector('.answer');

const word = "banana"; // 유저가 맞춰야 할 단어
const answer = [] // 현재 정답의 각 문자 배열

// 처음 게임 시작 시 선택된 알파벳을 정답 섹션에 추가
function create_answer_div() {
    for(let c of word) {
        // 정답 글자 개수 만큼 div 칸 생성
        const answerDiv = document.createElement('div');
        answerSection.appendChild(answerDiv);

        // 정답을 문자 하나씩 나눠서 answer 배열에 저장
        answer.push(c);
    }
}

// 처음 게임 시작 시 A-Z 모든 알파벳 버튼을 생성
function create_alphabets() {
    // ascci A~Z 65~90
    for(let i = 65; i <= 90; i++) {
        const alphaBtn = document.createElement('button');
        alphaBtn.textContent = String.fromCharCode(i);
        // 생성된 버튼에 클릭 이벤트 추가
        alphaBtn.addEventListener('click' , set_answer_event);
        // 생선된 버튼을 alphabets 섹션 내에 추가
        alphabetSection.appendChild(alphaBtn);
    }
}

// 알파벳 버튼 클릭 이벤트
function set_answer_event(e) {
    // 클릭한 알파벳 글자를 가져옴
    const alphabet = e.target.textContent;
    let findFlag = 0;

    // 정답 배열에서 클릭한 알파벳 위치를 전부 찾은 후
    const answerDivs = document.querySelectorAll('.answer > div');
    for (let i in answer) {
        // 위치를 발견하면
        if (alphabet.toUpperCase() === answer[i].toUpperCase()) {
            // 해당 위치의 div 글자를 설정
            answerDivs[i].textContent = alphabet.toUpperCase();
            e.target.remove();
            findFlag = 1;
        }
    }
    if (findFlag === 1) scoreSpan.textContent = (+scoreSpan.textContent) + 100;

    // 일치하는 글자가 없으면 life, score 감점
    // life가 0이 되면 failed
    if (findFlag === 0) {
        lifeSpan.innerText = (+lifeSpan.innerText) - 1;
        scoreSpan.textContent = (+scoreSpan.textContent) - 10;
        if (+lifeSpan.innerText === 0) {
            document.querySelector('.board').insertAdjacentHTML('afterbegin', `<h1>Failed!</h1>`);

            // 알파벳 버튼 비활성화
            disable_alpha_btns();
        }
    }
    // 모든 글자를 찾으면
    let answerText = "";
    for (let i = 0; i < answerDivs.length; i++) answerText += answerDivs[i].innerText;
    if (answerText.toUpperCase().includes(word.toUpperCase())) {
        document.querySelector('.board').insertAdjacentHTML('afterbegin', `<h1>Complete!</h1>`)

        // 알파벳 버튼 비활성화
        disable_alpha_btns();
    }
}

function disable_alpha_btns() {
    const alphaBtn = document.querySelectorAll('.alphabets > button');
    [...alphaBtn].forEach(i => {i.toggleAttribute('disabled')});
}

create_alphabets();
create_answer_div();