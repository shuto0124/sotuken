<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="/common/base.jsp">
    <c:param name="title" value="学食システム" />
    <c:param name="content">
 
        <h2 class="fw-bold h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4 text-center">ユーザー更新</h2>
 
        <div class="mx-4">
 
            <c:if test="${not empty error}">
                <div class="alert alert-danger py-2 mb-4">${error}</div>
            </c:if>
 
            <form action="UserUpdateExecute.action" method="post">
                
 
                <div class="mb-3 row justify-content-center">
                    <label class="text-center">氏名</label>
                    <div class="col-3">
                        <input type="text" name="user_name" class="form-control"
                               value="${users.userName}" placeholder="氏名を入力してください" required>
                    </div>
                </div>
                
               <div class="mb-3 row justify-content-center">
                <label class="text-center">ステータス</label>
                    <div class="col-3">
                        <select name="accountStatus" class="form-select">
                            <c:forEach var="a" items="${accountStatus}">
                                <option value="${a}" <c:if test="${a eq user.accountStatus}">selected</c:if>>
                                    ${a}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
 
                <div class="d-flex flex-column justify-content-center align-items-center" style="gap: 30px;">
                    <a class="btn btn-primary btn-lg " style="padding-top: 10px; padding-bottom: 10px;">登録</a>
                    <a class="btn btn-primary btn-lg " style="padding-top: 10px; padding-bottom: 10px;">戻る</a>
                </div>


                
                <div class="d-flex justify-content-center">
                     
                </div>
            </form>
        </div>
    </c:param>
</c:import>