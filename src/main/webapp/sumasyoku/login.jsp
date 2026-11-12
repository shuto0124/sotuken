<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="card-header text-center py-3" style="background-color: #f0f0f0;">
<h1>ログイン</h1>
</div>
<form action="userLoginExecute.action" method="post"> 
 <!-- No1: ログインID -->
	<div class="mb-3 position-relative">個人番号
	</span>
	 <input type="text" name="userNumber" required placeholder="半角でご入力ください">
 	</div>

<!-- No2: パスワード -->
	<div class="mb-3 position-relative">パスワード
	</span>
	<input type="password" name="password" required placeholder="30文字以内の半角英数字でご入力ください">
	</div>

<!-- No3: 登録ボタン -->
	<div class="text-center">
	<button type="submit">ログインする
	</button>
	</div>
</form>

<button type="button" onclick="location.href='start.jsp'">戻る</button>