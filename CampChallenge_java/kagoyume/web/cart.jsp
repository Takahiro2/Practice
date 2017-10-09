<%@page import="kagoyume.ProductData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kagoyume.kagoyumeHelper"%>

<%
    kagoyumeHelper h = kagoyumeHelper.getInstance();
    ArrayList<ProductData> pdl = (ArrayList) session.getAttribute("cartList");
    int totalPrice = 0;
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
        <title>カートページ</title>
    </head>
    <body style="padding: 5px">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 text-center"><h1><strong>Cart</strong></h1></div>
            </div><br><br>
            <% if (pdl != null && pdl.size() != 0) {%>
            <% for (ProductData value : pdl) {%>
            <div class="row">
                <div class="col-lg-2">
                    <table class="table">
                        <tr>
                            <th>Image</th>
                        </tr>
                        <tr>
                            <td><img src="<%= value.getImage()%>"></td>
                        </tr>
                    </table>
                </div>
                <div class="col-lg-7">
                    <ul class="list-unstyled">
                        <li>Name:<td><a href="item?code=<%= value.getCode()%>"><%= value.getName()%></a></li><br><br>
                        <li>Price:<%= value.getPrice()%></li><br><br>
                        <li>
                            <form action="cart" method="post">
                                <button class="btn btn-default" type="submit">削除</button>
                                <input type="hidden" name="delete" value="<%=value.getCode()%>">
                            </form>
                        </li>
                    </ul>
                </div>
            </div>
            <%
                totalPrice += Integer.parseInt(value.getPrice());
                session.setAttribute("totalPrice", totalPrice);
            %><br>
            <% }%>
            <% } else { %>
            <div class="row">
                <div class="col-lg-offset-2 col-lg-10 text-left">
                    <strong>Empty</strong>
                </div>
            </div>
            <% }%><br>
            <div class="row">
                <div class="col-lg-offset-2 col-lg-10 text-left">
                    <ul class="list-unstyled">
                        <li>TotalPrice:<%=totalPrice%></li><br>
                        <li>
                            <% if(totalPrice != 0) { %>
                            <form action="buyconfirm" >
                                <button type="submit" class="btn btn-default">購入する</button>
                            </form>
                            <% } %>
                        </li>
                    </ul>
                </div>
            </div><br><br>
            <%=h.top()%>
        </div>
</body>
</html>