<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

    // 1000が100未満になるまで2で割り続ける
    int num = 1000;
    while (num > 100) {
        num = num / 2;
        out.println(num);
    }

%>
