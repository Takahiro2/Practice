/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
@WebServlet(urlPatterns = {"/whereUpdate"})
public class whereUpdate extends HttpServlet {

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
        
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Connection db_con = null;

            try {
                // 接続文字列
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");

                // 検索フォームから情報を取得
                String name = request.getParameter("name");
                String tel = request.getParameter("tel");
                int age = Integer.parseInt(request.getParameter("age"));
                String birthday = request.getParameter("birthday");
                int ID = Integer.parseInt(request.getParameter("ID"));
                // String型をDate型へ変換
                java.util.Date birth = sdf.parse(birthday);

                // 情報を基にmysqlにて情報を追加する
                PreparedStatement db_insert = null;
                db_insert = db_con.prepareStatement("update profiles set name = ? where profilesID = ?");
                db_insert.setString(1, name);
                db_insert.setInt(2,ID);
                db_insert.executeUpdate();
                db_insert = db_con.prepareStatement("update profiles set tel = ? where profilesID = ?");
                db_insert.setString(1, tel);
                db_insert.setInt(2, ID);
                db_insert.executeUpdate();
                db_insert = db_con.prepareStatement("update profiles set age = ? where profilesID = ?");
                db_insert.setInt(1, age);
                db_insert.setInt(2, ID);
                db_insert.executeUpdate();
                db_insert = db_con.prepareStatement("update profiles set birthday = ? where profilesID = ?");
                db_insert.setDate(1, new Date(birth.getTime()));
                db_insert.setInt(2, ID);
                db_insert.executeUpdate();
                
                db_con.close();
                db_insert.close();
            } catch (SQLException e_sqle) {
                out.println("接続時にエラーが発生しました:" + e_sqle.toString());
            } catch (Exception e) {
                out.println("接続時にエラーが発生しました：" + e.toString());
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
