// text
const preDiv = document.querySelector('.pre');
const file1 = document.getElementById('file1'); // <input type="file" id="file1">
// input[type=file] 인 요소는 files 프로퍼티가 존재
// files는 선택한 파일의 리스트가 들어있음 ( multiple 옵션일 시 여러 개 선택 가능 )
// Blob은 파일 내용을 읽을 수 있는 메소드가 존재하지 않음
// 따라서, FileReader 객체를 사용하여 내용물을 읽음

file1.onchange = () => {
    // change : input 내용 변경 시 동작하는 이벤트
    console.log(file1.files[0]);

    // 선택한 파일을 가져온다
    let readFile = file1.files[0];
    // 해당 파일이 내가 원하는 타입인지 검사한다 : .type
    console.log(readFile.type);
    // if(readFile.type.slice(0, 5) !== 'text/') {}
    if(readFile.type !== 'plain/text') {
        preDiv.innerText = 'You can not read this file.';
        return;
    } // text파일이 아니면 함수 종료

    let reader = new FileReader();
    // reader.readAsArrayBuffer();
    // reader.readAsText();
    // reader.readAsDataURL();
    // reader.readAsBinaryString();
    reader.readAsText(file1.files[0]); // 결과를 .result로 반환함
    reader.onload = () => {
        preDiv.textContent = reader.result;
    }
}