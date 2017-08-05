package org.mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlackJack extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Dealer dealer = new Dealer();
            User user = new User();

            user.setCard(dealer.deal());// プレイヤーに2枚配布
            out.println("あなたのカードは" + user.myCards + "<br>");

            dealer.setCard(dealer.deal()); // ディーラーに２枚配布
            out.println("ディーラーのカードは" + dealer.myCards + "<br>");

            while (user.checkSum()) { // プレイヤーの追加ドロー
                ArrayList<Integer> hitcard = dealer.hit();
                user.setCard(hitcard);
                out.print("あなたは" + hitcard + "をhit" + "<br>");
            }
            while (dealer.checkSum()) { // ディーラーの追加ドロー
                ArrayList<Integer> hitcard = dealer.hit();
                dealer.setCard(hitcard);
                out.print("ディーラーは" + hitcard + "をhit" + "<br>");
            }
            if (user.open() > 21 && dealer.open() > 21) {
                out.println("2人ともBUSTED 引き分けです");
            } else if (user.open() > 21) {
                out.println("BUSTED あなたの負けです");
            } else if (dealer.open() > 21) {
                out.println("ディーラーがBUSTED あなたの勝ちです");
            } else if (user.open() > dealer.open()) {
                out.println("あなたの勝ちです");
            } else if (user.open() == dealer.open()) {
                out.println("引き分けです");
            } else {
                out.println("あなたの負けです");
            }
            out.println("<br>" + "【You】" + user.open() + "vs" + "【Dealer】" + dealer.open());
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
