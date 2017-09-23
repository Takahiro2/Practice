
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // 受け取るパラメータの文字コード
    request.setCharacterEncoding("UTF-8");
    // テキストボックスの情報をIntに変換後 typeへ
    int type = Integer.parseInt(request.getParameter("type"));

    // 受け取った数字に対応するタイプを画面に表示
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

    // 入力フォームで入力した総額と個数の情報を受け取る
    int total = Integer.parseInt(request.getParameter("total"));
    int count = Integer.parseInt(request.getParameter("count"));

    // 総額を個数で割った整数をintへ 表示
    int price = total / count;
    out.println(price);

    // 総額が5000円以上なら～ 3000円以上なら～ その他で分岐
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
