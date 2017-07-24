<%-- 
    Document   : challenge8-4
    Created on : 2017/07/24, 16:26:52
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int num = 1000;
while(num > 100){
    num = num / 2;
    out.println(num);
}
%>
