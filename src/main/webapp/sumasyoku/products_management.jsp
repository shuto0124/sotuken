<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<!-- No1: 画面タイトル -->
<div class="card-header text-center py-3" style="background-color: #f0f0f0;">
<h1>商品管理</h1>
</div>
<button type="button" onclick="location.href='ProductRegister.action'">登録</button>
<button type="button" onclick="location.href='Managements.action'">戻る</button>
<p class="mb-3"></p>

<c:forEach var="product" items="${productList}">
	<div style="border-bottom: 2px dotted #999; padding: 15px 0;">
			<img src="${pageContext.request.contextPath}/images/${product.productImage}" 
				 alt="${product.productName}" width="100" height="100">
			<p>商品名：${product.productName}</p>
			<p>価格：${product.productPrice}</p>
			<form action="productStockExecute.action" method="post">
				<p>提供数：${product.productStock}</p> 
				<input type="hidden" name="productNumber" value="${product.productNumber }">
				<input type="number" name="productStock" min="0" required>
				<button type="submit">提供数更新</button>
			</form>    
			<button type="button" onclick="location.href='ProductUpdate.action?productNumber=${product.productNumber}'">更新</button>
			<button type="button" onclick="location.href='ProductDelete.action?productNumber=${product.productNumber}'">削除</button>
			<p class="mb-3"></p>
	</div>		
</c:forEach>
