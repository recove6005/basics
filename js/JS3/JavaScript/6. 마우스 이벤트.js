let [mclick, mdoubleClick, mgetin, mgetout, mpushdown, mmove]
    = document.getElementsByTagName('div');

// 클릭 이벤트
mclick.onclick = () => {alert('clicked !');}

// 더블클릭 이벤트
mdoubleClick.ondblclick = () => {alert('clicked two times !');}

// 마우스 enter / leave 이벤트
mgetin.onmouseenter = (e) => { e.target.style.backgroundColor = 'lightgreen'; }
mgetin.onmouseleave = (e) => { e.target.style.backgroundColor = 'aliceblue'; }
mgetout.onmouseleave = (e) => { e.target.style.backgroundColor = 'lightgreen'; }

// 이벤트 발생 순서 : mousedown -> click -> mouseup
mpushdown.onmousedown = (e) => {
    e.target.style.backgroundColor = 'orange';
    // 요소 내에서 마우스가 눌렸을 때 발생하는 이벤트
}
// mpushdown.onclick = (e) => {
//     e.target.style.backgroundColor = 'aliceblue';
// }
mpushdown.onmouseup = (e) => {
    e.target.style.backgroundColor = 'lightgreen';
    // 요소 내에서 마우스가 떼질 때 발생하는 이벤트
}

// 마우스 움직임 이벤트
mmove.onmousemove = (e) => {
    // 요소 내에서 마우스가 움직일 때 발생하는 이벤트
    // 요소 기준. 항상 일정.
    console.log('current mouse x position : ', e.offsetX);
    console.log('current mouse y position : ', e.offsetY);

    // 모니터 해상도, 모니터 위치에 따라 다름
    console.log('모니터 위치 x : ', e.screenX);
    console.log('모니터 위치 y : ', e.screenY);

    // 브라우저 화면이 작아지면 좌표 숫자도 줄어듦.
    console.log('브라우저 위치 x : ', e.clientX);
    console.log('브라우저 위치 y : ', e.clientY);

    //
    console.log('문서 위치 x : ', e.pageX);
    console.log('문서 위치 y : ', e.pageY);
}