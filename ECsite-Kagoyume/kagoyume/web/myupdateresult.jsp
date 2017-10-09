<%@page import="kagoyume.UserData"%>
<%@page import="kagoyume.kagoyumeHelper"%>
<%
    kagoyumeHelper kh = kagoyumeHelper.getInstance();
    UserData ud = (UserData) request.getAttribute("ud");
    String name = ud.getName();
    String password = ud.getPassword();
    String mail = ud.getMail();
    String address = ud.getAddress();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- BootstrapのCSS読み込み -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- jQuery読み込み -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- BootstrapのJS読み込み -->
        <script src="js/bootstrap.min.js"></script>
        <title>かごゆめ</title>
    </head>
    <body>
        <div class="container" align="center">
            <h3>下記の内容で更新しました。</h3>
            ユーザー名:<br>
            <%= name%><br><br>
            パスワード:<br>
            <%= password%><br><br>
            メールアドレス:<br>
            <%= mail%><br><br>
            住所:<br>
            <%= address%><br><br>

            <%= kh.mydata()%><br><br>
            <%= kh.top()%>
        </div>
    </body>
</html>
