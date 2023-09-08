let [input1, input2, textarea] = document.body.children;

input1.addEventListener('', (e) => {

});

input2.addEventListener('keydown', (e) => {
    console.log(e.key); // input에 입력된 값
    console.log(e.keyCode); // 아스키코드???

    // e.value += e.key => 입렵된 값을 그대로 출력~

});

textarea.addEventListener('keydown', e => { textarea.style.color = 'red'; })
textarea.addEventListener('keyup', e => { textarea.style.color = 'blue'; })
textarea.addEventListener('', e=> { textarea.style.color = 'green'; })