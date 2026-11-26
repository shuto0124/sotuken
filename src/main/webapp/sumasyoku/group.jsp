<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>グループ画面</title>
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

        h2 {
            display: none;
        }

        .screen-container > p {
            margin: 0 0 14px;
            padding: 10px 12px;
            border-radius: 10px;
            background-color: var(--cafeteria-danger-bg);
            color: var(--cafeteria-danger);
            border: 1.5px solid var(--cafeteria-danger-border);
            font-size: 0.92rem;
            font-weight: 700;
        }

        .top-action {
            display: flex;
            justify-content: center;
            align-items: stretch;
            gap: 10px;
            margin-bottom: 16px;
        }

        .group-id-input {
            padding: 10px 12px;
            flex: 1;
            min-width: 0;
            border: 1.5px solid #d8cab6;
            background-color: #ffffff;
            color: var(--cafeteria-ink);
            border-radius: 10px;
            font-size: 0.98rem;
            font-weight: 700;
            font-family: inherit;
            box-sizing: border-box;
        }

        .group-id-input:focus {
            outline: none;
            border-color: var(--cafeteria-primary);
            box-shadow: 0 0 0 3px rgba(217, 107, 39, 0.16);
        }

        .btn-join {
            padding: 10px 18px;
            background-color: var(--cafeteria-primary);
            color: #ffffff;
            border: 2px solid var(--cafeteria-primary);
            border-bottom-width: 4px;
            border-bottom-color: #9e430c;
            cursor: pointer;
            border-radius: 12px;
            font-size: 0.98rem;
            font-weight: 700;
            white-space: nowrap;
            box-shadow: 0 2px 6px rgba(43, 36, 29, 0.08);
            transition: transform 0.12s ease, box-shadow 0.12s ease, background-color 0.15s ease;
        }

        .btn-join:hover {
            background-color: var(--cafeteria-primary-hover);
            transform: translateY(-1px);
            box-shadow: 0 5px 12px rgba(43, 36, 29, 0.12);
        }

        .btn-join:active {
            transform: translateY(1px);
        }

        .info-box {
            border: 1.5px solid #e7c697;
            background-color: var(--cafeteria-secondary);
            color: var(--cafeteria-ink);
            border-radius: 12px;
            padding: 11px 14px;
            margin-bottom: 14px;
            font-weight: 800;
            font-size: 1rem;
            letter-spacing: 0.04em;
        }

        .member-list {
            display: flex;
            flex-direction: column;
            gap: 8px;
            margin-bottom: 20px;
        }

        .member-item {
            border: 1px solid var(--cafeteria-border);
            border-radius: 10px;
            padding: 10px 14px;
            background-color: #ffffff;
            color: var(--cafeteria-ink);
            font-size: 0.98rem;
            font-weight: 700;
            min-height: 20px;
            box-shadow: 0 2px 5px rgba(43, 36, 29, 0.04);
        }

        .footer-buttons {
            display: flex;
            justify-content: space-between;
            gap: 10px;
        }

        .btn-back {
            padding: 11px 18px;
            background-color: #faf7f2;
            color: var(--cafeteria-muted);
            border: 1.5px solid #d8cab6;
            cursor: pointer;
            border-radius: 12px;
            font-size: 0.95rem;
            font-weight: 700;
            transition: transform 0.12s ease, background-color 0.15s ease, color 0.15s ease;
        }

        .btn-back:hover {
            background-color: #f1ebe1;
            color: var(--cafeteria-ink);
            transform: translateY(-1px);
        }

        .btn-back:active {
            transform: translateY(1px);
        }

        .btn-leave {
            padding: 11px 16px;
            background-color: var(--cafeteria-danger-bg);
            color: var(--cafeteria-danger);
            border: 1.5px solid var(--cafeteria-danger-border);
            cursor: pointer;
            border-radius: 12px;
            font-size: 0.95rem;
            font-weight: 700;
            transition: transform 0.12s ease, background-color 0.15s ease;
        }

        .btn-leave:hover:not(:disabled) {
            background-color: #fde6e3;
            transform: translateY(-1px);
        }

        .btn-leave:active:not(:disabled) {
            transform: translateY(1px);
        }

        .btn-leave:disabled {
            background-color: #f2ece3;
            color: #9e9182;
            border-color: #dfd3c3;
            cursor: not-allowed;
            opacity: 0.75;
            transform: none;
        }

        .btn-join:focus-visible,
        .btn-back:focus-visible,
        .btn-leave:focus-visible {
            outline: 3px solid #f2a93b;
            outline-offset: 2px;
        }

        @media (max-width: 480px) {
            .screen-container {
                padding: 16px 14px;
            }

            .footer-buttons {
                flex-direction: column-reverse;
            }

            .btn-back,
            .btn-leave {
                width: 100%;
            }
        }
    </style>
