
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>座席予約</title>

<style>
    .seat-button {
        width: 120px;
        height: 120px;
        font-size: 24px;
        cursor: pointer;
    }

    .available {
        background-color: #90EE90;
    }

    .temporary {
        background-color: #FFFF99;
    }

    .reserved {
        background-color: #FF9999;
    }

    .stopped {
        background-color: #CCCCCC;
    }

    .seat-button:disabled {
        cursor: not-allowed;
        color: black;
    }
</style>

</head>

<body>

<table border="1" align="center" width="500" height="600">
<tr>
<td align="center">

<h1>座席予約</h1>
<p>予約したい席のボタンを押してください</p>

<!-- エラーメッセージ -->
        <c:if test="${not empty msg}">
            <p class="login-error">
                ${msg}
            </p>

<br>

<table>

<tr>
    <td align="center">
        テーブル1<br><br>

        <form action="SeatSelectExecute.action" method="get">
            <input type="hidden" name="tableNumber" value="1">
            <button type="submit"
                id="table-1"
                class="seat-button">
                読み込み中
            </button>
        </form>
    </td>

    <td width="30"></td>

    <td align="center">
        テーブル2<br><br>

        <form action="SeatSelectExecute.action" method="get">
            <input type="hidden" name="tableNumber" value="2">
            <button type="submit"
                id="table-2"
                class="seat-button">
                読み込み中
            </button>
        </form>
    </td>
</tr>

<tr>
    <td colspan="3"><br><br></td>
</tr>

<tr>
    <td align="center">
        テーブル3<br><br>

        <form action="SeatSelectExecute.action" method="get">
            <input type="hidden" name="tableNumber" value="3">
            <button type="submit"
                id="table-3"
                class="seat-button">
                読み込み中
            </button>
        </form>
    </td>

    <td width="30"></td>

    <td align="center">
        テーブル4<br><br>

        <form action="SeatSelectExecute.action" method="get">
            <input type="hidden" name="tableNumber" value="4">
            <button type="submit"
                id="table-4"
                class="seat-button">
                読み込み中
            </button>
        </form>
    </td>
</tr>

</table>

<br><br>

<form action="reserve_type.jsp">
    <button type="submit"
        style="width:120px;height:50px;font-size:20px;">
        戻る
    </button>
</form>

</td>
</tr>
</table>


<script>

// 座席情報を取得して画面を更新する
async function updateSeats() {

    try {

        const response = await fetch("SeatSelectUpdate.action");

        if (!response.ok) {
            throw new Error("座席情報の取得に失敗しました");
        }

        const seats = await response.json();

        // 取得した座席情報を順番に処理
        seats.forEach(seat => {

            const button = document.getElementById(
                "table-" + seat.tableNumber
            );

            // JSPに存在しないボタンは無視
            if (!button) {
                return;
            }

            // ボタンの状態を初期化
            button.className = "seat-button";
            button.disabled = true;

            // 座席の種類と状態を表示
            if (seat.tableStatus === "空席") {

                button.textContent = seat.tableType;
                button.classList.add("available");
                button.disabled = false;

            } else if (seat.tableStatus === "仮予約") {

                button.textContent = "仮予約中";
                button.classList.add("temporary");

            } else if (seat.tableStatus === "予約") {

                button.textContent = "予約済";
                button.classList.add("reserved");

            } else if (seat.tableStatus === "利用停止") {

                button.textContent = "利用停止";
                button.classList.add("stopped");

            } else {

                button.textContent = "状態不明";
            }

        });

    } catch (error) {

        console.error(error);

    }
}

window.addEventListener("pageshow", async function() {

    // 自分の仮予約を解除
    try {
        await fetch("SeatReservationCancel.action", {
            method: "POST"
        });
    } catch (error) {
        console.error("仮予約の解除に失敗しました", error);
    }


// 座席情報を取得
updateSeats();

// 1秒ごとに座席情報を更新
setInterval(updateSeats, 1000);
});
</script>

</body>
</html>
