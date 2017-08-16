<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>フォームからデータを挿入</title>
    </head>
    <body>
        <form action = "./insert" method = "post">
            ID:<input type ="text" name ="ID">
            名前:<input type ="text" name ="name">
            電話番号:<input type ="text" name ="tel">
            年齢:<input type ="text" name ="age">
            誕生日:<input type ="text" name ="birthday"> 
            <input type ="submit" value="入力">
        </form>    
    </body>
</html>
