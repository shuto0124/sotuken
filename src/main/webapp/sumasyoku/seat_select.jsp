<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>座席予約</title>
</head>

<body>

<table border="1" align="center" width="500" height="600">

<tr>
<td align="center">

<h1>座席予約</h1>

<p>予約したい席のボタンを押してください</p>

<br>

<table>

<tr>
    <td align="center">
        テーブルA1<br><br>

        <form action="productList.jsp">
            <input type="hidden" name="seat" value="A1">

            <button type="submit"
                    style="width:120px;height:120px;font-size:24px;">
                4人席
            </button>
        </form>
    </td>

    <td width="30"></td>

    <td align="center">
        テーブルA2<br><br>

        <form action="productList.jsp">
            <input type="hidden" name="seat" value="A2">

            <button type="submit"
                    style="width:120px;height:120px;font-size:24px;">
                4人席
            </button>
        </form>
    </td>
</tr>

<tr>
<td colspan="3">
<br><br>
</td>
</tr>

<tr>
    <td align="center">
        テーブルB1<br><br>

        <form action="productList.jsp">
            <input type="hidden" name="seat" value="B1">

            <button type="submit"
                    style="width:120px;height:120px;font-size:24px;">
                2人席
            </button>
        </form>
    </td>

    <td width="30"></td>

    <td align="center">
        テーブルB2<br><br>

        <button disabled
                style="width:120px;height:120px;font-size:24px;">
            予約済
        </button>
    </td>
</tr>

</table>

<br><br>

<form action="reserveType.jsp">
    <button type="submit"
            style="width:120px;height:50px;font-size:20px;">
        戻る
    </button>
</form>

</td>
</tr>

</table>

</body>
</html>