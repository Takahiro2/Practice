<%-- 
    Document   : challenge 6-2
    Created on : 2017/07/24, 11:55:05
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String[] data = { "10", "100", "soeda", "hayashi", "-20", "118", "END"};
data[2] = "33";
out.println(data[2]);
%>
