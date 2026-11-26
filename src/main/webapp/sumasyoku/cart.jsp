<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<body>

<div class="card-header text-center py-3" style="background-color: #f0f0f0;">
	<h1>カート一覧</h1>
</div>


<c:if test="${not empty msg}">
	<script>alert('<c:out value="${msg}" />');</script>
</c:if>

<c:choose>
<c:when test="${empty cartList}">
	<p>カートは空です</p>
</c:when>
<c:otherwise>
<table style="border-collapse: collapse; width: 100%;">
	<thead>
		<tr style="background-color: #f0f0f0;">
			<th>商品名</th>
			<th>価格</th>
			<th>数量</th>
			<th>小計</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="detail" items="${cartList}">
		<tr style="border-bottom: 1px dotted #999; text-align: center;">
			<td><c:out value="${detail.products.productName}" /></td>
			<td>${detail.products.productPrice}円</td>
			<td>
				<form action="CartUpdateExecute.action" method="post" style="display:inline">
					<input type="hidden" name="cartDetailNumber" value="${detail.cartDetailNumber}">
					<input type="hidden" name="quantity" value="${detail.quantity - 1}">
					<button type="submit" ${detail.quantity <= 1 ? 'disabled' : ''}>－</button>
				</form>
				${detail.quantity}
				<form action="CartUpdateExecute.action" method="post" style="display:inline">
					<input type="hidden" name="cartDetailNumber" value="${detail.cartDetailNumber}">
					<input type="hidden" name="quantity" value="${detail.quantity + 1}">
					<button type="submit">＋</button>
				</form>
			</td>
			<td>${detail.cartSubtotal}円</td>
			<td>
				<form action="CartDeleteExecute.action" method="post"
						onsubmit="return confirm('この商品を削除しますか？');">
					<input type="hidden" name="cartDetailNumber" value="${detail.cartDetailNumber}">
					<button type="submit">削除</button>
				</form>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</c:otherwise>
</c:choose>

<div style="text-align: right; font-size: 1.3em; margin: 20px 0;">
	合計：<strong>${cartTotal}円</strong>
</div>

<div>
	<button type="button" onclick="location.href='ProductList.action'">戻る</button>
</div>

</body>
</html>
