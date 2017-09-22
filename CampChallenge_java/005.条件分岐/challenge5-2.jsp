<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    int num = 3;
    
    // switchで1の時、2の時、それ以外で分岐
    switch (num) {
        case 1:
            out.println("one");
            break;
        case 2:
            out.println("two");
        default:
            out.println("想定外");
    }
    
%>
