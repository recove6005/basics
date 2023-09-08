const textarea = document.getElementById('area-contents').querySelector('textarea');
const textareaTextCount = document.querySelector('#area-contents > div > span');

textarea.oninput = () => {
    textareaTextCount.textContent = textarea.value.length + ' / 100';
}