<%-- 
    Document   : challenge
    Created on : 2017/07/24, 10:56:40
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int num = 2;

if(num == 1){
    out.println("1です！");
}else if(num == 2){
    out.println("プログラミングキャンプ！");
}else{
    out.println("その他です！");
}

%>