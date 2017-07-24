<%-- 
    Document   : challenge5-2
    Created on : 2017/07/24, 11:14:12
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int num = 3;

switch(num){
    case 1:
        out.println("one");
        break;
    case 2:
        out.println("two");
    default:
        out.println("想定外");
}
%>
