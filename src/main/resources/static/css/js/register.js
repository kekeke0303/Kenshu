// スキル行の追加
function addSkillRow() {
    let tableBody = document.getElementById('skillTableBody');
    let row = tableBody.rows[0].cloneNode(true); // 最初の行を複製
    tableBody.appendChild(row);
}

// スキル行の削除
function removeSkillRow(button) {
    let row = button.parentNode.parentNode; // 削除ボタンの親の親が行
    row.remove(); // 行を削除
}