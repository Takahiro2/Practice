
<%-- 
    Document   : Challenge16h
    Created on : 2017/08/09, 14:33:53
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            
            request.setCharacterEncoding("UTF-8");
            
            HttpSession hs = request.getSession();
                
            String name = "";
            String gender = "";
            String hobby = "";
            
            if(hs.getAttribute("name") != null) {
                name = (String) hs.getAttribute("name");
            }
            
            if(hs.getAttribute("gender")!= null) {
                gender = (String) hs.getAttribute("gender");
            }
            
            if(hs.getAttribute("hobby")!= null) {
                hobby = (String)hs.getAttribute("hobby");
            }
        %>    

        <form action="./Challenge16h" method="POST">
            名前:<input type="text" name="名前" value="<%= name%>">
            男:<input type="radio" name="性別" value="1"
                     <%if (gender.equals("1")) {
                             out.println("checked");
                         }%>>
            女:<input type="radio" name="性別" value="2"
                     <%if (gender.equals("2")) {
                             out.println("checked");
                         }%>>
            趣味:<textarea name="趣味"><%= hobby%></textarea>
            <input type="submit" value="送信">
        </form>
    </body>
</html>
