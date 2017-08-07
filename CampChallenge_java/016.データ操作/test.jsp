<%-- 
    Document   : test
    Created on : 2017/08/07, 10:36:26
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
// 受け取るパラメータの文字コード
    request.setCharacterEncoding("UTF-8");
// テキストボックスの情報
    int type = Integer.parseInt(request.getParameter("type"));

    switch (type) {
        case 1:
            out.println("雑貨");
            break;
        case 2:
            out.println("生鮮食品");
            break;
        case 3:
            out.println("その他");
            break;
    }

    int total = Integer.parseInt(request.getParameter("total"));
    int count = Integer.parseInt(request.getParameter("count"));

    int price = total / count;
    out.println(price);

    if (total >= 5000) {
        int point = (int) (total * 0.05);
        out.println("ポイントは" + point + "です。");
    } else if (total >= 3000) {
        int point = (int) (total * 0.04);
        out.println("ポイントは" + point + "です。");
    } else {
        out.println("ポイントはありません。");
    }

%>
