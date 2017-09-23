
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "challenge11d", urlPatterns = {"/challenge11d"})
public class challenge11d extends HttpServlet {

    // 渡した値で掛け算を行い、trueがあれば更に2乗し、計算が完了すればtrueを返す
    boolean kake(int num1, int num2, boolean f, PrintWriter pw) {

        if (f == true) {
            pw.print(num1 * num2 * (num1 * num2));
        } else {
            pw.print(num1 * num2);
        }

        return true;

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 文字コードをUTF-8にする
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            // 適当な数字 6 5 boolean true を与え正しく計算が終了すればそのまま計算結果を画面に表示
            if (kake(6, 5, true, out) == true) {
                out.println(kake(6,5,true,out));
                out.println("この処理は正しく実行できました");
            } else {
                out.print("正しく実行できませんでした");
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
