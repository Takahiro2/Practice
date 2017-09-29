
<%@page import="kagoyume.UserDataBeans"%>
<%@page import="kagoyume.kagoyumeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    kagoyumeHelper jh = kagoyumeHelper.getInstance();
    UserDataBeans ud = (UserDataBeans)request.getAttribute("ud");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録完了</title>
    </head>
    <body>
        <h3>下記の内容で登録しました</h3><br>
        ユーザー名<br>
        <%= ud.getName()%><br><br>
        パスワード<br>
        <%= ud.getPassword()%><br><br>
        メールアドレス<br>
        <%= ud.getMail()%><br><br>
        住所<br>
        <%= ud.getAddress()%><br>
        <p>トップ画面に戻りログインしてください</p>
        <hr>
        <%= jh.top()%>
    </body>
</html>
