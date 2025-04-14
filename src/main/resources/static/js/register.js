let skillIndex = 1;
// スキル行の追加
function addSkillRow() {
	const tableBody = document.getElementById("skillTableBody");
	const baseRow = tableBody.querySelector("tr");
	const newRow = baseRow.cloneNode(true); // スキル行をコピー

	// 各要素のname属性をskillIndexに合わせて変更し、値を初期化
	newRow.querySelectorAll("select, input").forEach((el) => {
	    if (el.name) {
	        el.name = el.name.replace(/\[0\]/, `[${skillIndex}]`);
	    }
	    if (el.tagName === "SELECT") {
	        el.selectedIndex = 0; // 初期化（最初のoptionに）
	    }
	    if (el.tagName === "INPUT") {
	        el.value = ""; // 入力値を空に
	    }
	});

	// 削除ボタンのonclickを再設定（安全のため）
	const removeBtn = newRow.querySelector("button.remove-btn");
	if (removeBtn) {
	    removeBtn.setAttribute("onclick", "removeSkillRow(this)");
	}

	tableBody.appendChild(newRow);
	skillIndex++;
}

// スキル行の削除
function removeSkillRow(button) {
    /*let row = button.parentNode.parentNode; // 削除ボタンの親の親が行*/
	const row = button.closest("tr");
    row.remove(); // 行を削除
}