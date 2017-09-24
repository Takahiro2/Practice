package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Challenge16f extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 文字コードをUTF-8に
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            // Dateに現在時刻を代入 sdfを宣言
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat();
            // Cookieを宣言 "LastLogin"に先ほどの現在時刻を代入
            Cookie login = new Cookie("LastLogin", sdf.format(now));

            // サーバーに先ほどのクッキーを追加、保存 
            response.addCookie(login);

            // 配列Cookieにサーバーに保存されているクッキー情報を代入
            // 上記で現在時刻を追加しているが、getCookiesメソッドの取得情報は
            // アクセスした時点での情報を取得する為初回はnullを取得する事になる
            Cookie[] lastLogin = request.getCookies();

            // 中身に情報が入っている時
            if (lastLogin != null) {
                // lastloginに入っている要素数全てを検索していく .lengthは配列の要素数
                for (int i = 0; i < lastLogin.length; i++) {
                    // 配列名"LastLoginを見つけた時
                    lastLogin[i].getName().equals("LastLogin");
                    // 以下のように表示
                    out.println("最後のログインは" + lastLogin[i].getValue());
                }
            } else { // nullの時
                out.println("null"); // nullと表示
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
