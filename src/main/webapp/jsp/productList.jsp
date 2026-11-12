<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品予約</title>
</head>

<body>

<table border="1" align="center" width="600" height="750">

<tr>
<td align="center">

<h1>商品予約</h1>

<br>

<table>

<tr>

<td align="center">
<form action="productDetail.jsp">
<input type="hidden" name="id" value="1">

<button type="submit"
        style="width:180px;height:180px;">

<img src="../images/productA.jpg"
     width="80"
     height="80"
     alt="商品A">

<br><br>

商品A

<br><br>

500円

</button>

</form>
</td>

<td width="30"></td>

<td align="center">
<form action="productDetail.jsp">
<input type="hidden" name="id" value="2">

<button type="submit"
        style="width:180px;height:180px;">

<img src="../images/productB.jpg"
     width="80"
     height="80"
     alt="商品B">

<br><br>

商品B

<br><br>

300円

</button>

</form>
</td>

</tr>

<tr>
<td colspan="3">
<br>
</td>
</tr>

<tr>

<td align="center">
<form action="productDetail.jsp">
<input type="hidden" name="id" value="3">

<button type="submit"
        style="width:180px;height:180px;">

<img src="../images/productC.jpg"
     width="80"
     height="80"
     alt="商品C">

<br><br>

商品C

<br><br>

700円

</button>

</form>
</td>

<td></td>

<td align="center">
<form action="productDetail.jsp">
<input type="hidden" name="id" value="4">

<button type="submit"
        style="width:180px;height:180px;">

<img src="../images/productD.jpg"
     width="80"
     height="80"
     alt="商品D">

<br><br>

商品D

<br><br>

400円

</button>

</form>
</td>

</tr>

</table>

<br><br>

<table>

<tr>

<td>
<form action="reserveType.jsp">

<button type="submit"
        style="width:130px;height:50px;font-size:20px;">
戻る
</button>

</form>
</td>

<td width="80"></td>

<td>
<form action="reservation.jsp">

<button type="submit"
        style="width:130px;height:50px;font-size:20px;">
注文
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