</head>
<body>

<jsp:include page="../common/userbase.jsp">
    <jsp:param name="title" value="グループ" />
    <jsp:param name="showLogout" value="false" />
</jsp:include>

<div class="screen-container">

    <h2>グループ</h2>
    
    <c:if test="${not empty error }">
      <p>${error}</p>
    </c:if>

    <!-- グループID入力と参加ボタン -->
    <form action="GroupJoin.action" method="post">
    <div class="top-action">
        <input type="text" id="groupIdInput" name="groupId" class="group-id-input" value="${user.groups.groupNumber }">
        <button type="submit" class="btn-join" >参加</button>

    </div>
    </form>

    <!-- 現在のグループID表示 -->
    <div class="info-box">

        グループID： <span id="displayGroupId">${user.groups.groupNumber}</span>

    </div>

    <!-- グループメンバー一覧 -->
    <div class="member-list" id="memberListContainer">

        <div class="member-item" id="member-1"></div>
        <div class="member-item" id="member-2"></div>
        <div class="member-item" id="member-3"></div>
        <div class="member-item" id="member-4"></div>

    </div>

    <!-- 画面下部のボタン -->
    <div class="footer-buttons">

        <button type="button" class="btn-back" onclick="location.href='Top.action'">戻る</button>

        <button type="button" id="leaveBtn" class="btn-leave" onclick="location.href='GroupOut.action'">グループから抜ける</button>

    </div>

</div>

<script>

    /**
- グループメンバーの人数を判定し、「グループから抜ける」ボタンの有効/無効を切り替える関数
     */
    function updateLeaveButtonState() {

        const memberItems = document.querySelectorAll('#memberListContainer .member-item');

        const memberCount = Array.from(memberItems)
            .filter(member => member.textContent !== '空き').length;

        const leaveBtn = document.getElementById('leaveBtn');

        // メンバー数が2人以上の時のみ押せる
        if (memberCount >= 2) {
            leaveBtn.disabled = false;
        } else {
            leaveBtn.disabled = true;
        }

    }

    // メンバーリストを更新する
	function updateMemberList(members) {
	
	    for (let i = 1; i <= 4; i++) {
	
	        const memberElement = document.getElementById('member-' + i);
	
	        if (i <= members.length) {
	
	            const member = members[i - 1];
	
	            if (member.isRepresentative) {
	                memberElement.textContent = member.userName + ' ★';
	            } else {
	                memberElement.textContent = member.userName;
	            }
	
	        } else {
	            memberElement.textContent = '空き';
	        }
	    }

        // メンバー数に応じてボタンの状態も更新
        updateLeaveButtonState();

    }

    // メンバー情報を取得する
    function loadMemberList() {

        fetch('GroupMember.action')
            .then(response => response.json())
            .then(data => {
                updateMemberList(data);
            })
            .catch(error => {
                console.error('メンバー情報の取得に失敗しました', error);
            });

    }

    window.onload = function() {

        // 最初にメンバー情報を取得
        loadMemberList();

        // 5秒ごとにメンバー情報を更新
        setInterval(loadMemberList, 5000);

    };

    // 参加
    function joinGroup() {

        const inputVal = document.getElementById('groupIdInput').value;

        if (!inputVal) {
            alert('グループIDを入力してください。');
            return;
        }

        alert('グループID: ' + inputVal + ' に参加しました。');

    }

    // グループから抜ける
    function leaveGroup() {

        if (confirm('グループから抜けますか？')) {
            alert('グループから抜けました。');
        }

    }

    // 戻る
    function goBack() {

        history.back();

    }

</script>

</body>
</html>