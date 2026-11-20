<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品登録</title>
</head>
<body>
	<table border="1" align="center" width="600">
		<tr>
        	<td align="center">

                <h1>商品登録</h1>
                <br>

                <form action="ProductRegisterExecute.action" method="post" enctype="multipart/form-data">
                    
                    <table>
                        <tr>
                            <td>
                                <input type="text"
                                       name="productNumber"
                                       size="30"
                                       placeholder="商品番号の入力欄">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                                <input type="text"
                                       name="productName"
                                       size="30"
                                       placeholder="商品名の入力欄">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                                <input type="text"
                                       name="productPrice"
                                       size="30"
                                       placeholder="価格の入力欄">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                                <textarea name="productDescription"
                                          rows="6"
                                          cols="35"
                                          placeholder="商品説明の入力欄"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                                <input type="text"
                                       name="productStock"
                                       size="30"
                                       placeholder="商品在庫数の入力欄">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                                <input type="file" name="productImage" accept="image/*">
                            </td>
                        </tr>
                    </table>

                    <br><br>

                    <table>
                        <tr>
                            <td>
                                <button type="button"
                                        onclick="location.href='ProductManagement.action'"
                                        style="width:120px;height:50px;">
                                    戻る
                                </button>
                            </td>
                            <td width="100"></td>
                            <td>
                                <button type="submit"
                                        style="width:120px;height:50px;">
                                    登録
                                </button>
                            </td>
                        </tr>
                    </table>

                </form>

            </td>
        </tr>
    </table>

</body>
</html>
