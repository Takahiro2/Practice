<%-- 
    Document   : challenge5-3
    Created on : 2017/07/24, 11:21:48
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
char lang = 'あ';

switch(lang){
    case 'A':
        out.println("英語");
        break;
    case 'あ':
        out.println("日本語");
        break;
    default:
        break;
}
%>
