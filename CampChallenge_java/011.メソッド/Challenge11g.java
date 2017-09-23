
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Challenge11g", urlPatterns = {"/Challenge11g"})
public class Challenge11g extends HttpServlet {

    // 3人分のプロフィール配列を表示 入ってない情報はnullを入れる
    String[] prof1 = {"相田", "1月1日", "愛知県"};
    String[] prof2 = {"飯田", "2月2日", null};
    String[] prof3 = {"宇井", "3月3日", "ウクライナ"};
    // 配列allprofに3人分のプロフィール配列を収納
    String[][] allprof = {prof1, prof2, prof3};

    // 引数で渡されたIDの情報を戻り値として返すメソッド
    String[] profile(int ID) {
        return allprof[ID];
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 文字コードをUTF-8に
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            // 3回ループ
            for (int ID = 0; ID < 3; ID++) {
                // allprofileに格納
                String[] allprofile = profile(ID);

                // 情報にnullが入ってる場合は飛ばす
                for (int i = 0; i < 3; i++) {
                    if (allprofile[i] == null) {
                        continue;
                    }

                    // nullじゃなければ普通に表示
                    out.println(allprofile[i]);

                }

                // 一人分の表示毎に改行
                out.print("<br>");

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
