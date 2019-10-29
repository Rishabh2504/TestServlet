/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreateTable;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author c3
 */
@WebServlet(name = "ColumnInfo", urlPatterns = {"/ColumnInfo"})
public class ColumnInfo extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session=request.getSession();
            session.setAttribute("tname",request.getParameter("tname"));
            session.setAttribute("Column",request.getParameter("Column"));
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ColumnInfo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>ADD COLUMN INFO</h2>");
            out.println("<form action='CreateQuery' method='get'>");
            int nc=Integer.parseInt(request.getParameter("Column"));
            for(int i=1;i<=nc;i++){
                out.println("COLUMN " + i + ":<br><br>");
                out.println("Name: <input type='text' name='column" + i + "name'><br><br>");
                out.println("Type: <select name='column" + i + "type'>");
                out.println("<option value='varchar'>Varchar</option>");
                out.println("<option value='int'>Int</option>");
                out.println("</select><br><br>");
                out.println("Length: <input type='number' min='1' name='column" + i + "length'><br><br>");
                out.println("Primarykey<input type='radio' name='pKey' value='column" + i +"'><br><br><br>");
            }
            out.println("<input type='submit' value='GO'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
