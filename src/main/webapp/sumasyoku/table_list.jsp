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
            <h2 class="fw-bold h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4 text-center">テーブル管理</h2>
           
            <c:choose>
             <c:when test="${tables.size() > 0}">
                <div class="row">
                   <c:forEach var="table" items="${tables}">
                    <div class="col-6 mb-4">
                       <div class="border border-2 p-3 text-center position-relative" style="height:120px;">

                         <div class="position-absolute top-0 start-50 translate-middle bg-white px-2 fw-bold">
                             ${table.tableStatus}
                         </div>
 
                         <div class="d-flex align-items-center justify-content-center h-100">
                             <a href="TableUpdate.action?id=${table.tableNumber}" class="btn btn-light fw-bold">
                                 テーブル${table.tableNumber}
                             </a>
                         </div>

                      </div>
                    </div>
                   </c:forEach>
                </div>
             </c:when>
              <c:otherwise>
                   <div>テーブルが存在しません</div>
              </c:otherwise>
            </c:choose>

            <div class="my-2 text-end px-4">
               <a href="Menu.action" class="btn btn-primary btn-lg">戻る</a>
            </div>
       </section>
    </c:param>
</c:import>