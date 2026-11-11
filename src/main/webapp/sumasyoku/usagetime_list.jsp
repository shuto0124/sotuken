<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="/common/base.jsp">
    <c:param name="title" value="学食システム" />
    <c:param name="content">
    

 
        <h2 class="fw-bold h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4 text-center w-100">利用時間管理</h2>
 
       <div class="d-flex flex-column justify-content-center align-items-center" style="min-height: 70vh;">
        <div class="mx-4 w-100">
 
            <c:if test="${not empty error}">
                <div class="alert alert-danger py-2 mb-4">${error}</div>
            </c:if>
 
            <form action="UsageTimeUpdateExecute.action" method="post">
                
 
                <div class="mb-3 row justify-content-center">
                    <label class="text-center h2 my-4">テーブルの利用時間</label>
                    <div class="text-center mb-2 h2 my-4">
                        <c:choose>
                            <c:when test="${not empty manegements.reservationDuration}">
                            現在の設定時間:${manegements.reservationDuration}分
                            </c:when>
                            <c:otherwise>
                                現在は設定されていません
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="col-3">
                       <div class="input-group">
                        <input type="text" name="reservation_duration" class="form-control"
                               value="${manegements.reservationDuration}" required>
                        <span class="input-group-text">分</span>
                       </div>
                    </div>
                </div>
                
               <div class="mb-3 row justify-content-center">
                <label class="text-center my-4 h2">システムの利用時間</label>
                    <div class="col-5 d-flex ">
                       <input type="text" name="system_starttime" class="form-control"
                               value="${manegements.systemStartTime}" required>
                               <span class="input-group-text">時</span>
                               
                               <span class="mx-2 mt-2">～</span>
                               
                       <input type="text" name="system_endtime" class="form-control"
                               value="${manegements.systemEndTime}" required>
                               <span class="input-group-text">時</span>                       
                    </div>
                </div>
 
                <div class="d-flex flex-column justify-content-center align-items-center" style="gap: 30px;">
                    <a class="btn btn-primary btn-lg my-4 py-4 fs-4" style="width:200px; padding-top: 10px; padding-bottom: 10px;">登録</a>
                    <a class="btn btn-primary btn-lg  py-4 fs-4" style="width:200px; padding-top: 10px; padding-bottom: 10px;">戻る</a>
                </div>


                
                <div class="d-flex justify-content-center">
                     
                </div>
            </form>
        </div>
        </div>
    </c:param>
</c:import>