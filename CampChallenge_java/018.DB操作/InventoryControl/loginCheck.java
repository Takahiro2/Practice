/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
@WebServlet(urlPatterns = {"/loginCheck"})
public class loginCheck extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        Connection db_con = null;
        HttpSession hs = request.getSession(true);
        String name = request.getParameter("userName");
        String password = request.getParameter("password");

        // 入力値が空であればログインページに戻す
        if (name.isEmpty()) {
            hs.setAttribute("log", "log");
            RequestDispatcher rd = request.getRequestDispatcher("./login.jsp");
            rd.forward(request, response);
        } else if (password == null) {
            hs.setAttribute("log", "log");
            RequestDispatcher rd = request.getRequestDispatcher("./login.jsp");
            rd.forward(request, response);
        } else {

            try {

                // 接続文字列
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");

                // 入力情報を基にmysql内での検索
                PreparedStatement db_where = null;
                db_where = db_con.prepareStatement("select * from ユーザー情報管理 where ユーザー名 = ? and パスワード = ? ");
                db_where.setString(1, name);
                db_where.setString(2, password);

                // 情報があればUserページへ　なければloginページへ戻る
                ResultSet db_result = null;
                db_result = db_where.executeQuery();

                if (db_result.next()) {
                    hs.setAttribute("log", name);
                    RequestDispatcher rd = request.getRequestDispatcher("./user.jsp");
                    rd.forward(request, response);
                } else {
                    hs.setAttribute("log", name);
                    RequestDispatcher rd = request.getRequestDispatcher("./login.jsp");
                    rd.forward(request, response);
                }

                db_con.close();
                db_where.close();
                db_result.close();

            } catch (SQLException e_sqle) {
                out.println("接続時にエラーが発生しました:" + e_sqle.toString());
            } catch (Exception e) {
                out.println("接続時にエラーは発生しました:" + e.toString());
            } finally {
                if (db_con != null) {
                    try {
                        db_con.close();
                    } catch (Exception e_con) {
                        System.out.println(e_con.getMessage());
                    }
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
