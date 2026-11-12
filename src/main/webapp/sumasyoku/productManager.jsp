<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<!-- No1: 画面タイトル -->
<div class="card-header text-center py-3" style="background-color: #f0f0f0;">
<h1>商品管理</h1>
</div>
<button type="button" onclick="location.href='productRegister.jsp'">登録</button>
<button type="button" onclick="location.href='top.jsp'">戻る</button>
<p class="mb-3"></p>

<%--<c:forEach var="product" items="${productList}">--%>
			<img src="${pageContext.request.contextPath}/images/${product.productImage}" 
				 alt="ダミー画像" width="100" height="100">
			<p>商品名：${product.productName}</p>
			<p>価格：${product.productPrice}</p>
			<form action="productStockExecute.action" method="post">
				<p>提供数：${product.productStock}</p> 
				<input type="hidden" name="productNumber" value="${product.productNumber }">
				<input type="number" name="productStock" min="0" required>
				<button type="submit">提供数更新</button>
			</form>    
			<button type="button" onclick="location.href='productUpdate.jsp?productNumber=${product.productNumber}'">更新</button>
			<button type="button" onclick="location.href='productDelete.jsp?productNumber=${product.productNumber}'">削除</button>
<%--</c:forEach>--%>