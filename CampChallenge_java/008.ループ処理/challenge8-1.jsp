<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
// 8の20乗を計算
long num = 8;
int i = 1;
for(i = 1;i < 20;i++){
    num *= 8;
} 

out.println(num);

%>