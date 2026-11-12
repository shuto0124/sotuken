<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文確認</title>
</head>

<body>

<table border="1" align="center" width="550" height="700">

<tr>
<td align="center">

<h1>注文確認</h1>

<br>

<table border="1" width="330">

<tr>
    <th>商品名</th>
    <th>値段</th>
</tr>

<tr>
    <td align="center">商品A</td>
    <td align="center">500円</td>
</tr>

<tr>
    <td align="center">商品B</td>
    <td align="center">300円</td>
</tr>

<tr>
    <td align="center">商品C</td>
    <td align="center">200円</td>
</tr>

</table>

<br><br>

<table border="1" width="380">

<tr>
    <td align="center">AAA</td>
    <td align="center">BBB</td>
</tr>

<tr>
    <td align="center">CCC</td>
    <td align="center">DDD</td>
</tr>

</table>

<br><br>

<table>

<tr>

<td>

<table border="1">
<tr>
    <td>テーブル番号</td>
    <td>A1</td>
</tr>

<tr>
    <td>利用時間</td>
    <td>12:00～13:00</td>
</tr>

</table>

</td>

<td width="40"></td>

<td>

<table border="1">
<tr>
    <td align="center">
        合計金額<br>
        1,000円
    </td>
</tr>
</table>

</td>

</tr>

</table>

<br><br>

<table>

<tr>

<td>

<form action="seatSelect.jsp">
<button type="submit"
        style="width:120px;height:50px;font-size:20px;">
戻る
</button>
</form>

</td>

<td width="50"></td>

<td>

<form action="orderWait.jsp">
<button type="submit"
        style="width:120px;height:50px;font-size:20px;">
確定
</button>
</form>

</td>

</tr>

</table>

</td>
</tr>

</table>

</body>
</html>