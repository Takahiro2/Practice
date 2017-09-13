<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    // Data型をString型に変換
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String birthday = sdf.format(session.getAttribute("birthday"));
    // 誕生日を年月日に分割
    String year = birthday.substring(0, 4);
    String month = birthday.substring(5, 7);
    String day = birthday.substring(8, 10);
    // typeをInt型で取得
    int type = (Integer) session.getAttribute("type");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>変更画面</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- BootstrapのCSS読み込み -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- jQuery読み込み -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- BootstrapのJS読み込み -->
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <form action="UpdateResult" method="POST">
            名前:
            <input type="text" name="name" value="<%= session.getAttribute("name")%>">
            <br><br>

            生年月日:　
            <select name="year">
                <option><%= year%></option>
                <% for (int i = 1950; i <= 2010; i++) {%>
                <option value="<%=i%>" ><%=i%></option>
                <% }%>
            </select>年
            <select name="month">
                <option><%= month%></option>
                <% for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% }%>
            </select>月
            <select name="day">
                <option><%= day%></option>
                <% for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% } %>
            </select>日
            <br><br>

            種別:
            <br>
            <% for (int i = 1; i <= 3; i++) {%>
            <input type="radio" name="type" value="<%=i%>"<% if (type == i) {
                    out.print("checked = \"checked\" ");
                }%>><%=jh.exTypenum(i)%><br>
            <% }%>
            <br>

            電話番号:
            <input type="text" name="tell" value="<%= session.getAttribute("tell")%>">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= session.getAttribute("comment")%></textarea><br><br>
            <input type="hidden" name="ac" value="<%= session.getAttribute("ac")%>">
            <input type="submit" name="btnSubmit" value="更新">
        </form>

        <form action="ResultDetail" method="POST">
            <input type="hidden" name="id" value="<%= session.getAttribute("ID")%>">
            <input type="submit" name="return" value="詳細画面に戻る">
        </form>    

        <br>
        <%=jh.home()%>
    </body>
</html>
