<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>パスワード変更画面</title>
    <style>
        .screen-container {
            max-width: 520px;
            width: 100%;
            margin: 0 auto;
            border: 1px solid var(--cafeteria-border);
            background-color: var(--cafeteria-card);
            border-radius: 16px;
            box-shadow: 0 8px 24px rgba(66, 46, 24, 0.08);
            padding: 24px 20px;
            box-sizing: border-box;
            text-align: center;
        }

        h2 {
            display: none;
        }

        .form-group {
            margin-bottom: 18px;
            text-align: left;
        }

        .form-group label {
            display: block;
            text-align: left;
            margin-bottom: 7px;
            font-weight: 800;
            font-size: 0.92rem;
            color: var(--cafeteria-ink);
        }

        .password-input {
            width: 100%;
            padding: 11px 12px;
            border: 1.5px solid #d8cab6;
            background-color: #ffffff;
            color: var(--cafeteria-ink);
            border-radius: 10px;
            box-sizing: border-box;
            font-size: 0.98rem;
            font-family: inherit;
        }

        .password-input:focus {
            outline: none;
            border-color: var(--cafeteria-primary);
            box-shadow: 0 0 0 3px rgba(217, 107, 39, 0.16);
        }

        .button-group {
            display: flex;
            justify-content: space-between;
            margin-top: 24px;
            gap: 12px;
        }

        .btn-back, .btn-submit {
            flex: 1;
            padding: 11px 16px;
            border-radius: 12px;
            cursor: pointer;
            font-size: 0.98rem;
            font-weight: 700;
            transition: transform 0.12s ease, box-shadow 0.12s ease, background-color 0.15s ease, color 0.15s ease;
        }

        .btn-back {
            background-color: #faf7f2;
            color: var(--cafeteria-muted);
            border: 1.5px solid #d8cab6;
        }

        .btn-back:hover {
            background-color: #f1ebe1;
            color: var(--cafeteria-ink);
            transform: translateY(-1px);
        }

        .btn-back:active {
            transform: translateY(1px);
        }

        .btn-submit {
            background-color: var(--cafeteria-primary);
            color: #ffffff;
            border: 2px solid var(--cafeteria-primary);
            border-bottom-width: 4px;
            border-bottom-color: #9e430c;
            box-shadow: 0 2px 6px rgba(43, 36, 29, 0.08);
        }

        .btn-submit:hover {
            background-color: var(--cafeteria-primary-hover);
            transform: translateY(-1px);
            box-shadow: 0 5px 12px rgba(43, 36, 29, 0.12);
        }

        .btn-submit:active {
            transform: translateY(1px);
        }

        .btn-back:focus-visible,
        .btn-submit:focus-visible {
            outline: 3px solid #f2a93b;
            outline-offset: 2px;
        }

        .msg-error {
            background-color: var(--cafeteria-danger-bg);
            color: var(--cafeteria-danger);
            border: 1.5px solid var(--cafeteria-danger-border);
            border-radius: 10px;
            padding: 10px 12px;
            font-size: 0.92rem;
            font-weight: 700;
            margin-bottom: 16px;
        }

        .msg-success {
            background-color: #eef7f1;
            color: #1f5938;
            border: 1.5px solid #9bd0b0;
            border-radius: 10px;
            padding: 10px 12px;
            font-size: 0.92rem;
            font-weight: 700;
            margin-bottom: 16px;
        }

        @media (max-width: 480px) {
            .screen-container {
                padding: 18px 14px;
            }

            .button-group {
                flex-direction: column-reverse;
            }
        }
    </style>
</head>
<body>

<jsp:include page="../common/userbase.jsp">
    <jsp:param name="title" value="パスワード変更" />
    <jsp:param name="showLogout" value="false" />
</jsp:include>

<div class="screen-container">
    <h2>パスワード変更</h2>

    <div id="clientErrorMsg" class="msg-error" style="display: none;"></div>

    <% if (request.getAttribute("error") != null) { %>
        <div class="msg-error"><%= request.getAttribute("error") %></div>
    <% } %>
    <% if (request.getAttribute("message") != null) { %>
        <div class="msg-success"><%= request.getAttribute("message") %></div>
    <% } %>

    <form id="passwordForm" action="PassChangeExecute.action" method="post" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="currentPassword">現在のパスワード</label>
            <input type="password" id="currentPassword" name="currentPassword" class="password-input" placeholder="現在のパスワード">
        </div>

        <div class="form-group">
            <label for="newPassword">新しいパスワード</label>
            <input type="password" id="newPassword" name="newPassword" class="password-input" placeholder="新しいパスワード">
        </div>

        <div class="form-group">
            <label for="confirmPassword">新しいパスワード（確認）</label>
            <input type="password" id="confirmPassword" name="confirmPassword" class="password-input" placeholder="新しいパスワード">
        </div>

        <div class="button-group">
            <button type="button" class="btn-back" onclick="goBack()">戻る</button>
            <button type="submit" class="btn-submit">変更</button>
        </div>
    </form>
</div>

<script>
    function showError(message) {
        const errorBox = document.getElementById('clientErrorMsg');
        errorBox.textContent = message;
        errorBox.style.display = 'block';
    }

    function hideError() {
        const errorBox = document.getElementById('clientErrorMsg');
        errorBox.textContent = '';
        errorBox.style.display = 'none';
    }

    function validateForm() {
        hideError();

        const currentPassword = document.getElementById('currentPassword').value;
        const newPassword = document.getElementById('newPassword').value;
        const confirmPassword = document.getElementById('confirmPassword').value;

        if (!currentPassword || !newPassword || !confirmPassword) {
            showError('すべての項目を入力してください。');
            return false;
        }

        if (newPassword !== confirmPassword) {
            showError('新しいパスワードと確認用パスワードが一致しません。');
            return false;
        }

        return confirm('パスワードを変更しますか？');
    }

    function goBack() {
        history.back();
    }
</script>

</body>
</html>