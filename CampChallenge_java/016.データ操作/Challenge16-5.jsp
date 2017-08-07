<%-- 
    Document   : Challenge16-5
    Created on : 2017/08/07, 16:36:20
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    request.setCharacterEncoding("UTF-8");

    int num = Integer.parseInt(request.getParameter("num"));
    
    int primeNumber2 = 0;int primeNumber3 = 0;
    int primeNumber5 = 0;int primeNumber7 = 0;
    
    out.println(num);
    
    while(num % 2 == 0){
        num /= 2;
        primeNumber2++;
    }
    while(num % 3 == 0){
        num /= 3;
        primeNumber3++;
    }
    while(num % 5 == 0){
        num /= 5;
        primeNumber5++;
    }
    while(num % 7 == 0){
        num /= 7;
        primeNumber7++;
    }
    if(num <= 10){
        out.println("2^" + primeNumber2 + ",3^" + primeNumber3
                + ",5^" + primeNumber5 + ",7^" + primeNumber7);
    }else{
        out.println("7 " + num % 7);
    }
    
    
    
    
%>
