const carousel = document.querySelector('.carousel');
const carouselItems = document.querySelector('.carousel-items');
const prevBtn = document.querySelector('.carousel-prev');
const nextBtn = document.querySelector('.carousel-next');
const itemWidth = carouselItems.clientWidth;
let position = 0;

prevBtn.addEventListener('click', () => {
   position += itemWidth;
   console.log(position);
   if(position > 0) position = -itemWidth * (carouselItems.children.length-1);
   carouselItems.style.transform = `translateX(${position}px)`;
});

nextBtn.addEventListener('click', () => {
   position -= itemWidth;
   if(position < -itemWidth * (carouselItems.children.length -1)) position = 0;
    carouselItems.style.transform = `translateX(${position}px)`;
});