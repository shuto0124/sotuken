<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!-- No1: 画面タイトル -->
<div class="card-header text-center py-3" style="background-color: #f0f0f0;">
<h1>商品削除</h1>
</div>
 
<form action="productDeleteExecute.action" method="post">
 <input type="hidden" name="productNumber" value="${product.productNumber }">
 <div>
	<p>
	<img src="${pageContext.request.contextPath}/images/${product.productImage}"  alt="ダミー画像" width="100" height="100">
	</p>
		
	<p>
	商品番号：${product.productNumber }
	</p>      	
	
	<p>
	商品名	：${product.productName}
	</p> 
</div> 
<button type="submit">削除</button>
</form>

<button type="button" onclick="location.href='productManager.jsp'">戻る</button>

