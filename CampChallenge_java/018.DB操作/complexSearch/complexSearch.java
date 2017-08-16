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
import java.sql.ResultSet;
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
@WebServlet(urlPatterns = {"/complexSearch"})
public class complexSearch extends HttpServlet {

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
                int age = Integer.parseInt(request.getParameter("age"));

                // 情報を基にmysqlにて検索する
                PreparedStatement db_insert = null;
                db_insert = db_con.prepareStatement("select * from profiles where name = ? and age = ?");
                db_insert.setString(1, name);
                db_insert.setInt(2, age);

                // 取得した情報を表示
                ResultSet db_print = null;
                db_print = db_insert.executeQuery();
                while (db_print.next()) {
                    out.print("ID:" + db_print.getInt("profilesID") + "<br>"
                            + "名前:" + db_print.getString("name") + "<br>"
                            + "電話番号" + db_print.getString("tel") + "<br>"
                            + "年齢:" + db_print.getInt("age") + "<br>"
                            + "誕生日:" + db_print.getString("birthday") + "<br>"
                    );

                }
                db_con.close();
                db_insert.close();
                db_print.close();
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
