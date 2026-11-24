<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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

<c:if test="${empty product}">
    <p>商品がありません。</p>
</c:if>

<div style="display:flex; flex-wrap:wrap; gap:40px; width:420px; margin:auto;">

  <c:forEach var="product" items="${product}">

      <form action="ProductDetail.action">
      
          <input type="hidden" name="id" value="${product.productNumber}">
        
          <button type="submit" style="width:180px;height:180px;">
          
              <img alt="${product.productName}" src="/スマ食/images/${product.productImage}" width="80" height="80" >
            
              <br><br>
            

              ${product.productName}
            
              <br><br>
            
              ${product.productPrice}円
         </button>
      </form>
  </c:forEach>
</div>
<br><br>

<table>

<tr>

<td>
<c:choose>
    <c:when test="${backPage == 'seat'}">
        <form action="SeatSelect.action" method="get">
            <button type="submit"
             style="width:130px;height:50px;font-size:20px;">戻る</button>
        </form>
    </c:when>

    <c:when test="${backPage == 'reservation'}">
        <form action="ReserveTypeSelect.action" method="get">
            <button type="submit"
             style="width:130px;height:50px;font-size:20px;">戻る</button>
        </form>
    </c:when>
</c:choose>
</td>

<td width="80"></td>

<td>
<form action="Reservation.action">

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