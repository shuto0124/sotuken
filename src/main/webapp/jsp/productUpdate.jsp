<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!-- No1: 画面タイトル -->
<div class="card shadow-sm mx-auto" style="max-width: 500px; background-color: #f8f9fa;">
	<h1>商品更新</h1>
</div>

<form action="productUpdateExecute.action" method="post">
	<input type="hidden" name="productNumber" value="${product.productNumber}">
	<p>
	商品名	：
	<input type="text" name="productName" value="${product.productName}">
	</p> 

	<p>
	商品説明：
	<textarea name="productDescription" rows="4" cols="40">${product.description}></textarea>
	</p>

	<p>
	商品価格：
	<input type="text" name="productPrice" value="${product.productPrice}">
	</p>

	<p>
	<img src="${pageContext.request.contextPath}/images/${product.productImage}"
		 alt="ダミー画像" width="100" height="100">
	<p class="mb-1"></p>
	<input type="file" name="imgFile" accept="imgs/*">
	</p>
	<button type="submit">更新</button>
</form>

<button type="button" onclick="location.href='productManager.jsp'">戻る</button>
