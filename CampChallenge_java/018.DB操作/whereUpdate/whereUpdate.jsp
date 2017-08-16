<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>特定のレコードの削除をするフォーム</title>
    </head>
    <body>
        <form action = "./whereUpdate" method = "post">
            <select name ="ID">
                <option value="">変更するプロフィールID</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select>    <br>
            名前<input type="text" name="name"><br>
            電話番号<input type="text" name="tel"><br>
            年齢<input type="text" name="age"><br>
            誕生日<input type="text" name="birthday">
            <input type ="submit" value="送信">
        </form>    
    </body>
</html>
