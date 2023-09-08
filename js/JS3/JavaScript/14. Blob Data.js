// 2진 데이터 생성
// string(문자열) 타입은 UTF-8 BINARY 데이터로 변환되며
// BLOB객체는 읽기 전용. READ-ONLY.
// text() 메소드는 promise를 반환 -> then() 사용 가능
// slice(start, end, contentType) 메소드는 버퍼의 start부터 end까지의 복사본을, MIME타입이 contentType인 BLOB객체로 반환
let blobStr = new Blob(["JAVASCRIPT"], {type: "text/plain"});
let blobHtml = new Blob(["<a href='https://www.naver.com'>TEST</a>"], {type: "text/plain"});
console.log('blobStr', blobStr);
console.log('blobHtml', blobHtml);
blobStr.text().then(console.log);
blobHtml.text().then(console.log);

// 어떤 기본 데이터를 이진 데이터로 다룰 때는 "application/octet-stream"을 사용
let intData = new Int8Array([0,1,2,3]);
let blobData = new Blob(intData, {type: "application/octet-stream"});
console.log('blob',blobData);
// slice()
blobData.text().then(console.log);
let newBlobData = blobData.slice(1, 3, 'text/plain');
console.log('newBlobData', newBlobData);
newBlobData.text().then(console.log);

