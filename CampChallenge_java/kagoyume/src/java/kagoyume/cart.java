package kagoyume;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * cart.jspに対応するサーブレット
 */

@WebServlet(name = "cart", urlPatterns = {"/cart"})
public class cart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(); // セッションスタート

        // ログインしていない場合
        if (session.getAttribute("login") == null || !(session.getAttribute("login").equals("in"))) {
            session.setAttribute("page", "cart");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        // cart.jspにて削除を実行した場合ここで削除処理を行う
        if (request.getParameter("delete") != null) {
            String deleteCode = request.getParameter("delete");

            ArrayList<ProductData> cartList = (ArrayList) session.getAttribute("cartList");
            for (ProductData value : cartList) {
                if (deleteCode.equals(value.getCode())) {
                    ProductData deleteData = value;
                    cartList.remove(deleteData);
                    break;
                }
            }
        }

        // 買い物カゴが空の時の為の処理 NULL対策
        ArrayList<ProductData> pd = new ArrayList<>();
        if (session.getAttribute("cartList") != null) {
            pd = (ArrayList<ProductData>) session.getAttribute("cartList");
        }
        session.setAttribute("cartList", pd);

        request.getRequestDispatcher("/cart.jsp").forward(request, response); // cart.jspへ遷移

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
