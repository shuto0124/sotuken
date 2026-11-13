<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>パスワード変更画面</title>
    <style>
        /* 画面全体のレイアウト調整 */
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
    </style>
</head>
<body>

<div class="screen-container">
    <h2>パスワード変更</h2>

    <form id="passwordForm" onsubmit="return validateForm()">
        <!-- 現在のパスワード -->
        <div class="form-group">
            <label for="currentPassword">現在のパスワード</label>
            <input type="password" id="currentPassword" name="currentPassword" class="password-input" placeholder="現在のパスワード">
        </div>

        <!-- 新しいパスワード -->
        <div class="form-group">
            <label for="newPassword">新しいパスワード</label>
            <input type="password" id="newPassword" name="newPassword" class="password-input" placeholder="新しいパスワード">
        </div>

        <!-- 新しいパスワード（確認） -->
        <div class="form-group">
            <label for="confirmPassword">新しいパスワード（確認）</label>
            <input type="password" id="confirmPassword" name="confirmPassword" class="password-input" placeholder="新しいパスワード">
        </div>

        <!-- 画面下部のボタン -->
        <div class="button-group">
            <button type="button" class="btn-back" onclick="goBack()">戻る</button>
            <button type="submit" class="btn-submit">変更</button>
        </div>
    </form>
</div>

<script>
    /**
     * 変更ボタン押下時のJavaScriptバリデーションチェック
     */
    function validateForm() {
        const currentPassword = document.getElementById('currentPassword').value;
        const newPassword = document.getElementById('newPassword').value;
        const confirmPassword = document.getElementById('confirmPassword').value;

        // 1. 空欄チェック
        if (!currentPassword || !newPassword || !confirmPassword) {
            alert('すべての項目を入力してください。');
            return false;
        }

        // 2. 新しいパスワードと確認用の一致チェック
        if (newPassword !== confirmPassword) {
            alert('新しいパスワードと確認用パスワードが一致しません。');
            return false;
        }

        // 3. パスワードの文字数チェック（例として8文字以上）
        if (newPassword.length < 8) {
            alert('新しいパスワードは8文字以上で入力してください。');
            return false;
        }

        // 4. 確認ダイアログ
        return confirm('パスワードを変更しますか？');
    }

    /**
     * 戻る
     */
    function goBack() {
        history.back();
    }
</script>

</body>
</html>