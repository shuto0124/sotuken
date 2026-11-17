<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約形式選択</title>
</head>

<body>

<table border="1" align="center" width="500" height="500">

<tr>
<td align="center">

<h1>予約</h1>

<br><br>

<form action="productList.jsp">
    <button type="submit"
            style="width:300px; height:80px; font-size:24px;">
        商品の予約
    </button>
</form>

<br><br>

<form action="seatSelect.jsp">
    <button type="submit"
            style="width:300px; height:80px; font-size:24px;">
        座席と商品の予約
    </button>
</form>

<br><br><br>

<form action="../index.jsp">
    <button type="submit"
            style="width:120px; height:50px; font-size:20px;">
        戻る
    </button>
</form>

</td>
</tr>

</table>

</body>
</html>