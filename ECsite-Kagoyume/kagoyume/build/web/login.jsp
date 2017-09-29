
<%@page import="kagoyume.kagoyumeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    kagoyumeHelper kh = kagoyumeHelper.getInstance(); // ヘルパークラスの呼び出し
    HttpSession hs = request.getSession(); // セッション開始
    String al = "";
    
    hs.setAttribute("returnURL", "login");

    boolean alert = false;
    if (session.getAttribute("noadd") != null) {
        alert = true;
        al = (String) session.getAttribute("noadd");
        session.setAttribute("noadd", null);
    }

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ログインページ</h1>
        <%             if (alert) {
                out.print(al);
            }
        %>
        <form action="loginCheck" method="post">
            名前<br>
            <input type="text" name="name"><br><br>
            パスワード<br>
            <input type="password" name="pass"><br><br>
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="submit" value="ログイン">
        </form>
        <form action="registration" method="post">
            <input type="submit" name="btn" value="新規登録画面">
        </form><br>
        <%= kh.top()%>
    </body>
</html>
