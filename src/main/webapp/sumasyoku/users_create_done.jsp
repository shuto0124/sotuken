<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="/common/base.jsp">
    <c:param name="title" value="学食システム" />
    <c:param name="content">
 
        <h2 class="fw-bold h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4 text-center">ユーザー登録成功</h2>
 
        <div class="mx-4">
 
            <c:if test="${not empty error}">
                <div class="alert alert-danger py-2 mb-4">${error}</div>
            </c:if>
            
            <a href="UsersList.action" class="btn btn-primary btn-lg " style="padding-top: 10px; padding-bottom: 10px;">戻る</a>
 
        </div>
    </c:param>
</c:import>