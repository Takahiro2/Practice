<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>商品情報登録</h1>
        <%
            String message = (String) session.getAttribute("message");
            if (message == null) {
                out.print("商品情報を登録して下さい。");
            } else {
                out.print(message);
            }
        %>    
        <form action ="productRegist" method ="post">
            商品ID:<input type ="text" name ="ID">
            商品名:<input type ="text" name ="name">
            在庫数:<input type ="text" name ="inventory">
            <input type ="submit" value ="送信">
            <br>
        </form>
        <form action ="./user.jsp" method ="post">
            <input type="submit" value ="戻る">
        </form>   
        <form action ="login.jsp" method ="post">
            <a href ="./login.jsp">ログアウト</a>
            <%
                session.invalidate();
            %>    
        </form>
    </body>
</html>
