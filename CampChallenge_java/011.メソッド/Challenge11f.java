
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Challenge11f", urlPatterns = {"/Challenge11f"})
public class Challenge11f extends HttpServlet {

    // IDを引数として、指定されたIDのプロフィールを戻り値として返すメソッド
    String[] profile(int ID) {
        
        switch (ID) {
            case 001: {
                String prof[] = {"相田", "1月1日", "愛知県"};
                return prof;
            }
            case 002: {
                String prof[] = {"飯田", "2月2日", "石川県"};
                return prof;
            }
            case 003: {
                String prof[] = {"宇井", "3月3日", "ウクライナ"};
                return prof;
            }
        }
        
        // ID情報が存在しない場合はnullを返す
        return null;
        
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 文字コードをUTF-8に
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {

            // 引数として002を渡す
            String[] IDdata = profile(002);
            // 情報を表示(今回はID 002の情報)
            out.println(Arrays.toString(IDdata));
            
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
