
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="true" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>注文管理</title>

<style>
    body {
        font-family: sans-serif;
    }

    h1 {
        text-align: center;
    }

    #groupList {
        width: 680px;
        max-width: 95%;
        margin: 15px auto;
    }

    .group-tab {
        border: 1px solid #999;
        border-radius: 5px;
        margin: 15px 0;
    }

    .group-header {
        padding: 15px;
        background-color: #eee;
        cursor: pointer;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .group-header:hover {
        background-color: #ddd;
    }

    .group-detail {
        padding: 15px;
    }

    .member {
        border: 1px solid #ccc;
        padding: 10px;
        margin: 10px 0;
        background-color: #fafafa;
    }

    .member-info {
        display: flex;
        justify-content: space-between;
        margin: 5px 0;
    }

    .product {
        display: flex;
        justify-content: space-between;
        padding: 4px 0 4px 15px;
    }

    .status {
        margin-top: 15px;
        text-align: right;
    }

    #updateTime {
        text-align: center;
        color: #666;
    }
</style>

</head>

<body>

<h1>注文管理</h1>

<p id="updateTime">データ取得中...</p>

<div id="groupList"></div>

<script>

console.log("JavaScript読み込み成功1");

// タブの開閉状態を保存する
const openedGroups = new Set();

// プルダウンの変更状態を保存する
const statusOverrides = {};

// 初回表示
window.addEventListener("DOMContentLoaded", function() {
    updateOrderList();

    // 5秒ごとに更新
    setInterval(updateOrderList, 5000);
});


// 注文データを取得する
async function updateOrderList() {

    console.log("JavaScript読み込み成功2");

    try {

        const response = await fetch("ReservationListUpdate.action", {
            method: "GET",
            cache: "no-store"
        });

        if (!response.ok) {
            throw new Error("データ取得に失敗しました");
        }

        const groups = await response.json();

        // 一覧を更新
        displayOrderList(groups);

        // 更新時刻
        document.getElementById("updateTime").textContent =
            "最終更新：" + new Date().toLocaleTimeString();

    } catch (error) {

        console.error(error);

        document.getElementById("updateTime").textContent =
            "更新に失敗しました。次回の更新を待っています。";
    }
}


// 注文一覧を表示する
function displayOrderList(groups) {

    const groupList = document.getElementById("groupList");

    // 更新前の開閉状態を保存
    document.querySelectorAll(".group-detail").forEach(function(detail) {

        const groupNumber = detail.dataset.groupNumber;

        if (detail.style.display !== "none") {
            openedGroups.add(groupNumber);
        } else {
            openedGroups.delete(groupNumber);
        }
    });

    let html = "";

    groups.forEach(function(group) {

        const isOpen = openedGroups.has(String(group.groupNumber));

        html += `
            <div class="group-tab">

                <div class="group-header"
                     onclick="toggleDetail('${group.groupNumber}')">

                    <div>
                        <strong>グループ ${group.groupNumber}</strong><br>
                        利用時間：${group.usageTime} ／ ${group.memberCount}人
                    </div>

                    <div>
                        <strong>${group.totalAmount.toLocaleString()}円</strong><br>
                        ${group.status}
                    </div>

                    <span>${isOpen ? "▲" : "▼"}</span>

                </div>

                <div class="group-detail"
                     id="detail-${group.groupNumber}"
                     data-group-number="${group.groupNumber}"
                     style="display: ${isOpen ? "block" : "none"};">

                    <h3>注文者・注文内容</h3>
        `;

        group.orders.forEach(function(order) {

            html += `
                <div class="member">

                    <strong>学生番号：${order.userNumber}</strong>
                    <span>　注文番号：${order.orderNumber}</span>

                    <hr>
            `;

            order.products.forEach(function(product) {

                html += `
                    <div class="product">
                        <span>${product.productName} × ${product.quantity}</span>
                        <span>${product.subtotal.toLocaleString()}円</span>
                    </div>
                `;

            });

            html += `
                    <div class="member-info">
                        <strong>小計</strong>
                        <strong>${order.totalAmount.toLocaleString()}円</strong>
                    </div>

                </div>
            `;

        });

        html += `
                    <hr>

                    <div class="member-info">
                        <strong>グループ合計</strong>
                        <strong>${group.totalAmount.toLocaleString()}円</strong>
                    </div>

                    <div class="status">

                        ステータス：

                        <select id="status-${group.groupNumber}"
                                onchange="changeStatus('${group.groupNumber}', this.value)">

                            <option value="未払い">未払い</option>
                            <option value="調理中">調理中</option>
                            <option value="受取可能">受取可能</option>
                            <option value="支払済み">支払済み</option>

                        </select>

                        <button type="button"
                                onclick="updateStatus('${group.groupNumber}')">
                            更新
                        </button>

                    </div>

                </div>
            </div>
        `;

    });

    // 作成したHTMLを画面に反映
    groupList.innerHTML = html;

    // ステータスの選択状態を復元
    groups.forEach(function(group) {

        const selectedStatus =
            statusOverrides[group.groupNumber] ?? group.status;

        document.getElementById("status-" + group.groupNumber).value =
            selectedStatus;

    });

}


// タブの開閉
function toggleDetail(groupNumber) {

    const detail = document.getElementById("detail-" + groupNumber);

    if (detail.style.display === "none") {

        detail.style.display = "block";
        openedGroups.add(String(groupNumber));

    } else {

        detail.style.display = "none";
        openedGroups.delete(String(groupNumber));

    }
}


// ステータスの変更を一時保存
function changeStatus(groupNumber, status) {

    statusOverrides[groupNumber] = status;

}


// ステータス更新ボタン
function updateStatus(groupNumber) {

    const status = statusOverrides[groupNumber];

    if (!status) {

        alert("ステータスを選択してください。");
        return;

    }

    alert("サンプル画面のため、DBへの更新は行いません。");

}

</script>
<form action="adminMenu.jsp">
    <button type="submit"
            style="width:120px;height:50px;">
        戻る
    </button>
</form>

</body>
</html>
