<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- No1: 画面タイトル -->
<div class="card shadow-sm mx-auto" style="max-width: 500px; background-color: #f8f9fa;">
	<h1>商品登録</h1>
</div>

<form action="productRegisterExecute.action" method="post">
		<p>
       	商品番号：
       	<input type="number" name="productNumber" required>
       	</p>      	
     	
     	<p>
       	商品名	：
       	<input type="text" name="productName" required>
       	</p> 
       	
       	<p>
       	商品説明：
       	<textarea name="productDescription" rows="4" cols="40" required></textarea>
       	</p>
       	
       	<p>
       	商品価格：
       	<input text="text" name="productPrice" required>
       	</p>
       	
       	<p>
       	商品画像：
       	<input type="file" name="imgFile" accept="imgs/*" required>
       	</p>
        <button type="submit">登録</button>
    </form>
    <button type="button" onclick="location.href='productManager.jsp'">戻る</button>
</div>
