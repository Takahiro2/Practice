<%-- 
    Document   : challenge7-1
    Created on : 2017/07/24, 12:56:26
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<%
HashMap<String, String> prof =
            new HashMap<String, String>();
prof.put("1","AAA");prof.put("hello","world");
prof.put("soeda","33");prof.put("20","20");
out.print(prof.get("1"));

%>

