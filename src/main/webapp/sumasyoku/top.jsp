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
  }

  .card-header {
    max-width: 520px;
    margin: 0 auto 14px;
    background: linear-gradient(135deg, #e07a2d 0%, #c85a17 100%);
    color: #ffffff;
    border-radius: 16px 16px 6px 6px;
    box-shadow: 0 4px 12px rgba(92, 48, 16, 0.14);
    border-bottom: 4px solid #f2b84b;
    padding: 14px 18px;
    box-sizing: border-box;
  }

  .top-header-bar {
    display: flex;
    align-items: center;
    justify-content: space-between;
    gap: 12px;
  }

  .header-left {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    gap: 4px;
    min-width: 0;
  }

  .card-header h1 {
    margin: 0;
    font-size: 1.55rem;
    font-weight: 800;
    letter-spacing: 0.08em;
    line-height: 1.2;
  }

  .user-badge {
    display: inline-flex;
    align-items: center;
    gap: 6px;
    background-color: rgba(255, 253, 249, 0.22);
    border: 1px solid rgba(255, 255, 255, 0.4);
    color: #ffffff;
    font-size: 0.85rem;
    font-weight: 700;
    padding: 3px 10px;
    border-radius: 999px;
    max-width: 100%;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }

  .top-logout-form {
    margin: 0;
    flex-shrink: 0;
  }

  .btn-top-logout {
    background-color: var(--cafeteria-danger-bg);
    color: var(--cafeteria-danger);
    border: 1.5px solid var(--cafeteria-danger-border);
    border-radius: 10px;
    padding: 8px 14px;
    font-size: 0.88rem;
    font-weight: 700;
    cursor: pointer;
    white-space: nowrap;
    box-shadow: 0 2px 6px rgba(43, 36, 29, 0.14);
    transition: transform 0.12s ease, background-color 0.15s ease;
  }

  .btn-top-logout:hover {
    background-color: #fde6e3;
    transform: translateY(-1px);
  }

  .btn-top-logout:active {
    transform: translateY(1px);
  }

  .card-body {
    max-width: 520px;
    margin: 0 auto;
    background-color: var(--cafeteria-card) !important;
    border: 1px solid var(--cafeteria-border);
    border-radius: 16px;
    box-shadow: 0 8px 24px rgba(66, 46, 24, 0.08);
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    gap: 12px;
    box-sizing: border-box;
  }

  .card-body > .text-center {
    display: flex;
    align-items: stretch;
  }

  /* メニュー・予約・グループ・予約状況確認（メイン操作） */
  .card-body > .text-center:nth-child(-n+4) button {
    background-color: var(--cafeteria-secondary);
    color: var(--cafeteria-ink);
    border: 2px solid #e7c697;
    border-bottom-width: 4px;
  }

  .card-body > .text-center:nth-child(1) button {
    background-color: var(--cafeteria-primary);
    color: #ffffff;
    border-color: var(--cafeteria-primary);
    border-bottom-color: #9e430c;
  }

  .card-body > .text-center:nth-child(1) button:hover {
    background-color: var(--cafeteria-primary-hover);
  }

  .card-body > .text-center:nth-child(2) button {
    background-color: #eef7f1;
    color: #1f5938;
    border-color: #9bd0b0;
    border-bottom-color: var(--cafeteria-accent);
  }

  .card-body > .text-center:nth-child(2) button:hover {
    background-color: #dcf0e4;
  }

  .card-body > .text-center:nth-child(n+2):nth-child(-n+4) button:hover {
    background-color: var(--cafeteria-secondary-hover);
  }

  /* パスワードの変更を下の行で横幅いっぱいに配置 */
  .card-body > .text-center:nth-child(5) {
    grid-column: span 2;
  }

  .card-body > .text-center:nth-child(5) button {
    background-color: #faf7f2;
    color: var(--cafeteria-muted);
    border: 1.5px solid #d8cab6;
    font-size: 0.95rem;
    min-height: 50px;
  }

  .card-body > .text-center:nth-child(5) button:hover {
    background-color: #f1ebe1;
    color: var(--cafeteria-ink);
  }

  .card-body button {
    width: 100%;
    min-height: 64px;
    padding: 12px 14px;
    border-radius: 12px;
    font-size: 1.05rem;
    font-weight: 700;
    line-height: 1.3;
    cursor: pointer;
    transition: transform 0.12s ease, box-shadow 0.12s ease, background-color 0.15s ease;
    box-shadow: 0 2px 6px rgba(43, 36, 29, 0.06);
  }

  .card-body button:hover {
    transform: translateY(-2px);
    box-shadow: 0 5px 12px rgba(43, 36, 29, 0.1);
  }

  .card-body button:active {
    transform: translateY(1px);
  }

  .card-body button:focus-visible,
  .btn-top-logout:focus-visible {
    outline: 3px solid #f2a93b;
    outline-offset: 2px;
  }

  @media (max-width: 480px) {
    .card-body {
      grid-template-columns: 1fr;
      padding: 16px !important;
      gap: 10px;
    }

    .card-body > .text-center:nth-child(5) {
      grid-column: span 1;
    }

    .card-body button {
      min-height: 56px;
      font-size: 1rem;
    }
  }
</style>

<!-- No1: 画面タイトル -->
<div class="card-header text-center py-3"">
<h1>トップ</h1>
</div>

<div class="card-body p-4 bg-white">
	<div class="text-center">
	<button type="button" onclick="location.href='Menu.action'">メニュー</button>
    </div>
    <div class="text-center">
    <button type="button" onclick="location.href='ReserveTypeSelect.action'">予約</button>
    </div>
    <div class="text-center">
    <button type="button" onclick="location.href='Group.action'">グループ</button>
    </div>
    <div class="text-center">
    <button type="button" onclick="location.href='reserveConfi.jsp'">予約状況確認</button>
    </div>
    <div class="text-center">                        
    <button type="button" onclick="location.href='PassChange.action'">パスワードの変更</button>
    </div>
    <div class="text-center">                        
    	<form action="LogoutExecute.action" method="post" onsubmit="return confirm('ログアウトしますか');">
    		<button type="submit">ログアウト</button>
    	</form>   
    </div>

</div>

         

<%
    String flashMessage = (String) session.getAttribute("flashMessage");
    if (flashMessage != null) {
        session.removeAttribute("flashMessage");
%>
<script>
    window.addEventListener('DOMContentLoaded', function() {
        alert("<%= flashMessage %>");
    });
</script>
<%
    }
%>
