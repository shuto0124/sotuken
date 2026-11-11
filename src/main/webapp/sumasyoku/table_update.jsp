<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="/common/base.jsp">
    <c:param name="title" value="学食システム" />
    <c:param name="content">
 
        <h2 class="fw-bold h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4 text-center">テーブル${table.tableNumber }利用状況</h2>
 
        <div class="mx-4">
 
            <c:if test="${not empty error}">
                <div class="alert alert-danger py-2 mb-4">${error}</div>
            </c:if>
 
            <form action="TableUpdateExecute.action" method="post">
                
 
 <table class="table table-bordered w-50 mx-auto text-center align-middle">
    <tr>
        <th>テーブル番号</th>
        <td>${table.tableNumber}</td>
    </tr>
    <tr>
        <th>利用状況</th>
        <td>${table.tableStatus}</td>
    </tr>
    <tr>
        <th>利用停止にする</th>
<td>
    <div class="d-flex justify-content-center align-items-center gap-2">
        <label class="toggle">
            <input type="checkbox" id="tableStatus">
            <span class="slider"></span>
        </label>

        <span id="statusText">開始</span>
    </div>
</td>
    </tr>
</table>
                
                <div class="d-flex flex-column justify-content-center align-items-center" style="gap: 30px;">
                    <a href="TableUpdate.action" class="btn btn-primary btn-lg " style="padding-top: 10px; padding-bottom: 10px;">変更</a>
                    <a class="btn btn-primary btn-lg " style="padding-top: 10px; padding-bottom: 10px;">戻る</a>
                </div>

                
                <div class="d-flex justify-content-center">
                     
                </div>
            </form>
        </div>
    </c:param>
</c:import>