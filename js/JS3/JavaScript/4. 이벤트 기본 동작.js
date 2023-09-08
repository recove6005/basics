const [a, form, img] = document.body.children;
const button = form.firstChild;

a.onclick = alert_msg;
button.onclick = alert_msg; // 바로 submit 되고, 다음 페이지로 가 버림.
img.ondragstart = drag_obj;

function alert_msg(e) {
    e.preventDefault(); // ???
    alert('취소 가능???? ' + e.cancelable);
    alert('clicked !');
}

function drag_obj(e) {
    e.preventDefault();
    console.log(e.cancelable);
    console.log('drag is done !');
}