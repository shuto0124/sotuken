<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品予約</title>
<style>
  .screen-container {
    max-width: 520px;
    width: 100%;
    margin: 0 auto;
    border: 1px solid var(--cafeteria-border);
    background-color: var(--cafeteria-card);
    border-radius: 16px;
    box-shadow: 0 8px 24px rgba(66, 46, 24, 0.08);
    padding: 20px 18px;
    box-sizing: border-box;
    text-align: center;
  }

  .msg-empty {
    margin: 0 0 14px;
    padding: 12px 14px;
    border-radius: 12px;
    background-color: var(--cafeteria-secondary);
    color: var(--cafeteria-ink);
    border: 1.5px solid #e7c697;
    font-size: 0.95rem;
    font-weight: 700;
  }

  .msg-info {
    margin: 0 0 14px;
    padding: 11px 14px;
    border-radius: 12px;
    background-color: #eef7f1;
    color: #1f5938;
    border: 1.5px solid #9bd0b0;
    font-size: 0.94rem;
    font-weight: 700;
    box-shadow: 0 4px 12px rgba(47, 122, 79, 0.08);
  }

  /* 4種類ずつ（2列×2行）表示し、超えた分は縦スクロール（スワイプ）で閲覧 */
  .product-grid-scroll {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    gap: 12px;
    max-height: 452px;
    overflow-y: auto;
    -webkit-overflow-scrolling: touch;
    padding: 4px;
    margin-bottom: 20px;
    box-sizing: border-box;
  }

  .product-form {
    margin: 0;
    display: flex;
  }

  .product-card-btn {
    width: 100%;
    min-height: 214px;
    padding: 12px 10px;
    background-color: var(--cafeteria-secondary);
    color: var(--cafeteria-ink);
    border: 2px solid #e7c697;
    border-bottom-width: 4px;
    border-radius: 14px;
    cursor: pointer;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 6px;
    box-shadow: 0 2px 6px rgba(43, 36, 29, 0.06);
    transition: transform 0.12s ease, box-shadow 0.12s ease, background-color 0.15s ease;
    box-sizing: border-box;
    font-family: inherit;
  }

  .product-card-btn:hover {
    background-color: var(--cafeteria-secondary-hover);
    transform: translateY(-2px);
    box-shadow: 0 5px 12px rgba(43, 36, 29, 0.1);
  }

  .product-card-btn:active {
    transform: translateY(1px);
  }

  .product-img {
    width: 80px;
    height: 80px;
    object-fit: cover;
    border-radius: 10px;
    border: 1px solid var(--cafeteria-border);
    background-color: #ffffff;
  }

  .product-name {
    font-size: 0.96rem;
    font-weight: 800;
    line-height: 1.3;
    color: var(--cafeteria-ink);
  }

  .product-price {
    font-size: 0.95rem;
    font-weight: 700;
    color: var(--cafeteria-primary);
  }

  .product-stock {
    font-size: 0.85rem;
    font-weight: 700;
    color: var(--cafeteria-muted);
  }

  .footer-actions {
    display: flex;
    justify-content: space-between;
    gap: 12px;
    position: sticky;
    bottom: 0;
    background-color: var(--cafeteria-card);
    padding-top: 10px;
    padding-bottom: 4px;
    z-index: 10;
  }

  .footer-actions > form {
    flex: 1;
    margin: 0;
  }

  .btn-back,
  .btn-order {
    width: 100%;
    min-height: 52px;
    padding: 11px 16px;
    border-radius: 12px;
    font-size: 1rem;
    font-weight: 700;
    cursor: pointer;
    transition: transform 0.12s ease, box-shadow 0.12s ease, background-color 0.15s ease, color 0.15s ease;
    box-sizing: border-box;
    font-family: inherit;
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

  .btn-order {
    background-color: var(--cafeteria-primary);
    color: #ffffff;
    border: 2px solid var(--cafeteria-primary);
    border-bottom-width: 4px;
    border-bottom-color: #9e430c;
    box-shadow: 0 2px 6px rgba(43, 36, 29, 0.08);
  }

  .btn-order:hover {
    background-color: var(--cafeteria-primary-hover);
    transform: translateY(-1px);
    box-shadow: 0 5px 12px rgba(43, 36, 29, 0.12);
  }

  .btn-order:active {
    transform: translateY(1px);
  }

  .product-card-btn:focus-visible,
  .btn-back:focus-visible,
  .btn-order:focus-visible {
    outline: 3px solid #f2a93b;
    outline-offset: 2px;
  }

  @media (max-width: 480px) {
    .screen-container {
      padding: 16px 14px;
    }

    .product-grid-scroll {
      gap: 10px;
      max-height: 436px;
    }

    .product-card-btn {
      min-height: 206px;
    }

    .footer-actions {
      flex-direction: column-reverse;
    }
  }
</style>
</head>

<body>

<jsp:include page="../common/userbase.jsp">
    <jsp:param name="title" value="${backPage != 'menu' ? '商品予約' : '商品一覧'}" />
    <jsp:param name="showLogout" value="false" />
    <jsp:param name="showCart" value="true" />
    <jsp:param name="backPage" value="${backPage}" />
</jsp:include>

<div class="screen-container">

  <c:if test="${empty product}">
    <p class="msg-empty">商品がありません。</p>
  </c:if>

  <c:if test="${not empty message}">
    <div class="msg-info">${message}</div>
  </c:if>

  <div class="product-grid-scroll">
    <c:forEach var="product" items="${product}">
      <form action="ProductDetail.action" class="product-form">
        <input type="hidden" name="product_number" value="${product.productNumber}">
        <input type="hidden" name="backPage" value="${backPage}">

        <button type="submit" class="product-card-btn">
          <img alt="${product.productName}" src="/スマ食/images/${product.productImage}" class="product-img">
          <span class="product-name">${product.productName}</span>
          <span class="product-price">${product.productPrice}円</span>
          <span class="product-stock">${product.productStock}個</span>
        </button>
      </form>
    </c:forEach>
  </div>

  <div class="footer-actions">
    <c:choose>
      <c:when test="${backPage == 'seat'}">
        <form action="SeatSelect.action" method="get">
          <button type="submit" class="btn-back">戻る</button>
        </form>
      </c:when>

      <c:when test="${backPage == 'reservation'}">
        <form action="ReserveTypeSelect.action" method="get">
          <button type="submit" class="btn-back">戻る</button>
        </form>
      </c:when>

      <c:when test="${backPage == 'menu'}">
        <form action="Top.action" method="get">
          <button type="submit" class="btn-back">戻る</button>
        </form>
      </c:when>
    </c:choose>

    
    <c:if test="${backPage != 'menu'}">
      <form action="reservation.jsp">
          <button type="submit" class="btn-order">
              注文
          </button>
      </form>
    </c:if>
    
  </div>

</div>

</body>
</html>
