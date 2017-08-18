<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection db_con = null;

            // 接続文字列
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");

            // select * 実行後、表示
            PreparedStatement db_select = db_con.prepareStatement("select * from 商品情報登録");
            ResultSet db_print = db_select.executeQuery();
            while (db_print.next()) {
                out.print("ID:" + db_print.getInt("商品ID") + "<br>"
                        + "商品名:" + db_print.getString("商品名") + "<br>"
                        + "在庫数" + db_print.getString("在庫") + "<br>"
                );
            }

            db_con.close();
            db_select.close();
            db_print.close();
        %>    
        <form action ="./user.jsp" method ="get">
            <input type="submit" value ="戻る">
        </form>    
    </body>
</html>
