<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>

<body>



<table border="1" align="center" width="600" height="750">

<tr>
<td align="center">

<h1>商品詳細</h1>

<br>



<table border="1" width="450" height="100">
<tr>
<td align="center">
<h2>${product.productName}</h2>
</td>
</tr>
</table>

<br>



<table border="1" width="450" height="200">
<tr>
<td align="center">

<img src="/sotukenn/images/${product.productImage}"
     width="150"
     height="150"
     alt="${product.productName}">

</td>
</tr>
</table>

<br>



<table border="1" width="450" height="150">
<tr>
<td align="center" valign="top">

<h3>商品説明</h3>

<div>
${product.productDescription}
</div>

</td>
</tr>
</table>

<br><br>



<table>
<tr>

<td>

<c:choose>

    <c:when test="${backPage == 'reservation'}">
        <form action="ProductList.action" method="get">
            <button type="submit"
             style="width:130px;height:50px;font-size:20px;">戻る</button>
        </form>
    </c:when>
    
    <c:when test="${backPage == 'menu'}">
        <form action="Menu.action" method="get">
            <button type="submit"
             style="width:130px;height:50px;font-size:20px;">戻る</button>
        </form>
    </c:when>
</c:choose>

</td>

<td width="50"></td>

<td>


<form action="addCart.jsp" method="post">

    <input type="hidden" name="productNumber" value="${product.productNumber}">

<c:if test="${backPage != 'menu'}">
  <button type="submit"
          style="width:150px;height:60px;font-size:18px;" ${product.productStock == 0  ? 'disabled' : ''}>

  カートに入れる
  (残り:${product.productStock}個)

  </button>

</c:if>

</form>

<c:if test="${backPage == 'menu'}">
    <div style="width:150px;height:55px;font-size:30px;text-align:center;">
        残り:${product.productStock}個
    </div>
</c:if>

</td>

</tr>
</table>

</td>
</tr>

</table>

</body>
</html>