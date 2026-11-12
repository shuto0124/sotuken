<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理画面</title>
</head>

<body>

<table border="1" align="center" width="650">

<tr>
<td align="center">

<h1>商品管理画面</h1>

<br>

<!-- 商品1 -->
<table border="1" width="520" height="180">

<tr>
    <td rowspan="3" align="center" width="220">
        <img src="../images/product1.jpg"
             width="180"
             height="130"
             alt="商品画像">
    </td>

    <td colspan="2" align="center">
        商品名
    </td>
</tr>

<tr>
    <td align="center">
        値段
    </td>

    <td align="center">
        <form action="productUpdate.jsp">
            <button type="submit">更新</button>
        </form>
    </td>
</tr>

<tr>
    <td align="center">
        提供数
    </td>

    <td align="center">
        <form action="productDelete.jsp">
            <button type="submit">削除</button>
        </form>
    </td>
</tr>

</table>

<br>

<!-- 商品2 -->
<table border="1" width="520" height="180">

<tr>
    <td rowspan="3" align="center" width="220">
        <img src="../images/product2.jpg"
             width="180"
             height="130"
             alt="商品画像">
    </td>

    <td colspan="2" align="center">
        商品名
    </td>
</tr>

<tr>
    <td align="center">
        値段
    </td>

    <td align="center">
        <form action="productUpdate.jsp">
            <button type="submit">更新</button>
        </form>
    </td>
</tr>

<tr>
    <td align="center">
        提供数
    </td>

    <td align="center">
        <form action="productDelete.jsp">
            <button type="submit">削除</button>
        </form>
    </td>
</tr>

</table>

<br><br>

<table>
<tr>

<td>
<form action="../index.jsp">
    <button type="submit"
            style="width:120px;height:50px;">
        戻る
    </button>
</form>
</td>

<td width="100"></td>

<td>
<form action="productRegister.jsp">
    <button type="submit"
            style="width:120px;height:50px;">
        登録
    </button>
</form>
</td>

</tr>
</table>

<br>

</td>
</tr>

</table>

</body>
</html>