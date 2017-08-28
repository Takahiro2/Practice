<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>

<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <% if (udb.getName().equals("")) { %>
        <h1>名前が入力されていません。</h1>
        <% }
            if (udb.getYear().equals("")) { %>
        <h1>生年が入力されていません。</h1>
        <% }
            if (udb.getMonth().equals("")) { %>
        <h1>生月が入力されていません。</h1>
        <% }
            if (udb.getDay().equals("")) { %>
        <h1>生日が入力されていません。</h1>
        <% }
            if (udb.getTell().equals("")) { %>
        <h1>電話番号が入力されていません。</h1>
        <% }
            if (udb.getComment().equals("")) {%>
        <h1>自己紹介が入力されていません。</h1>
        <form action="insert.jsp" method="POST">
            <input type="submit" name="return" value="登録画面に戻る">
        </form>
        <%= JumsHelper.getInstance().home()%>
        <% } else {%>

        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日"%><br>
        種別:<% if (udb.getType() == 1) { %>
        エンジニア
        <% } else if (udb.getType() == 2) { %>
        営業
        <% } else { %>
        その他
        <% }%>    
        <br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>

        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <%= JumsHelper.getInstance().home()%>
        <% }%>
    </body>
</html>
