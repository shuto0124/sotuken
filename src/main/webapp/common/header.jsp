<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<div class="d-flex justify-content-between align-items-center w-100">

    
    <h1 class="title">学食システム</h1>

    <c:if test="${not empty sessionScope.teacher}">
        <div class="login-user-box">
            <span>${sessionScope.teacher.name} 様</span>
            <a href="Logout.action" class="ms-3">ログアウト</a>
        </div>
    </c:if>
</div>


