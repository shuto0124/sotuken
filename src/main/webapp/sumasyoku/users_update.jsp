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
 
            <form action="UsersUpdateExecute.action" method="post">
                
                <input type="hidden" name="user_number" value="${user.userNumber}">
                
                <input type="hidden" name="password" value="${user.password}">
                
                <input type="hidden" name="groupNumber" value="${user.groups.groupNumber}">
                
                
                
 
                <div class="mb-3 row justify-content-center">
                    <label class="text-center">氏名</label>
                    <div class="col-3">
                        <input type="text" name="user_name" class="form-control"
                               value="${user.userName}" required>
                    </div>
                </div>
                
               <div class="mb-3 row justify-content-center">
                     <label class="text-center">ステータス</label>
                       <div class="col-3">
                         <select name="accountStatus" class="form-select">
                         
                         <c:if test="${user.accountStatus eq '削除済み'}">
                             <option value="削除済み" selected>削除済み</option>
                         </c:if>
                         
                           <option value="管理者"
                               <c:if test="${user.accountStatus eq '管理者'}">selected</c:if>>
                                    管理者
                           </option>

                           <option value="登録済み"
                                <c:if test="${user.accountStatus eq '登録済み'}">selected</c:if>>
                                    登録済み
                           </option>

                           <option value="未登録"
                                <c:if test="${user.accountStatus eq '未登録'}">selected</c:if>>
                                    未登録
                           </option>

                       </select>
                     </div>
              </div>
                <div class="d-flex flex-column justify-content-center align-items-center" style="gap: 30px;">
                    <button type="submit" class="btn btn-primary btn-lg " style="padding-top: 10px; padding-bottom: 10px;">登録</button>
                </div>


                
                <div class="d-flex justify-content-center" style="margin-top: 30px;">
                     <a href="UsersList.action" class="btn btn-primary btn-lg " style="padding-top: 10px; padding-bottom: 10px;">戻る</a>
                </div>
            </form>
        </div>
    </c:param>
</c:import>