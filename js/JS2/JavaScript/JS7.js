let div = document.querySelector('div');
let section = document.querySelector('section');

console.log(div.style.width); // 출력값 없음...
console.log(section.style.width); // 출력값 없음...!
function plus() {
    // div의 width값을 100px증가시키기
    div.style.width = (+div.style.width + 100) + 'px';
    console.log(div.style.width);
    // 100px로 설정되고 확장은 안됨. 기존의 width, height 값을 가져올 수 없음.
    // => Computed Style을 사용. Computed 된 값을 가져와아 함.

    console.log(getComputedStyle(div)); // 여기에서 width값을 가져옴.
    console.log(getComputedStyle(div).width); // 100px

    // 문자열 px 잘라먹어야 함~
    let width =  getComputedStyle(div).width;
    let finalWidth = width.substring(0, width.length-2);
    div.style.width = (finalWidth + 100) + 'px';
    console.log(div.style.width);
}