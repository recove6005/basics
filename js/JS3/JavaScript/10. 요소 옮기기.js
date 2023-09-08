const div = document.querySelector('div');
let mousePosX = 0; // 현재 마우스의 X 위치값
let mousePosY = 0; // 현재 마우스의 Y 위치값
let offsetX = 0;
let offsetY = 0;

// 마우스 클릭 => 이동 시작
div.addEventListener('mousedown', e => {
    mousePosX = e.clientX - offsetX;
    mousePosY = e.clientY - offsetY;

    // 클릭한 상태라면 마우스 이동 이벤트
    document.addEventListener('mousemove', move_mouse);
});
function move_mouse(e) {
    // 마우스 이동 시 실행할 함수
    // 이동한 거리 = 마우스 현재 위치 - 처음 클릭 시의 위치;
    offsetX = e.clientX - mousePosX;
    offsetY = e.clientY - mousePosY;

    div.style.transform = `translate(${offsetX}px, ${offsetY}px)`;
}

div.addEventListener('mouseup', e => {
        document.removeEventListener('mousemove', move_mouse);
});