/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
@WebServlet(urlPatterns = {"/Update"})
public class Update extends HttpServlet {

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

            Connection db_con = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "GEEKJOB", "password");

                PreparedStatement db_update = null;
                db_update = db_con.prepareStatement("update profiles set name = '松岡 修造', age = 48 ,birthday = '1967-11-06' where profilesID = 1");
                db_update.executeUpdate();

                PreparedStatement db_sl = db_con.prepareStatement("select * from profiles");
                ResultSet db_print = db_sl.executeQuery();

                while (db_print.next()) {
                    out.println("profilesID:" + db_print.getString("profilesID"));
                    out.println("name:" + db_print.getString("name"));
                    out.println("tel:" + db_print.getString("tel"));
                    out.println("age:" + db_print.getString("age"));
                    out.println("birthday" + db_print.getString("birthday"));

                }

                db_con.close();
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
