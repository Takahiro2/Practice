/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Challenge11g", urlPatterns = {"/Challenge11g"})
public class Challenge11g extends HttpServlet {

String[] prof1 = {"相田","1月1日","愛知県"};
String[] prof2 = {"飯田","2月2日",null};
String[] prof3 = {"宇井","3月3日","ウクライナ"};
String[][] allprof = {prof1,prof2,prof3};
String[] profile(int ID){
    return allprof[ID];
}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Challenge11g</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Challenge11g at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            for(int ID = 0;ID < 3;ID++){
                String[] allprofile = profile(ID);
                
                for(int i = 0;i < 3;i++){
                    if(allprofile[i] == null){
                        continue;
                    }
                    out.println(allprofile[i]);
                }
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
