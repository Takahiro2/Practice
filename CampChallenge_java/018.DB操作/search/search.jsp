<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索用フォームの用意と検索（部分一致）</title>
    </head>
    <body>
        <form action = "./search" method = "post">
            名前:<input type ="text" name ="searchName">
            <input type ="submit" value="検索">
        </form>    
    </body>
</html>
