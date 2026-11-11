<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:import url="/common/base.jsp">
    <c:param name="title" value="学食システム - ログイン" />

    <c:param name="scripts">
        <script>
            // パスワード表示切り替え
            $(document).on("change", "#chk_d_ps", function() {
                const pass = document.getElementById("password");
                pass.type = this.checked ? "text" : "password";
            });
        </script>
    </c:param>

    <c:param name="content">
    <div class="d-flex justify-content-center align-items-center" style="min-height: 70vh;"> 
        <div class="card shadow-sm mx-auto" style="max-width: 500px; height:400px; background-color: #f8f9fa;">
            <!-- No1: 画面タイトル -->
            <div class="card-header text-center py-3" style="background-color: #f0f0f0;">
                <h2 class="h5 mb-0">ログイン（管理者）</h2>
            </div>

            <div class="card-body p-4 bg-white">

                <!-- エラー表示 -->
                <c:if test="${not empty errors}">
                    <div class="alert py-2 px-3 mb-4" style="border-radius: 0;">
                        <ul class="mb-0" style="list-style-type: disc; padding-left: 1.5rem;">
                            <c:forEach var="error" items="${errors}">
                                <li class="small"><c:out value="${error}" /></li>
                            </c:forEach>
                        </ul>
                    </div>
                </c:if>

                <form action="Loginexecute.action" method="post" class="mx-auto" style="width: 300px;">

                    <!-- No2: ログインID -->
                    <div class="mb-3 position-relative">
                        <span class="position-absolute"
                              style="left: 15px; top: 20%; transform: translateY(-50%);
                                     color: #6c757d; pointer-events: none;">
                            個人番号
                        </span>
                        <input type="text" name="user_number" id="users_number" class="form-control ps-5"
                               style="height: 60px; line-height: 60px;"
                               maxlength="10" inputmode="latin"
                               value="<c:out value='${id}' />"
                               required placeholder="半角でご入力ください">
                    </div>

                    <!-- No3: パスワード -->
                    <div class="mb-3 position-relative">
                        <span class="position-absolute"
                              style="left: 15px; top: 20%; transform: translateY(-50%);
                                     color: #6c757d; pointer-events: none;">
                            パスワード
                        </span>
                        <input type="password" id="password" name="password" class="form-control ps-5"
                               style="height: 60px; line-height: 60px;"
                               maxlength="30" inputmode="latin"
                               required placeholder="10文字以内でご入力ください">
                    </div>

                    <!-- No4 & No5: パスワード表示チェック -->
                    <div class="mb-4 text-center">
                        <div class="form-check d-inline-block">
                            <input type="checkbox" class="form-check-input" id="chk_d_ps">
                            <label class="form-check-label small" for="chk_d_ps">パスワードを表示</label>
                        </div>
                    </div>

                    <!-- No6: ログインボタン -->
                    <div class="text-center">
                        <input type="submit" id="login" value="ログイン" class="btn btn-primary px-5">
                    </div>

                </form>
            </div>
        </div>
       </div>
    </c:param>
</c:import>