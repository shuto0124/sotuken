<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<style>
:root {
--cafeteria-bg: #f6f1e7;
--cafeteria-card: #fffdf9;
--cafeteria-ink: #2b241d;
--cafeteria-muted: #6e6255;
--cafeteria-border: #e5d8c3;
--cafeteria-primary: #d96b27;
--cafeteria-primary-hover: #be5819;
--cafeteria-danger: #b83b2a;
--cafeteria-danger-bg: #fff5f4;
--cafeteria-danger-border: #efc4be;
}

body {
background-color: var(--cafeteria-bg);
color: var(--cafeteria-ink);
font-family: "Hiragino Kaku Gothic ProN", "Yu Gothic", "Meiryo", sans-serif;
margin: 0;
padding: 20px 14px;
box-sizing: border-box;
}

.card-header {
max-width: 480px;
margin: 0 auto 14px;
background: linear-gradient(135deg, #e07a2d 0%, #c85a17 100%) !important;
color: #ffffff;
border-radius: 16px 16px 6px 6px;
box-shadow: 0 4px 12px rgba(92, 48, 16, 0.14);
border-bottom: 4px solid #f2b84b;
padding: 16px 20px !important;
box-sizing: border-box;
}

.card-header h1 {
margin: 0;
font-size: 1.6rem;
font-weight: 800;
letter-spacing: 0.08em;
line-height: 1.2;
}

.register-card {
max-width: 480px;
margin: 0 auto;
padding: 24px 20px;
background-color: var(--cafeteria-card);
border: 1px solid var(--cafeteria-border);
border-radius: 16px;
box-shadow: 0 8px 24px rgba(66, 46, 24, 0.08);
box-sizing: border-box;
}

.register-card form {
margin: 0;
}

.register-error {
margin: 0 0 16px;
padding: 11px 14px;
border-radius: 12px;
background-color: var(--cafeteria-danger-bg);
color: var(--cafeteria-danger);
border: 1.5px solid var(--cafeteria-danger-border);
font-size: 0.92rem;
font-weight: 700;
text-align: center;
line-height: 1.4;
}

.form-group {
margin-bottom: 18px;
}

.form-label {
display: block;
margin-bottom: 6px;
font-size: 0.95rem;
font-weight: 700;
color: var(--cafeteria-ink);
}

.form-input {
width: 100%;
padding: 12px 14px;
font-size: 1rem;
color: var(--cafeteria-ink);
background-color: #ffffff;
border: 1.5px solid #d8cab6;
border-radius: 10px;
box-sizing: border-box;
font-family: inherit;
transition: border-color 0.15s ease, box-shadow 0.15s ease;
}

.form-input::placeholder {
color: #9e9183;
font-size: 0.9rem;
}

.form-input:focus {
outline: none;
border-color: var(--cafeteria-primary);
box-shadow: 0 0 0 3px rgba(217, 107, 39, 0.18);
}

.button-stack {
display: flex;
flex-direction: column;
gap: 12px;
margin-top: 22px;
}

.btn-submit,
.btn-back {
width: 100%;
min-height: 54px;
padding: 12px 16px;
border-radius: 12px;
font-size: 1.05rem;
font-weight: 700;
line-height: 1.3;
cursor: pointer;
transition: transform 0.12s ease, box-shadow 0.12s ease, background-color 0.15s ease;
box-shadow: 0 2px 6px rgba(43, 36, 29, 0.06);
box-sizing: border-box;
font-family: inherit;
}

.btn-submit:hover,
.btn-back:hover {
transform: translateY(-2px);
box-shadow: 0 5px 12px rgba(43, 36, 29, 0.1);
}

.btn-submit:active,
.btn-back:active {
transform: translateY(1px);
}

.btn-submit:focus-visible,
.btn-back:focus-visible {
outline: 3px solid #f2a93b;
outline-offset: 2px;
}

.btn-submit {
background-color: var(--cafeteria-primary);
color: #ffffff;
border: 2px solid var(--cafeteria-primary);
border-bottom-width: 4px;
border-bottom-color: #9e430c;
}

.btn-submit:hover {
background-color: var(--cafeteria-primary-hover);
}

.btn-back {
background-color: #f3f1ed;
color: #4f4a44;
border: 2px solid #cfc9c0;
border-bottom-width: 4px;
border-bottom-color: #b5aea4;
}

.btn-back:hover {
background-color: #e7e3dc;
color: var(--cafeteria-ink);
}

@media (max-width: 480px) {
.register-card {
padding: 20px 16px;
}

.btn-submit,
.btn-back {
min-height: 50px;
font-size: 1rem;
}
}
</style>

<div class="card-header text-center py-3" style="background-color: #f0f0f0;">
<h1>初回登録</h1>
</div>

<div class="register-card">
<form action="RegisterExecute.action" method="post">
<!-- エラーメッセージ -->
<c:if test="${not empty msg}">
<p class="register-error">${msg}</p>
</c:if>

<!-- No1: ログインID -->
<div class="mb-3 position-relative form-group">
<label class="form-label" for="userNumber">個人番号</label>
<input type="text" id="userNumber" class="form-input" name="userNumber" required placeholder="半角でご入力ください">
</div>

<!-- No2: パスワード -->
<div class="mb-3 position-relative form-group">
<label class="form-label" for="password">パスワード</label>
<input type="password" id="password" class="form-input" name="password" required placeholder="30文字以内の半角英数字でご入力ください">
</div>

<!-- No3: 登録ボタン -->
<div class="button-stack">
<div class="text-center">
<button type="submit" class="btn-submit">登録する</button>
</div>
<div class="text-center">
<button type="button" class="btn-back" onclick="location.href='Start.action'">戻る</button>
</div>
</div>
</form>
</div>