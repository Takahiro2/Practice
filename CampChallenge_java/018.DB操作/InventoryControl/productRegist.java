
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/productRegist"})
public class productRegist extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        HttpSession hs = request.getSession(true);
        Connection db_con = null;

        // 検索フォームから情報を取得
        String name = request.getParameter("name");
        String inventory = request.getParameter("inventory");
        String strID = request.getParameter("ID");

        // 未入力があれば、商品登録ページへ戻す
        if (strID == null) {
            hs.setAttribute("message", "未入力の項目があります。");
            RequestDispatcher rd = request.getRequestDispatcher("./productRegist.jsp");
            rd.forward(request, response);
        } else if (name == null) {
            hs.setAttribute("message", "未入力の項目があります。");
            RequestDispatcher rd = request.getRequestDispatcher("./productRegist.jsp");
            rd.forward(request, response);
        } else if (inventory.isEmpty()) {
            hs.setAttribute("message", "未入力の項目があります。");
            RequestDispatcher rd = request.getRequestDispatcher("./productRegist.jsp");
            rd.forward(request, response);
        } else {

            int ID = Integer.parseInt(strID);

            try {
                // 接続文字列
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");

                // 情報を基にmysqlにて情報を追加
                PreparedStatement db_insert = null;
                db_insert = db_con.prepareStatement("insert into 商品情報登録 values (?,?,?)");
                db_insert.setInt(1, ID);
                db_insert.setString(2, name);
                db_insert.setString(3, inventory);
                db_insert.executeUpdate();

                // 情報が登録されているを確認する為のmysql文 
                PreparedStatement db_select = null;
                db_select = db_con.prepareStatement("select * from 商品情報登録 where 商品ID = ? and 商品名 = ? and 在庫 = ?");
                db_select.setInt(1, ID);
                db_select.setString(2, name);
                db_select.setString(3, inventory);

                // DBをclose
                db_con.close();
                db_insert.close();

                // 情報登録の成否をjspに返す
                ResultSet db_result = null;
                db_result = db_select.executeQuery();
                db_select.close();
                if (db_result.next()) {
                    db_result.close();
                    hs.setAttribute("message", "情報が登録されました。");
                    RequestDispatcher rd = request.getRequestDispatcher("./productRegist.jsp");
                    rd.forward(request, response);
                } else {
                    db_result.close();
                    hs.setAttribute("message", "登録に失敗しました。");
                    RequestDispatcher rd = request.getRequestDispatcher("./productRegist.jsp");
                    rd.forward(request, response);
                }

            } catch (SQLException e_sqle) {
                out.println("接続時にエラーが発生しました" + e_sqle.toString());
            } catch (Exception e) {
                out.println("接続にエラーが発生しました:" + e.toString());
            } finally {
                if (db_con != null) {
                    try {
                        db_con.close();
                    } catch (Exception e_con) {
                        out.println(e_con.getMessage());
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
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(productRegist.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productRegist.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(productRegist.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            Logger.getLogger(productRegist.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(productRegist.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productRegist.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(productRegist.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            Logger.getLogger(productRegist.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
