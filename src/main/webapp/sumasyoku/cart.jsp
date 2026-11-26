<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<!-- No1: 画面タイトル -->
<div class="card-header text-center py-3" style="background-color: #f0f0f0;">
<h1>カート一覧</h1>
</div>
<c:if test="${not empty msg}">
    <script>
        alert('<c:out value="${msg}" />');
    </script>
</c:if>

<div>
	<p>合計：${cartTotal}</p>
</div>

<p class="mb-3"></p>

<c:forEach var="detail" items="${cartList}">
	<div style="border-bottom: 2px dotted #999; padding: 15px 0;">
		<p>商品名：<c:out value="${detail.products.productName}" /></p>
		<p>価格：${detail.products.productPrice}円</p>
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
		<p>小計：${detail.cartSubtotal}円</p>
		<form action="CartDeleteExecute.action"
				method="post" onsubmit="return confirm('この商品を削除しますか？');">
			<input type="hidden" name="cartDetailNumber" value="${detail.cartDetailNumber}">
			<button type="submit">削除</button>
		</form>
		<p class="mb-3"></p>
	</div>
</c:forEach>
</html>