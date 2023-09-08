const canvas = document.getElementsByClassName('canvas').item(0);
const ctx = canvas.getContext('2d');
let jumpingSwitch = false;
let jumpTimer = 0;
let animation;



// 전체 창 설정
canvas.width = window.innerWidth - 600;
canvas.height = window.innerHeight - 400;

let bottom_line = {
    x : 50,
    y : 300,
    width : 800,
    height : 1,
    draw() {
        ctx.fillStyle = 'black';
        ctx.fillRect(this.x, this.y, this.width, this.height);
    }
}
bottom_line.draw();

//ctx.fillRect(10, 10, 100,100);
// 왼쪽 상단 모서리 x 좌표, 왼쪽 상단 모서리 y 좌표, 너비, 높이
// 등장 케릭터 속성을 object자료에 정의
let dino = {
    x : 100,
    y : 300,
    width: 50,
    height: 50,
    draw() {
        ctx.fillStyle = 'green';
        ctx.fillRect(this.x, this.y, this.width, this.height);
    }
}
dino.draw();

// 장애물 속성 정의
// 각각의 크기가 다름 -> 여러 개의 object속성 필요
class Cactus {
    constructor() {
        this.x = 800;
        this.y = 300;
        this.width = 50;
        this.height = 50;
    }
    draw() {
        ctx.fillStyle = 'yellow';
        ctx.fillRect(this.x, this.y, this.width, this.height);
    }
}

// 애니메이션 만들기
// 애니메이션을 1초에 60번 ++ 해줘야
let timer = 0;
let cactuses = [];
function exe_frame() {
    // 1초에 60번 코드 실행하기
    animation = requestAnimationFrame(exe_frame);
    timer++;
    ctx.clearRect(0,0, canvas.width, canvas.height);

    // dino 생성
    dino.draw()

    // 120프레임마다 장애물을 생성 후 배열에 push
    if(timer % 120 === 0) {
        cactus = new Cactus();
        cactuses.push(cactus);
    }
    // 배열에 있는 장애물 모두 draw()
    cactuses.forEach((a, i, o) => {
        // 화면에서 사라진 장애물은 삭제
        if(a.x < 0) {
            o.splice(i, 1);
        }
        a.x -= 10;
        a.draw();
        // 충돌 체크
        collision_check(dino, cactus);
    });

    // 점프 애니메이션
    if(jumpingSwitch === true && jumpTimer < 15) {
        jumpTimer++;
        dino.y -= 8;
    }
    if(jumpTimer >= 15) {
        jumpTimer++;
        dino.y += 8;
    }
    if(jumpTimer === 30) {
        jumpTimer = 0;
        jumpingSwitch = false;
        dino.y = 300;
    }

}
exe_frame();

// 충돌 체크 - 좌표 계산
function collision_check(dino, cactus) {
    // x축 차이, y축 차이 모두 음수일 때 충돌.
    let xDiff = cactus.x - (dino.x + dino.width);
    let yDiff = cactus.y - (dino.y + dino.height);
    if(xDiff < 0 && yDiff < 0) {
        ctx.clearRect(0,0, canvas.width, canvas.height);
        cancelAnimationFrame(animation); // 애니메이션 중단
        console.log("충돌!");
    }
}

// 점프 구현 -> 키보드 이벤트 리스너
document.addEventListener('keydown', e => {
   if(e.code === 'Space') {
       console.log('jump!');
       jumpingSwitch = true;
   }
});
