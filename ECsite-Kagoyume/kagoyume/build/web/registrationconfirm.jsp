
<%@page import="kagoyume.kagoyumeHelper"%>
<%@page import="kagoyume.UserDataBeans"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession hs = request.getSession();
    kagoyumeHelper kh = kagoyumeHelper.getInstance();
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("ud");
    ArrayList<String> chkList = udb.chkProperties();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録確認</title>
    </head>
    <body>
        <% if (chkList.size() == 0) { %>
        <h2>登録確認</h2>
        ユーザー名<br>
        <%= udb.getName() %><br><br>
        パスワード<br>
        <%= udb.getPassword() %><br><br>
        メールアドレス<br>
        <%= udb.getMail() %><br><br>
        住所<br>
        <%= udb.getAddress() %><br><br>
        上記の内容で登録いたします。よろしいですか？
        <form action="registrationcomplete" method="post">
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac") %>">
            <input type="submit" name="yes" value="はい">
        </form>
        <% } else { %>
        <h2>入力に不備があります</h2>
        <%= kh.chk(chkList) %>
        <p>もう一度登録画面からやり直してください</p>
        <% } %><br>
        <form action="registration" method="post">
            <input type="hidden" name="mode" value="reinput">
            <input type="submit" name="no" value="いいえ">
        </form><br>
        <hr>
        <%= kh.top() %>
    </body>
</html>
