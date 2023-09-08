// window 객체에 이벤트 리스너 => defer를 걸 필요 x

window.onload = () => {
    document.querySelector('img');
}

window.addEventListener('DOMContentLoaded', () => {
    document.querySelector('input');
    document.querySelector('img'); // x => 리소스는 아직 읽어들이지 않음. => load 이벤트에서
});

window.addEventListener('load', () => {
    document.querySelector('img');
});

