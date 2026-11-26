<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String headerTitle = request.getParameter("title");
    if (headerTitle == null || headerTitle.isEmpty()) {
        headerTitle = "トップ";
    }

    String showLogoutParam = request.getParameter("showLogout");
    boolean showLogout = !"false".equalsIgnoreCase(showLogoutParam);
%>

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
    min-height: 68px;
  }

  .top-header-bar {
    display: flex;
    align-items: center;
    justify-content: center;
    position: relative;
    height: 100%;
  }

  .card-header h1 {
    margin: 0;
    font-size: 1.55rem;
    font-weight: 800;
    letter-spacing: 0.08em;
    line-height: 1.2;
  }

  .has-logout h1 {
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
  }

  .has-logout .top-header-bar {
    justify-content: space-between;
  }

  .top-logout-form {
    margin: 0;
    flex-shrink: 0;
    position: absolute;
    right: 18px;
    top: 50%;
    transform: translateY(-50%);
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
    transform: translateY(-1px) translateX(-50%);
  }

  .has-logout .btn-top-logout:hover {
    transform: translateY(-1px);
  }

  .btn-top-logout:active {
    transform: translateY(1px);
  }

  .btn-top-logout:focus-visible {
    outline: 3px solid #f2a93b;
    outline-offset: 2px;
  }
</style>

<div class="card-header <%= showLogout ? "has-logout" : "" %>">
  <div class="top-header-bar">
    <h1><%= headerTitle %></h1>
    <% if (showLogout) { %>
      <form action="LogoutExecute.action" method="post" class="top-logout-form" onsubmit="return confirm('ログアウトしますか');">
        <button type="submit" class="btn-top-logout">ログアウト</button>
      </form>
    <% } %>
  </div>
</div>