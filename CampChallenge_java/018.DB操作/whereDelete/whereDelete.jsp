<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>特定のレコードの削除をするフォーム</title>
    </head>
    <body>
        <form action = "./whereDelete" method = "post">
            <input type ="text" name ="deleteID">
            <input type ="submit" value="削除">
        </form>    
    </body>
</html>
