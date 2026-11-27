<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
:root {
--cafeteria-bg: #f6f1e7;
--cafeteria-card: #fffdf9;
--cafeteria-ink: #2b241d;
--cafeteria-muted: #6e6255;
--cafeteria-border: #e5d8c3;
--cafeteria-primary: #d96b27;
--cafeteria-primary-hover: #be5819;
--cafeteria-secondary: #fff6e8;
--cafeteria-secondary-hover: #fbe8cb;
--cafeteria-accent: #2f7a4f;
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
padding: 18px 20px !important;
box-sizing: border-box;
}

.card-header h1 {
margin: 0;
font-size: 1.7rem;
font-weight: 800;
letter-spacing: 0.1em;
line-height: 1.2;
}

.entry-card {
max-width: 480px;
margin: 0 auto;
padding: 24px 20px;
background-color: var(--cafeteria-card);
border: 1px solid var(--cafeteria-border);
border-radius: 16px;
box-shadow: 0 8px 24px rgba(66, 46, 24, 0.08);
display: flex;
flex-direction: column;
gap: 14px;
box-sizing: border-box;
}

.entry-card button {
width: 100%;
min-height: 58px;
padding: 14px 16px;
border-radius: 12px;
font-size: 1.08rem;
font-weight: 700;
line-height: 1.3;
cursor: pointer;
transition: transform 0.12s ease, box-shadow 0.12s ease, background-color 0.15s ease;
box-shadow: 0 2px 6px rgba(43, 36, 29, 0.06);
}

.entry-card button:hover {
transform: translateY(-2px);
box-shadow: 0 5px 12px rgba(43, 36, 29, 0.1);
}

.entry-card button:active {
transform: translateY(1px);
}

.entry-card button:focus-visible {
outline: 3px solid #f2a93b;
outline-offset: 2px;
}

.btn-login {
background-color: var(--cafeteria-accent);
color: #ffffff;
border: 2px solid var(--cafeteria-accent);
border-bottom-width: 4px;
border-bottom-color: #1f5938;
}

.btn-login:hover {
background-color: #256440;
}

.btn-register {
background-color: #f3f1ed;
color: #4f4a44;
border: 2px solid #cfc9c0;
border-bottom-width: 4px;
border-bottom-color: #b5aea4;
}

.btn-register:hover {
background-color: #e7e3dc;
color: var(--cafeteria-ink);
}

@media (max-width: 480px) {
.entry-card {
padding: 18px 16px;
gap: 12px;
}

.entry-card button {
min-height: 54px;
font-size: 1rem;
}
}
</style>

<div class="card-header text-center py-3" style="background-color: #f0f0f0;">
<h1>がくちる</h1>
</div>

<div class="entry-card">
<div class="text-center">
<button type="button" class="btn-login" onclick="location.href='Login.action'">ログイン</button>
</div>

<div class="text-center">
<button type="button" class="btn-register" onclick="location.href='Register.action'">初回登録</button>
</div>
</div>