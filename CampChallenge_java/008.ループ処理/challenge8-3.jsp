<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    // 0~100までの数を足していく
    int num = 0;
    int i;
    for (i = 0; i <= 100; i++) {
        num += i;
        out.println(num);
    }

%>
