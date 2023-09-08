let startBtn = document.getElementsByClassName('start_btn').item(0);
let timeStr = document.getElementsByClassName('time_str').item(0);
let cnt = 0;
let intervalId = -1;

// start
startBtn.addEventListener('click', set_interval);

function set_interval() {
    // start 버튼을 누를 때마다 setInterval()을 어러번 실행하므로,,,
    // id를 flag로 설정
    if(intervalId !== -1) return undefined;
    else intervalId = setInterval(() => {
        cnt++;
        timeStr.innerText = get_time();
    }, 1000);
}

function get_time() {
    let hour = '0';
    let min = '0';
    let sec = '0';

    if (cnt <= 60) {
        sec = cnt + "";
    }
    else {
        if (cnt > 3600) {
            hour = Math.floor(cnt / 3600)+"";
            if (cnt%3600 > 60) {
                min = Math.floor(Math.floor(cnt % 3600) / 60) + "";
                sec = (Math.floor(cnt % 3600) % 60) + "";
            } else sec = Math.floor(cnt % 3600) + "";
        }
        else if (cnt > 60) {
                min = Math.floor(cnt / 60) + "";
                sec = Math.floor(cnt % 60) + "";
        }
    }
    return hour.padStart(2, '0') + " : " + min.padStart(2, '0') + " : " + sec.padStart(2, '0');
}

// stop press
let stopPressBtn = document.getElementsByClassName('stop_press_btn').item(0);
stopPressBtn.addEventListener('click', () => {
    clearInterval(intervalId);
    intervalId = -1;
});

// stop & reset
let stopBtn = document.getElementsByClassName('stop_btn').item(0);
stopBtn.addEventListener('click', reset_time);

function reset_time() {
    clearInterval(intervalId);
    intervalId = -1;
    cnt = 0;
    timeStr.innerText = "00 : 00 : 00";
}