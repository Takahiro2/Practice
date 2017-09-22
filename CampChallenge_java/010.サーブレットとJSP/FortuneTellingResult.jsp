<%@page import="org.mypackage.sample.ResultData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%
            // リクエストスコープでDATAを受け取る
            ResultData data = (ResultData)request.getAttribute("DATA");
        %>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            // 受け取った情報に中身があった場合表示
            if(data != null){
                out.print("<h1>あなたの" + data.getD() + "の運勢は" + data.getLuck() + "です！</h1>");    
            }
        %>
        
    </body>
</html>
