const pjtWrapper = document.querySelector('.projects_wrapper');
const pjtBoxs = document.querySelectorAll('.projects_item');
const prevBtn = document.querySelector('.prev-btn');
const nextBtn = document.querySelector('.next-btn');

let position = 0;
let pjtWidth = 510;

prevBtn.addEventListener('click', () => {
    position += pjtWidth;
    if(position > 0) position = 0;

    pjtWrapper.style.transform = `translateX(${position}px)`;
    console.log('clicked!');
});

nextBtn.addEventListener('click', () => {
    position -= pjtWidth;
    if(Math.abs(position) > 510*(pjtBoxs.length-1)) position = -Math.abs(510*(pjtBoxs.length-1));
    pjtWrapper.style.transform = `translateX(${position}px)`;
});
