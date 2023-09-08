let buttons = document.getElementsByTagName('input');
let outputStr = "";
let output = document.getElementsByClassName('output').item(0);

// 각 버튼들을 iterator로 돌면서 클릭 이벤트 리스너를 달아줌.
[...buttons].forEach(e => {
    e.addEventListener('click', get_click_str)
});

// 클릭 입력
function get_click_str(e) {
    const key = button.value;

    if(e.target.value.includes('Enter')) {
        // enter 입력시 계산 식 실행 후 output, outputStr 리셋
        exec_calc();
        reset_text();
    } else {
        // 수식 검사~
        outputStr += e.target.value;
        output.innerText = outputStr;
    }
}

// 키보드 입력
document.addEventListener('keypress', get_keyboard_output_str); // 콜백함수 : 매개변수는 this.
function get_keyboard_output_str(e) {
    let key = e.key;
    console.log(key);

    if(key === 'Escape') {
        console.log('Esc');
        reset_text();
    }
    else if(/*key === 'Backspace'*/ key === '`') {
        console.log('Backspace');
        delete_char();

    }
    else if(key === 'Enter') {
        exec_calc();
        reset_text();
    }
    else if(/[0-9-+/x.]/g.test(key)) {
        if(examine_keyboard_text(key)) { // 수식 검사 후 문자 입력
            outputStr += key;
            output.innerText = outputStr;
        }
    }
}

// 계산식 리셋
function reset_text() {
    output.innerText = "0";
    outputStr = "";
}

// 계산식 backspace
function delete_char() {
    outputStr = outputStr.substring(0, outputStr.length-1);
    output.innerText = outputStr === '' ? '0' : outputStr;
}

// 계산식 검사
function examine_keyboard_text(key) {
    // 1. 맨 처음 시작(0) 일 때는 .과 -만 가능
    // .일 때는 => 0.~   // -일 때는 => -숫자~
    // 즉, 현재 수식이 0일 때, .과 -가 아니어야 함.
    if(outputStr === '0' && !(key === '.' || key === '-')) {
        return false;
    }

    // 2. 특수문자 다음에는 숫자만 올 수 있다.
    let endPos = outputStr.length - 1;
    let endChar = outputStr.charAt(endPos);
    if(/[+/.-]/g.test(endChar) && /[^0-9]/g.test(key)) {
        return false;
    }

    // 3. .이 두 번 입력되면 안됨.

    // 현재 전체 수식에서  +, / + - 기호를 기준으로 분리
    const erosionArray = outputStr.split(/[+/*-]/g);
    //분리했을 때 맨 마지막 글자에 이미 . 이 있는 상태라면 . 입력 불가
    if(erosionArray[erosionArray.length-1].includes('.')) {
        return false; // 불가능
    }



    // 이상 없으면 true 반환
    return true;
}


// 계산식 문자열 계산
function exec_calc() {

}

// 네이버 계산기 ~
// 공학용 계산기 => Math 클래스