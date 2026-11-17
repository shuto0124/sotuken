
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>グループ画面</title>

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
            padding: 20px;
            box-sizing: border-box;
            text-align: center;
        }

        h2 {
            margin-top: 0;
            margin-bottom: 20px;
            font-size: 24px;
        }

        .top-action {
            display: flex;
            justify-content: center;
            gap: 10px;
            margin-bottom: 15px;
        }

        .group-id-input {
            padding: 8px;
            width: 60%;
            border: 1px solid #78909c;
            background-color: #e3f2fd;
            border-radius: 4px;
        }

        .btn-join {
            padding: 8px 15px;
            background-color: #fff9c4;
            border: 1px solid #fbc02d;
            cursor: pointer;
            border-radius: 4px;
        }

        .info-box {
            border: 1px solid #333;
            padding: 10px;
            margin-bottom: 15px;
            font-weight: bold;
        }

        .member-list {
            display: flex;
            flex-direction: column;
            gap: 5px;
            margin-bottom: 20px;
        }

        .member-item {
            border: 1px solid #333;
            padding: 8px;
            background-color: #fff;
        }

        .footer-buttons {
            display: flex;
            justify-content: space-between;
        }

        .btn-back {
            padding: 8px 20px;
            background-color: #fff9c4;
            border: 1px solid #fbc02d;
            cursor: pointer;
            border-radius: 4px;
        }

        .btn-leave {
            padding: 8px 15px;
            background-color: #455a64;
            color: white;
            border: 1px solid #263238;
            cursor: pointer;
            border-radius: 4px;
        }

        /* ボタンが無効化されたときのスタイル */
        .btn-leave:disabled {
            background-color: #b0bec5;
            border-color: #90a4ae;
            cursor: not-allowed;
            opacity: 0.7;
        }

    </style>

</head>

<body>

<div class="screen-container">

    <h2>グループ</h2>

    <!-- グループID入力と参加ボタン -->
    <div class="top-action">

        <input type="text" id="groupIdInput" class="group-id-input" placeholder="グループID">

        <button type="button" class="btn-join" onclick="joinGroup()">参加</button>

    </div>

    <!-- 現在のグループID表示 -->
    <div class="info-box">

        グループID： <span id="displayGroupId">xxxx</span>

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

        <button type="button" class="btn-back" onclick="goBack()">戻る</button>

        <button type="button" id="leaveBtn" class="btn-leave" onclick="leaveGroup()">グループから抜ける</button>

    </div>

</div>

<script>

    /**
     * グループメンバーの人数を判定し、「グループから抜ける」ボタンの有効/無効を切り替える関数
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
                memberElement.textContent = members[i - 1].userName;
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