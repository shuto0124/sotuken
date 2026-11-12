<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!-- No1: 画面タイトル -->
<p>学食システム</p>
<div class="card-header text-center py-3" >
<h1>グループ</h1>
</div>
<!-- No2: グループID入力 -->
<div class="mb-3 position-relative">
    <form action="groupExecute.action" method="post">
    <p>グループナンバー入力:                    
	<input type="number" name="groupNumber" required placeholder="グループナンバー半角でご入力ください">
	</form>
	<div class="card-body p-4 bg-white">
		<p>グループナンバー:<c:out value="${group.groupNumber}" /></p>
		<p>人数:<c:out value="${group.memberCount}人" /></p>
		<c:forEach var="user" items="${userList}">
			<p>${userList.userName}</p>
		</c:forEach>
		<div class="text-center">
			<button type="button" onclick="location.href='top.jsp'">戻る</button>
		</div>
		<div class="text-center">
			<button type="button" >グループからぬける</button>
		</div>
	</div>
</div>
