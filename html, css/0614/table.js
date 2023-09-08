const table = document.querySelector('table');
const tBody = table.tBodies.item(0);
const captionDiv = document.getElementById('caption');
const addCellDiv = document.getElementById('add-cell')
const removeCellDiv = document.getElementById('remove-cell');
const changeCellDiv =  document.getElementById('change-cell');

function setting_caption(){
    // input에 적혀있는 내용을 가져온다 (제목이 될 것임)
    const captionText = captionDiv.querySelector('input').value;
    // caption을 생성한다
    const caption = table.createCaption();
    // caption의 내용을 설정한다
    caption.textContent = captionText;
}

function add_cell(){
    try{
        const [rowInput, columnInput, contentsInput] =
        addCellDiv.getElementsByTagName('input');
        // 몇번째 행에 데이터를 넣을것인가?
        const row = tBody.rows.item(+rowInput.value - 1);
        // 해당 행의 몇 번째 열에 데이터를 넣을것인가?
        const cell = row.insertCell(+columnInput.value - 1);
        // 해당 열의 내용은 어떤것인가?
        cell.textContent = contentsInput.value;
    }catch (e){
        alert('error!');
    }
}

function remove_cell(){
    const [rowInput, columnInput] =
    removeCellDiv.getElementsByTagName('input');
    // input에 작성한 행의 열에 해당하는 셀(데이터)를 제거
    tBody.rows
        .item(+rowInput.value - 1)
        .deleteCell(+columnInput.value - 1);
}

function change_cell(){
    const [rowInput, columnInput, contentsInput] =
        changeCellDiv.getElementsByTagName('input');
    // input에 작성한 행의 열에 해당하는 셀(데이터)의 내용(textContent)를 바꾼다
    tBody
        .rows.item(+rowInput.value - 1)
        .cells.item(+columnInput.value - 1)
        .textContent = contentsInput.value;
}












