
<%@page import="kagoyume.ProductData"%>
<%@page import="kagoyume.UserDataDTO"%>
<%@page import="kagoyume.kagoyumeHelper"%>
<%@page import="net.arnx.jsonic.JSON"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    kagoyumeHelper kh = kagoyumeHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<ProductData> pl = (ArrayList<ProductData>) session.getAttribute("product");
    String name = "";
    //ログイン状態処理
    boolean log = false;
    if (hs.getAttribute("login") != null) {
        log = true;
        //名前表示のためにセッションから取り出す
        UserDataDTO udd = (UserDataDTO) hs.getAttribute("welcomeUDD");
        name = udd.getName();
    }
    //login後のページ移行のために情報をセッションに格納
    hs.setAttribute("page", "search");
%>
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
        <script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
        <!-- BootstrapのJS読み込み -->
        <script src="js/bootstrap.min.js"></script>

        <title>検索結果</title>
    </head>
    <body>
        <header>
            <div class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <a href="top.jsp" class="navbar-brand"> 
                            <% //ログイン,アウト表示分岐
                               if (!log) {
                            %>
                            <%= kh.login()%> 
                            <% } else {%>
                            <%= kh.logout(name)%>
                            <% }%></a>
                    </div>
                </div>
            </div>
        </header>

        <hr>

        <% for (ProductData value : pl) {%>
    <tr>

    <tb> <a href="item?code=<%= value.getCode()%>"><img src="<%= value.getImage()%>">  </a> <strong>&yen;  <%= value.getPrice()%></strong></tb>
    <tb><h1><a href="item?code=<%= value.getCode()%>"><%= value.getName()%></a></h1></tb>
</tr>



<hr>
<% }%>

<%= kh.top()%>


</body>
</html>
