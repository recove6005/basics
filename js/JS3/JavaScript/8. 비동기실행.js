let count1 = 0;
let count2 = 0;

const h1 = document.querySelector('h1');
const h2 = document.querySelector('h2');

/*** setInterval(), setTimeout(), clearInterval() => 실습: 시계만들기 ***/
// 전달한 함수를 전달한 밀리초(timeout)마다 실행
// 비동기 함수이기 때문에 동시에 count 증가.
// 자바스크립트는 동기이기 때문에 브라우저에서 실행하는 것.
// setInterval은 Number 타입의 id를 가짐
let id1 = setInterval(set_count1, 1000);
let id2 = setInterval(set_count2, 1000);

// 전달한 함수를 전달한 밀리초(timeout) 이후에 실행
// setTimeout(set_count1, 2000);

// clearInterval()에는 id를 전달함.
// 인터벌 취소.
// clearInterval(id1);
// clearInterval(id2);


function set_count1() {

    count1++;
    if(count1 === 5) clearInterval(id1);
    h1.textContent = `COUNT1 : ${count1}`;
}
function set_count2() {
    count2++;
    h2.textContent = `COUNT2 : ${count2}`;
}

