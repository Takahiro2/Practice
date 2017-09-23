<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // 文字コードをUTF-8に
    request.setCharacterEncoding("UTF-8");

    // request.getParameterで前のページから送ってきたnameを指定するとその値が受け取れる
    out.println(request.getParameter("名前"));
    out.println(request.getParameter("性別"));
    out.println(request.getParameter("趣味"));
%>
