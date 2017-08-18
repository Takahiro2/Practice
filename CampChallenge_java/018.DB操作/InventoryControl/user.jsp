<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String message = (String) session.getAttribute("log");
            out.println("ようこそ！" + message + "様");
        %>    
        <form action ="./productRegist.jsp" method ="post">
            <input type ="submit" value ="商品情報登録へ">
        </form>
        <form action ="./list.jsp" method ="post">
            <input type ="submit" value ="商品一覧へ">
        </form>
        <a href ="./login.jsp">ログアウト</a>
        <%
            session.invalidate();
        %>    
    </body>
</html>

<%

%>