<%-- 
    Document   : challenge8-1
    Created on : 2017/07/24, 13:59:37
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
long num = 8;
int i = 1;
for(i = 1;i < 20;i++){
    num *= 8;
} out.println(num);
%>