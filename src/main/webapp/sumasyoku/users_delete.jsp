<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
 
<c:import url="/common/base.jsp">
    <c:param name="title" value="学食システム" />
 
    <c:param name="content">
 
		<h2 class="fw-bold h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4 text-center">学生削除</h2>
		
		<div class="mx-4">
 
            <form action="SubjectDeleteExecute.action" method="post">
            	<input type="hidden" name="user_name" value="${users.userName}">
 
	                <div class="mb-3 row justify-content-center text-center">
	                    <div class="col-10 py-2 ">
	                        <h2>個人番号</h2>
	                    	<h2>${users.userNumber}</h2>
	                    	<br>
	                    	<h2>氏名</h2>
	                    	<h2>${users.userName}</h2>
	                        <input type="hidden" name="user_number" value="${users.Number}">
	                    </div>
	                     <c:if test="${not empty error}">
	                    	<p style="color:red;">${error}</p>
	                	</c:if>
	                </div>
	             <div class="d-flex flex-column justify-content-center align-items-center" style="gap: 30px;">
                    <a class="btn btn-primary btn-lg " style="padding-top: 10px; padding-bottom: 10px;">削除</a>
                    <a class="btn btn-primary btn-lg " style="padding-top: 10px; padding-bottom: 10px;">戻る</a>
                </div>
            </form>
        </div>    
	</c:param>
</c:import>