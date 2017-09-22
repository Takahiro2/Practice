<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    // swich文で"A"の時、"あ"の時、それ以外で分岐
    char lang = 'あ';

    switch (lang) {
        case 'A':
            out.println("英語");
            break;
        case 'あ':
            out.println("日本語");
            break;
        default:
            break;
    }

%>
