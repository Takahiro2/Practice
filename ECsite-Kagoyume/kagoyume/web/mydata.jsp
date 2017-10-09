<%@page import="kagoyume.UserDataDTO"%>
<%@page import="kagoyume.kagoyumeHelper"%>
<%
    kagoyumeHelper jh = kagoyumeHelper.getInstance();
    HttpSession hs = request.getSession();
    String name = "";
    String password = "";
    String mail = "";
    String address = "";
    // ログイン状態処理
    boolean log = false;
    if (hs.getAttribute("login") != null) {
        log = true;
        // 名前表示を含めたユーザー情報表示のためにセッションから取り出す
        UserDataDTO udd = (UserDataDTO) hs.getAttribute("welcomeUDD");
        name = udd.getName();
        password = udd.getPassword();
        mail = udd.getMail();
        address = udd.getAddress();
    }
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
            <header>
                <hr>
                <% // ログイン,アウト表示分岐
                    if (!log) {
                %>
                <%= jh.login()%> 
                <% } else {%>
                <%= jh.logout(name)%>
                <% }%>
            </header>
            <hr>
            <main>
                <h3>会員情報</h3>
                <table border="1" bordercolor="#333" cellpadding="5" cellspacing="3">
                    <tr>
                        <th>ユーザー名</th>
                        <th>パスワード</th>
                        <th>メールアドレス</th>
                        <th>住所</th>
                    </tr>
                    <tr>
                        <td width="200"><%= name%></td>
                        <td width="200"><%= password%></td>
                        <td width="200"><%= mail%></td>
                        <td width="200"><%= address%></td>
                    </tr>
                </table>
                <br><br>
                <form action="myhistory" method="post">
                    <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
                    <input type="submit" name="history" value="購入履歴を確認する">
                </form>
                <br>
                <form action="myupdate" method="post">
                    <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
                    <input type="submit" name="update" value="会員情報を更新する">
                </form>
                <br>
                <form action="mydelete" method="post">
                    <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
                    <input type="submit" name="delete" value="会員情報を削除する">
                </form>
                <br><br>
                <%= jh.top()%>
            </main>
        </div>
    </body>
</html>
