package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ログイン情報を確認するサーブレット 不備がなければ直前に閲覧していたページに遷移する 不備があればlogin.jspに遷移する
 */

@WebServlet(name = "loginCheck", urlPatterns = {"/loginCheck"})
public class loginCheck extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        HttpSession session = request.getSession();

        try (PrintWriter out = response.getWriter()) {

            // 文字コードをUTF-8に
            request.setCharacterEncoding("UTF-8");
            String acCheck = request.getParameter("ac");

            // 不正アクセスチェック
            if (acCheck.equals("null") || (Integer) session.getAttribute("ac") != Integer.parseInt(acCheck)) {
                throw new Exception("不正なアクセスです");

            }

            // 入力情報を変数へ
            String strName = request.getParameter("name");
            String strPass = request.getParameter("pass");

            // 
            UserDataBeans ud = new UserDataBeans();
            ud.setName(strName);
            ud.setPassword(strPass);

            //UserDataDTOにマッピング
            UserDataDTO udd = new UserDataDTO();
            ud.toDTOMapping(udd);

            //ユーザー情報を取得
            UserDataDTO resultUDD = UserDataDAO.getInstance().search(udd);

            //アクセスセッション破棄
            session.removeAttribute("ac");

            //ログイン後の直前ページの情報を取得
            String returnURL = (String) session.getAttribute("returnURL");

            //DBから登録されている情報と入力の値があっているか確認 + ログインorアウト処理 + 移行ページ分岐
            if (strName.equals(resultUDD.getName()) && strPass.equals(resultUDD.getPassword())) {
                session.setAttribute("login", "in");    //セッションのログイン状態
                session.setAttribute("welcomeUDD", resultUDD);   //各ページでユーザー名を表示するために情報をセッションに格納
                //直前ページへ
                request.getRequestDispatcher("/" + returnURL + ".jsp").forward(request, response);
            } else {
                session.setAttribute("login", null);    //ログアウト状態
                session.removeAttribute("welcomeUDD");   //ユーザー名を表示するセッションを削除
                //ログインページへ
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
        } catch (Exception ex) {
            Logger.getLogger(loginCheck.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(loginCheck.class.getName()).log(Level.SEVERE, null, ex);
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
