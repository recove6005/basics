const table = document.querySelector('table');
const tBody = table.tBodies.item(0);

const caption = table.createCaption();
caption.textContent = 'Table Title';

const content = table.tBodies.item(0).rows.item(1).cells.item(0).textContent;
console.log(content);
const newCell = table.tBodies.item(0).rows.item(1).insertCell(2);
newCell.textContent = 'new cell !';

table.tBodies.item(0).insertRow(1);



// 연습!
function setting_caption() {
    const captionDiv = document.getElementById('caption');

    // 가져온 요소의 하위 요소를 querySelector로 다시 가져올 수 있음??
    const captionText = captionDiv.querySelector('input').value;
    const caption = table.createCaption();
    caption.textContent = captionText;
}

function add_cell() {
    const addCellDiv = document.getElementById('add-cell');
    const [rowInput, colInput, conInput]
        = addCellDiv.getElementsByTagName('input');

    try {
        // 몇 번째 행에 데이터를 넣을 건지
        const row = tBody.rows.item(+rowInput.value - 1);
        // 몇 번째 행의, 몇 번째 열에 데이터를 넣을 건지?
        const cell = row.insertCell(+colInput.value - 1);
        // 해당 열의 내용은?
        cell.textContent = conInput.value;
    } catch(e) {
        alert('error !');
    }
}

function del_cell() {
    const addCellDiv = document.getElementById('del-cell');
    const [rowInput, colInput]
        = addCellDiv.getElementsByTagName('input');

    try {
        tBody.rows.item(+rowInput.value - 1).deleteCell(+colInput.value - 1);
    } catch (e) {
        alert('error !');
    }
}

function up_cell() {
    const addCellDiv = document.getElementById('up-cell');
    const [rowInput, colInput, conInput]
        = addCellDiv.getElementsByTagName('input');

    try {
        tBody.rows.item(+rowInput.value - 1).cells.item(+colInput.value-1).textContent = conInput.value;
    } catch (e) {
        alert('error !');
    }
}



// 강사님 풀이
function add_cell() {

}
function remove_cell() {
    const removeCellDiv = document.getElementById('del-cell');
    const [rowInput, colInput] = removeCellDiv.getElementsByTagName('input');
    tBody.rows.item(+rowInput.value - 1).deleteCell(+colInput.value - 1);
}

function update_cell() {
    const updateCellDiv = document.getElementById('up-cell');
    const [rowInput, colInput, contents] = updateCellDiv.getElementsByTagName('input');
    tBody.rows.item(+rowInput.value - 1).cells.item(+colInput.value -1).textContent = contents.value;
}