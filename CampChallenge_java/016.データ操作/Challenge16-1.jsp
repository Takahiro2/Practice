<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    request.setCharacterEncoding("UTF-8");

    out.println(request.getParameter("名前"));

    out.println(request.getParameter("性別"));

    out.println(request.getParameter("趣味"));
%>
