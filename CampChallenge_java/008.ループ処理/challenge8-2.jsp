<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    // "A"に"A"を29回足す
    String A = "A";
    int i;
    for (i = 1; i < 30; i++) {
        A = A + "A";
    }
    out.print(A);

%>
