<%-- 
    Document   : challenge8-3
    Created on : 2017/07/24, 15:33:19
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int num = 0;
int i;
for(i = 0;i <= 100;i++){
    num += i;
      out.println(num);
}
%>
