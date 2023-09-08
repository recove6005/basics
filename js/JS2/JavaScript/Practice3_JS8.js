const tBody= document.querySelector('table').tBodies.item(0);
const pCnt = document.getElementById('pCnt');
function add_cell() {
    const nameInput = document.getElementById('con_name');
    const addrInput = document.getElementById('con_addr');
    const rowCnt = tBody.childElementCount;

    tBody.insertRow(rowCnt);
    let newCell = tBody.rows.item(rowCnt).insertCell(0);
    newCell.textContent = (rowCnt+1).toString();
    newCell = tBody.rows.item(rowCnt).insertCell(1);
    newCell.textContent = nameInput.value;
    newCell = tBody.rows.item(rowCnt).insertCell(2);
    newCell.textContent = addrInput.value;
    newCell = tBody.rows.item(rowCnt).insertCell(3);
    newCell.innerHTML = '<input type="checkbox">';

    pCnt.textContent = (rowCnt+1).toString();
}

function del_cell() {
    const nameInput = document.getElementById('con_name').value;
    const addrInput = document.getElementById('con_addr').value;
    let rowCnt = tBody.rows.length;

    for(let i = 0; i < rowCnt; i++) {
        let innerName = tBody.rows.item(i).cells.item(1);
        let innerAddr = tBody.rows.item(i).cells.item(2);
        if(innerName.textContent === nameInput && innerAddr.textContent === addrInput) {
            tBody.rows.item(i).remove();

            pCnt.textContent = (rowCnt-1).toString();
        }
    }

    // 순번 맞추기~ 뭔가 자꾸 오류가 남~
    for (let i = 0; i < rowCnt-1; i++) {
                tBody.rows.item(i).cells.item(0).textContent = (i+1).toString();
    }

}


// 중복 해결해보기~
// 강사님 풀이~

// 한 행을 생성하는 함수(추가 버튼을 눌렀을 때 동작)
function create_row() {
    const index = tBody.rows.length; // 행의 총 개수. 수강생 수.
    set_total_count(index);

    const nameInput = document.getElementById('con_name').value;
    const addrInput = document.getElementById('con_addr').value;

    // 한 줄 생성
    const row = tBody.insertRow(index-1);
    // 한 칸 생성
    const indexCell = row.insertCell(0);
    indexCell.textContent = index.toString();
    const nameCell = row.insertCell(1);
    nameCell.textContent = nameInput;
    const addrCell = row.insertCell(2);
    addrCell.textContent = addrInput;
    const checkboxCell = row.insertCell(3);

}

function delete_cell() {
    // for(let row of [...tBody.rows]) {}
    for(let row of tBody) {
        [...tBody.rows].forEach(row => {
            if(row.querySelector('input').checked)
                row.remove();
        });
    }

    set_row_index();
}

// 순번 재설정
function set_row_index() {
    const totalIndex = tBody.rows.length;
    for(let rowIndex = 0; rowIndex < totalIndex; rowIndex++) {
        tBody.rows.item(rowIndex).cells.item(0).textContent = (rowIndex+1).toString();
    }
}

// 수강생 수 설정
function set_total_count(index) {
    let captionSpan = document.querySelector('caption');
    captionSpan.textContent = index;



}

