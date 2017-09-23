package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Challenge11h", urlPatterns = {"/Challenge11h"})
public class Challenge11h extends HttpServlet {

    // 3人分のプロフィール情報を作成 入っていない情報はnullを入れる
    String[] prof1 = {"相田", "1月1日", "愛知県"};
    String[] prof2 = {"飯田", "2月2日", null};
    String[] prof3 = {"宇井", "3月3日", "ウクライナ"};
    // 配列allprofに3人分のプロフィールを収納
    String[][] allprof = {prof1, prof2, prof3};

    // IDを引数として渡すと該当するID情報を返してくれるprofileメソッド
    String[] profile(int ID) {
        return allprof[ID];
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 文字コードをUTF-8に
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            // 変数limitを作成
            Integer limit = 2;

            // limitの回数2回ループ
            for (int ID = 0; ID < limit; ID++) {

                // 配列allprofileに引数で渡されたID情報を収納
                String[] allprofile = profile(ID);

                // 3回ループ
                for (int i = 0; i < 3; i++) {

                    // nullの情報は飛ばす
                    if (allprofile[i] == null) {
                        continue;
                    }

                    // 入っている情報を表示していく
                    out.println(allprofile[i]);
                    // 一人出す毎に改行
                    out.print("<br>");

                }
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
