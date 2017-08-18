<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理システムの作成</title>
    </head>
    <body>
        <form action="./loginCheck" method ="post">
            <%
                String message = (String) session.getAttribute("log");
                if (message != null) {
                    out.print("※ログインに失敗しました※");
                } else {
                    out.print("ユーザー情報を入力してください");
                }
            %>    
            <h1>ログインページ</h1>
            ユーザーネーム:<input type="text" name="userName"><br>
            パスワード<input type="text" name="password"><br>
            <input type="submit" value="送信">
        </form>
    </body>
</html>
