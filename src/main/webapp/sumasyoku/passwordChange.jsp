<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<p>学食システム</p>
<div class="card-header text-center py-3">
<h1>パスワード変更</h1>
</div>
<form action="passwordExecute.action" method="post"> 
<!-- No1: 現在のパスワード -->
	<div class="mb-3 position-relative">現在のパスワード
	<input type="password" name="currentPassword" required>
	</div>
<!-- No2: 新しいパスワード -->
	<div class="mb-3 position-relative">新しいパスワード
	<input type="password" name="newPassword" required>
	</div>
<!-- No3: 確認用パスワード -->	
	<div class="mb-3 position-relative">新しいパスワード（確認用）
	<input type="password" name="confirmPassword" required>
	</div>

	<div class="text-center">
	<button type="submit">変更する
	</button>
	</div>
</form>
<button type="button" onclick="location.href='top.jsp'">トップ</button>