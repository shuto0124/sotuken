<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>パスワード変更画面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .screen-container {
            width: 380px;
            border: 2px solid #333;
            background-color: #fff;
            padding: 30px 20px;
            box-sizing: border-box;
            text-align: center;
        }
        h2 {
            margin-top: 0;
            margin-bottom: 25px;
            font-size: 22px;
        }
        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }
        .form-group label {
            display: block;
            text-align: center;
            margin-bottom: 8px;
            font-weight: bold;
            font-size: 14px;
        }
        .password-input {
            width: 100%;
            padding: 10px;
            border: 1px solid #78909c;
            background-color: #e3f2fd;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
        }
        .button-group {
            display: flex;
            justify-content: space-between;
            margin-top: 30px;
            gap: 15px;
        }
        .btn-back, .btn-submit {
            flex: 1;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            font-weight: bold;
            background-color: #fffde7;
            border: 1px solid #fbc02d;
        }
        .btn-back:hover, .btn-submit:hover {
            background-color: #fff9c4;
        }
        .msg-error {
            color: #d32f2f;
            font-size: 13px;
            font-weight: bold;
            margin-bottom: 15px;
        }
        .msg-success {
            color: #2e7d32;
            font-size: 13px;
            font-weight: bold;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<div class="screen-container">
    <h2>パスワード変更</h2>

    <% if (request.getAttribute("error") != null) { %>
        <div class="msg-error"><%= request.getAttribute("error") %></div>
    <% } %>
    <% if (request.getAttribute("message") != null) { %>
        <div class="msg-success"><%= request.getAttribute("message") %></div>
    <% } %>

    <form id="passwordForm" action="PassChange.action" method="post" onsubmit="return validateForm()">
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
    function validateForm() {
        const currentPassword = document.getElementById('currentPassword').value;
        const newPassword = document.getElementById('newPassword').value;
        const confirmPassword = document.getElementById('confirmPassword').value;

        if (!currentPassword || !newPassword || !confirmPassword) {
            alert('すべての項目を入力してください。');
            return false;
        }

        if (newPassword !== confirmPassword) {
            alert('新しいパスワードと確認用パスワードが一致しません。');
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