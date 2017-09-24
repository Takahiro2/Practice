
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
    // 文字コードをUTF-8に
    request.setCharacterEncoding("UTF-8");

    // 受け取った情報をIntに変換後 num へ
    int num = Integer.parseInt(request.getParameter("num"));
    
    // 変数の宣言 変数名の数字は素因数を 代入する値は因数で分解した数を表す
    int primeNumber2 = 0;int primeNumber3 = 0;
    int primeNumber5 = 0;int primeNumber7 = 0;
    
    // 素因数分解する前の数字を表示
    out.println(num);
    
    // 2から順に分解していく １回分解する毎に代入値+1
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
    
    // 結果が10以下であれば上記の素因数で分解しきっているので結果を表示
    if(num <= 10){
        out.println("2^" + primeNumber2 + ",3^" + primeNumber3
                + ",5^" + primeNumber5 + ",7^" + primeNumber7);
        
     // 11以上残るようであれば2桁以上の素数なので、
     // 課題通り元の値 1桁の素因数 余った値を表示
    }else{
        out.println("7 " + num % 7);
    }
    
%>
