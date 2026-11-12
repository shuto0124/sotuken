<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品削除</title>
</head>

<body>

<table border="1" align="center" width="600" height="650">

<tr>
<td align="center">

<h1>商品削除</h1>

<br>

<!-- 商品画像 -->
<img src="../images/product1.jpg"
     width="300"
     height="200"
     alt="商品画像">

<br><br>

<h2>商品番号</h2>

<p>001</p>

<br>

<h2>商品名</h2>

<p>商品A</p>

<br><br>

<form action="productDeleteComplete.jsp" method="post">
    <button type="submit"
            style="width:120px;
                   height:60px;
                   font-size:24px;">
        削除
    </button>
</form>

<br>

<form action="productManagement.jsp">
    <button type="submit"
            style="width:120px;
                   height:60px;
                   font-size:24px;">
        戻る
    </button>
</form>

</td>
</tr>

</table>

</body>
</html>