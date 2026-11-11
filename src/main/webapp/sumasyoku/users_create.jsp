<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
 
<c:import url="/common/base.jsp">
    <c:param name="title">学食システム</c:param>
    <c:param name="scripts"></c:param>
 
    <c:param name="content">
        <section >
 
            <style>
            
				.custom-dark-gray {
				    background-color: #6c757d; /* 画像に近い明るいグレーに変更 */
				    border-color: #6c757d;     /* 枠線も同色に */
				    color: white;              /* 文字色は白 */
				}
				
				.custom-dark-gray:hover {
				    background-color: #6c757d; /* マウスを乗せたときは少し暗く */
				    border-color: #6c757d;
				    color: white;
				}
            
                /* ラベルを縦並びに */
                form label {
                    display: block;
                    margin-top: 20px;
                    font-weight: bold;
                    font-size: 25px;
                }
 
                /* 入力欄をラベルの下に配置 */
                form input,
                form select {
                    display: block;
                    width: 250px;
                    padding: 6px;
                    margin-top: 5px;
                }
 
 
            </style>
 
            <form method="post" action="StudentCreateExecute.action" class="mx-auto" style="width: 300px;">
 
                <label class="text-center">個人番号</label>
                <input type="text" class="form-control" id="user_number" name="user_number" value="${users.user_number}"
                       placeholder="個人番号を入力してください" required>
 
                <script>
                    document.getElementById("user_number").addEventListener("input", function () {
                        if (this.value.length > 10) {
                            this.value = this.value.slice(0, 10);
                        }
                    });
                </script>
 
				<c:if test="${not empty errors}">
				    <ul style="color:orange;">
				        <c:forEach var="e" items="${errors}">
				            <p>${e}</p>
				        </c:forEach>
				    </ul>
				</c:if>
 

                <label class="text-center ">氏名</label>
                <input type="text" class="form-control" name="user_name" value="${users.userName }"
                       maxlength="30" placeholder="氏名を入力してください" required>

                <div class="d-flex flex-column justify-content-center align-items-center" style="gap: 20px; margin-top: 30px;">
                    <a class="btn btn-primary btn-lg w-100">登録</a>
                    <a class="btn btn-primary btn-lg w-100">戻る</a>
                </div>

 
            </form>
        </section>
    </c:param>
</c:import>