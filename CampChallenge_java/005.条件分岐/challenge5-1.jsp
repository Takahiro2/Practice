<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    int num = 2;

    // 1の時、2の時、それ以外で分岐
    if (num == 1) {
        out.println("1です！");
    } else if (num == 2) {
        out.println("プログラミングキャンプ！");
    } else {
        out.println("その他です！");
    }

%>