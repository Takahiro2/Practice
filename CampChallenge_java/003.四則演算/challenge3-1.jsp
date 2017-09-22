<%-- 
    Document   : challenge2-2
    Created on : 2017/07/24, 10:17:14
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

final int base = 100;
int num = 2;

int tasu = base + num;
int hiku = base - num;
int kake = base * num;
int waru = base / num;

out.println(tasu);
out.println(hiku);
out.println(kake);
out.println(waru);

%>
