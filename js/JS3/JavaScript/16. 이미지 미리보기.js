// base64 데이터는 기본적으로 image를 읽을 때모다 속도가 빠름 (전송/다운로드 시)
// base64 인코딩 데이터로 img 태그의 src에 바로 적용 가능.
// 32KB 이하 정도의 데이터에 적용하기 좋음

const fileInput = document.querySelector('input');
const fileImg = document.querySelector('img');
const div = document.querySelector('div');

fileInput.onchange = () => {
    const file = fileInput.files[0];
    if (file.type.substring(0, 6) !== 'image/') return;
    console.log(fileInput.files[0]);

    const reader = new FileReader();
    // 해당 파일을 data형식으로 읽는다.
    reader.readAsDataURL(file);
    // file을 전부 읽었다 => onload 이벤트가 발생
    reader.onload = () => {
        // 읽은 데이터가 reader 객체의 result 프로퍼티에 저장되어 옴
        console.log(reader.result);
        fileImg.src = reader.result; //.src에 바로 대입
    }
}

// 드래그로 파일 가져오기
div.ondragover = e => {
    e.preventDefault();
    div.style.backgroundColor = 'yellow';
}
div.ondragend = e => {
    e.preventDefault();

}
div.ondrop = e => {
    e.preventDefault();
    div.style.backgroundColor = 'white';

    // 드래그해서 끌어온 파일을 dataTransfer 객체를 통해 가져온다.
    const dragFile = e.dataTransfer.files[0];
    const reader = new FileReader();
    // 드래그한 파일이 이미지 파일
    if(dragFile.type.substring(0, 6) === 'image/') {
        reader.readAsDataURL(dragFile);
        reader.onload = () => {
            fileImg.src = reader.result;
        }
        console.log('image!');
    }
    // 드래그한 파일이 텍스트 파일
    if(dragFile.type.substring(0, 5) === 'text/') {
        reader.readAsText(dragFile);
        reader.onload = () => {
            div.innerText = reader.result;
        }
        console.log('text!');
    }
}
