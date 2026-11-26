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

<img src="/スマ食/images/${product.productImage}"
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


<form action="AddCart.action" method="post">

    <input type="hidden" name="productNumber" value="${product.productNumber}">

    <c:if test="${backPage != 'menu'}">

        <c:choose>

            <c:when test="${product.productStock > 0}">

<div style="text-align:center; ">

    <div style="margin-bottom:15px;">
        数量：

        <button type="button" onclick="decrease()">－</button>

        <input type="number"
               id="quantity"
               name="quantity"
               value="1"
               min="1"
               max="${product.productStock}"
               style="width:50px;text-align:center;">

        <button type="button" onclick="increase()">＋</button>
    </div>

    <button type="submit"
            style="width:150px;height:60px;font-size:18px; ">
        カートに入れる<br>
        (残り:${product.productStock}個)
    </button>

</div>

            </c:when>

            <c:otherwise>

                <button type="button"
                        style="width:150px;height:60px;font-size:18px;"
                        disabled>
                    在庫切れ
                </button>

            </c:otherwise>

        </c:choose>

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

<script>
function increase() {
    const qty = document.getElementById("quantity");

    if (parseInt(qty.value) < parseInt(qty.max)) {
        qty.value = parseInt(qty.value) + 1;
    }
}

function decrease() {
    const qty = document.getElementById("quantity");

    if (parseInt(qty.value) > parseInt(qty.min)) {
        qty.value = parseInt(qty.value) - 1;
    }
}
</script>