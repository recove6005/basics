/**** 1 회차 ****/
function calc_time() {
    console.log('실행됨.');
    console.log(new Date().getSeconds() + ' / ' + new Date().getMilliseconds());
}
// setTimeout(calc_time, 1000);
// setTimeout --> 정확한 1초가 아니다!
// 오차가 계속 커진다!
// setInterval() 은 그나마 조금 나음
// setInterval(calc_time, 1000);
// 정확한 1초를 원한다면 온전히 믿지 말 것.


function func1() {
    console.log('func1 실행되었다.');
    console.log(new Date());
    setTimeout(func2, 1000);
}
function func2() {
    console.log('func2 실행되었다.');
    console.log(new Date());
    setTimeout(func3, 2000);
}

function func3() {
    console.log('func3 실행되었다.');
    console.log(new Date());
}
// setTimeout(func1, 500);


// 위 세 개의 함수를 한 번에 한다면...?
// 에러 를 잡지 못함 -> promise
// setTimeout(() => {
//     console.log('func1이 실행되었다.');
//     setTimeout(() => {
//         console.log('func2이 실행되었다.');
//
//         try {
//             throw Error();
//             // 강제로 error 발생
//         } catch(e) {
//             setTimeout(() => {
//                 console.log('func3이 실행되었다.');
//             }, 2000);
//         }
//     }, 1000);
// }, 500);


// promise : 비동기 처리를 위해 ES6부터 지원되는 비동기 함수
const promise = new Promise(promise_function);
// executor: 프로미스 생성 객체에 전달하는 콜백 함수
// 프로미스 즉시 실행됨.
// promise는 promise 결과를 반환함 (프로미스 객체)
function promise_function(resolve, reject) {
    console.log('promise 실행');
    if(true) {
        // 이 함수가 에러 없이 잘 처리되었다면 resolve를 실행
        resolve('successed !');
    } else {
        // 이 함수가 에러가 있거나 이상하다면 reject
        reject('failed !');
    }
}

// 제대로 실행되었을 때
// 성공 콜백 함수
// then은 promise 객체를 반환하므로 메소드 체인이 가능
promise.then(
    value => { console.log('value: ', value); },
    reason => { console.log('reason: ', reason); }).then();


// 생성 직후 / 비동기 처리 수행 성공 / 비동기 처리 수행 실패
// pending / fulfilled / rejected
// Consumer: 소비자. Promise 함수를 소비하는 쪽.
// then => 두 개의 콜백 함수를 인수로 전달 받음
// => 프로미스가 fulfilled된 상태 (비동기 처리 결과를 인수로 받음) (Promise 객체에서 resolve가 호출 됨.)
// => 프로미스가 rejected 된 상태 (Promise 에러를 인수로 받음) (Promise의 에러를 인수로 받음)

const successedPromise = new Promise((resolve, reject) => {
    resolve('successed');
    reject('failed');
});

successedPromise.then(
    value => { console.log(value); },
    reason => { console.log(reason); }
);

new Promise((resolve, reject) => {
    reject('failed!');
}).then(value => {
    console.log('성공:', value);
}).catch(reason => {
    console.log('why?: ', reason);
});


new Promise((resolve, reject) => {
    resolve('정상 실행1');
}).then(
    value => {
        console.log(value);
        return new Promise((resolve, reject) => { resolve('정상 실행2'); })
    }, reason => {}
).then(
    value=> {
        console.log(value); // 이전 then에서 Promise를 return하지 않으면 undefined.
    }, reason => {}
);





/**** 2 회차 ****/
// then
new Promise((resolve, reject) => {
    resolve(); // 성공했을 때 실행하는 콜백 함수 -> then의 value으로 전달
    reject(); // 실패했을 때 실행하는 콜백 함수 -> then의 reason으로 전달
}).then(value => {}, reason => {});

new Promise((resolve, reject) => {

}).then(value => new Promise(() => {})).then();

// catch
new Promise((resolve, reject) =>{
    resolve();
    reject();
}).catch(reason => {}); // 실패 시 실행, catch는 reason만 필수

// finally
new Promise((resolve, reject) => {
    resolve();
    reject();
}).finally(); // 성공 실패 상관없으 무조건 실행


/*** ***/
// 1) promise 병렬 실행 1
// const promise1 = new Promise(resolve => {
//     // resolve('hello resolve!');
//     // setTimeout(resolve, 3000); value값이 undefined
//     // setTimeout(resolve('promise1', 3000); resolve를 실행하지 않고 반환값을 받음
//     setTimeout(() => {resolve('promise1 3s')},  3000);
// });
// const promise2 = new Promise(resolve => {
//    setTimeout(() => {resolve('promise2 2s')}, 2000);
// });
// const promise3 = new Promise(resolve => {
//    setTimeout(() => {resolve('promise3 1s')}, 1000);
// });
// promise1.then(value => {console.log(value)});
// promise2.then(value => {console.log(value)});
// promise3.then(value => {console.log(value)});


// 2) promise 병렬 실행 2
const promise1 = () => new Promise(resolve => {
    setTimeout(() => {resolve('promise1 3s')},  3000);
});
const promise2 = () => new Promise(resolve => {
   setTimeout(() => {resolve('promise2 2s')}, 2000);
});
const promise3 = () => new Promise(resolve => {
   setTimeout(() => {resolve('promise3 1s')}, 1000);
});
// promise1.then(value => {
//     console.log(value);
//     return promise2; // 다음 then의 value값으로 넘겨짐
// }).then(value => {
//     console.log(value);
//     return promise3; // 다음 then의 value값으로 넘겨짐
// }).then(value => {
//     console.log(value);
// });


// 3) promise 병렬실행 3 : all
// promise의 all은 전달한 모든 프로미스를 병렬 동작 시키고, 모두 수행이 끝나면 종료됨.
Promise.all([promise1(), promise2(), promise3()])
    .then(value => {
        console.log('value', value)
    });

// 전달된 promise 중 하나라도 rejected 상태가 되면 즉시 종료
// 사용하지 않는 변수는 _ 로 표현
Promise.all([
    new Promise((_, reject) => { setTimeout(() => { reject('error - 3s');}, 3000);}),
    new Promise((_, reject) => { setTimeout(() => { reject('error - 2s');}, 2000);}),
    new Promise((_, reject) => { setTimeout(() => { reject('error - 1s');}, 1000);})])
    .then(value => { console.log('성공 - ', value); }, reason => {console.error('실패 - ', reason);})
    // .catch(reason => { console.log('실패 - ', reason); });


// 4) promise 병렬실행 4 : race
// 전달한 promise들을 모두 병렬동작 시킨 후,
// 가장 빨리 성공(resolve)된 promise를 반환하고 종료.
Promise.race([
    new Promise(resolve => setTimeout(() => {resolve(3)}, 3000)),
    new Promise(resolve => setTimeout(() => {resolve(2)}, 2000)),
    new Promise(resolve => setTimeout(() => {resolve(1)}, 1000))
])
    //.then(value => {console.log(value);})
    .then(console.log); // 메소드 참조


// allSettled : 전달받은 promise들이 성공 혹은 실패가 되면 처리 결과를 배열로 반환
Promise.allSettled([
    new Promise((resolve, reject) => setTimeout(() => resolve(1), 1000)),
    new Promise((resolve, reject) => setTimeout(() => reject(2), 2000))
])
    .then(console.log, console.log);