package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.Random;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "FortuneTelling", urlPatterns = {"/FortuneTelling"})
public class FortuneTelling extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 文字コードをUTF-8に変更
        response.setContentType("text/html;charset=UTF-8");

        // PrintWriterは先ほど設定したUTF-8を使ってエンコーティングしてくれる
        try (PrintWriter out = response.getWriter()) {

            // 配列lucklistにおみくじの中身を代入
            String lucklist[] = {"大吉", "中吉", "吉", "半吉", "末小吉", "凶", "小凶", "半凶", "末凶", "凶", "大凶"};
            // 乱数randを生成
            Random rand = new Random();
            // indexにおみくじの種類数内の乱数を取得
            Integer index = rand.nextInt(lucklist.length);

            // 結果を取得する為のdataを宣言
            ResultData data = new ResultData();

            data.setD(new Date());
            // 乱数index番目のおみくじを引く
            data.setLuck(lucklist[index]);
            // リクエストスコープ"DATA"に、占い結果dataを格納
            request.setAttribute("DATA", data);

            // ページ遷移用のresult
            final String result = ("/WEB-INF/jsp/FortuneTellingResult.jsp");
            // リクエストディスパッチャーでFortuneTellingResult.jspに
            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request, response);
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
