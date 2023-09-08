const box1 = document.getElementsByClassName('box1').item(0);
const box2 = document.getElementsByClassName('box2').item(0);
const box3 = document.getElementsByClassName('box3').item(0);
const box4 = document.getElementsByClassName('box4').item(0);
box1.draggable = true;
box2.draggable = true;
box3.draggable = true;
box4.draggable = true;

box1.ondragstart = e => {
    e.dataTransfer.setData('text/plain','text1');
}

box1.ondragenter = e => {

}

box2.ondrag = e => {

}
box2.ondragenter = e => {
    e.preventDefault();
    console.log(e.dataTransfer.getData('text/plain'));
}