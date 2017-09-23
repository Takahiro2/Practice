
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class challenge11c extends HttpServlet {

    // 渡された数値で掛け算をするメソッド
    void kake(int num1, int num2, boolean f, PrintWriter pw) {
        
        // 3番目の引数がtrueの時は更に２乗
        if (f == true) {
            pw.print(num1 * num2 * (num1 * num2));
        // trueでない時    
        } else {
            pw.print(num1 * num2);
        }
    }

    // 適当な数字 6 5 更に boolean false を入れた
    void kake(PrintWriter pw) {
        kake(6, 5, false, pw);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 文字コードをUTF-8に
        response.setContentType("text/html;charset=UTF-8");
        
        // 画面表示
        try (PrintWriter out = response.getWriter()) {
            // 結果の表示
            kake(out);
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
