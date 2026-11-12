<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="/common/base.jsp">
    <c:param name="title">
        学食システム
    </c:param>
    
    <c:param name="scripts"></c:param>
    
    <c:param name="content">
        <section>
            <h2 class="fw-bold h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4 text-center">ユーザー管理</h2>
           
            <c:choose>
                <c:when test="${users.size() > 0}">
                    <table class="table table-hover">
                        <tr>
                            <th>個人番号</th>
                            <th>氏名</th>
                            <th>アカウント状態</th>
                        </tr>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.userNumber}</td>
                                <td>${user.userName}</td>
                                <td>${user.accountStatus}</td>
                                <td><a href="UserUpdate.action?user_number=${user.userNumber}" class="btn btn-primary btn-lg w-30">変更</a></td>
                                <td><a href="UserDelete.action?user_number=${user.userNumber}" class="btn btn-primary btn-lg w-30">削除</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <div>ユーザーが存在しません</div>
                </c:otherwise>
             </c:choose>
             <div class="my-2 text-end px-4">
                <a href="StudentCreate.action" class="btn btn-primary btn-lg w-50">新規登録</a>
             </div>
        </section>
    </c:param>
</c:import>
