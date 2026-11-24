<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>

<body>

<%


String id = request.getParameter("id");


String name = "";
String image = "";
String description = "";


if ("1".equals(id)) {

    name = "商品A";
    image = "../images/productA.jpg";
    description = "商品Aの説明です。";

} else if ("2".equals(id)) {

    name = "商品B";
    image = "../images/productB.jpg";
    description = "商品Bの説明です。";

} else if ("3".equals(id)) {

    name = "商品C";
    image = "../images/productC.jpg";
    description = "商品Cの説明です。";

} else if ("4".equals(id)) {

    name = "商品D";
    image = "../images/productD.jpg";
    description = "商品Dの説明です。";

}

%>

<table border="1" align="center" width="600" height="750">

<tr>
<td align="center">

<h1>商品詳細</h1>

<br>



<table border="1" width="450" height="100">
<tr>
<td align="center">
<h2><%= name %></h2>
</td>
</tr>
</table>

<br>



<table border="1" width="450" height="200">
<tr>
<td align="center">

<img src="<%= image %>"
     width="150"
     height="150"
     alt="<%= name %>">

</td>
</tr>
</table>

<br>



<table border="1" width="450" height="150">
<tr>
<td align="center">

<h3>商品説明</h3>

<%= description %>

</td>
</tr>
</table>

<br><br>



<table>
<tr>

<td>



<form action="productList.action">

<button type="submit"
        style="width:130px;height:50px;font-size:20px;">

戻る

</button>

</form>

</td>

<td width="50"></td>

<td>



<form action="addCart.jsp" method="post">

<input type="hidden" name="id" value="<%= id %>">

<button type="submit"
        style="width:150px;height:50px;font-size:18px;">

カートに入れる

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