<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />">
<style>
body.bg-light {
    background-color: #ffffff !important;
}

.header-box {
    background-color: #e9f7ff !important;
}

header {
    box-shadow: none !important;
    margin-bottom: 0 !important;
    border-bottom: none !important;
}

header span,
header a {
    display: none !important;
}

#sidebar {
    display: none !important;
}


#main {
    margin-left: 0 !important;
}


.login-box {
    width: 620px;
    margin: 60px auto 40px;
    border: 1px solid #ccc;
    border-radius: 0;
    overflow: hidden;
}

.login-title {
    background: #eee;
    text-align: center;
    font-weight: bold;
    padding: 15px;
    font-size: 25px;
}

.login-box form {
    background: #fff;
    padding: 35px 40px;
    border-radius: 8px;
}

.input-group {
    position: relative;
    margin-bottom: 10px;
}

.input-label {
    position: absolute;
    top: 5px;
    left: 10px;
    font-size: 11px;
    color: #666;
}

.login-box input[type="text"],
.login-box input[type="password"] {
    width: 100%;
    margin: 0 auto;
    display: block;
    padding: 14px 12px;
    box-sizing: border-box;
    border: none;
    border-radius: 6px;
    background-color: #e9f7ff;
}

.checkbox-area {
    text-align: center;
}

.login-box input[type="submit"] {
    display: block;
    margin: 10px auto 5px;
    padding: 8px 35px;
    background-color: #0d6efd;
    color: white;
    border: none;
    border-radius: 6px;
}

.login-error {
    color: #000;
    font-size: 14px;
    margin-bottom: 10px;
    text-align: center;
    white-space: nowrap;
}

main{
    display: flex;
    justify-content: center;  
    align-items: center;       
    min-height: 70vh;    
}


</style>
<header class="bg-white shadow-sm py-4 mb-4">
       <div class="header-box d-flex justify-content-between align-items-center">
        <h1 class="page-title m-0">すましょくてすと</h1>
        </div>
</header>

<div class="login-box">
    <div class="login-title">ログイン</div>

    <form action="<c:url value='/sumasyoku/LoginExecute.action' />" method="post">

        <c:if test="${not empty msg}">
            <p class="login-error">
                ${msg}
            </p>
        </c:if>

        <div class="input-group">
            <span class="input-label">個人番号</span>
            <input type="text" name="userNumber" value="${param.userNumber}" required>
        </div>

        <div class="input-group">
            <span class="input-label">パスワード</span>
            <input type="password" name="password" id="password" required>
        </div>

        <p class="checkbox-area">
            <input type="checkbox" id="showPass"> パスワードを表示
        </p>

        <p>
            <input type="submit" value="ログイン">
        </p>

    </form>
</div>

<footer class="text-center py-3 mt-5" style="background-color:#e9ecef; width:100%;">
    © 2023 TIC<br>
    大原学園
</footer>
<script>
document.getElementById("showPass").addEventListener("change", function() {
    const pass = document.getElementById("password");
    pass.type = this.checked ? "text" : "password";
});
</script>