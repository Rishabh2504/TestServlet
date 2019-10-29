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
 * @author Rishabh
 */
@WebServlet(name = "CreateQuery", urlPatterns = {"/CreateQuery"})
public class CreateQuery extends HttpServlet {

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
            HttpSession session=request.getSession(false);
            String Name=(String)session.getAttribute("tname");
            int col=Integer.parseInt((String)session.getAttribute("Column"));
            String key=request.getParameter("pKey");
            String query="Create table " + Name + "(<br>";
            
            for(int i=1;i<col;i++){
                String name = request.getParameter("column" + i + "name");
                String type = request.getParameter("column" + i + "type");
                String length = request.getParameter("column" + i + "length");
                query += name + " " + type + "(" + length + ")";
                if(key.equals("column" + i)){
                    query += " " + "primary key,<br>";
                }else{
                    query += ",<br>";
                }
            }
            String name = request.getParameter("column" + col + "name");
            String type = request.getParameter("column" + col + "type");
            String length = request.getParameter("column" + col + "length");
                query += name + " " + type + "(" + length + ")";
                if(key.equals("column" + col)){
                    query += " " + "primary key";
                }
            
            query += " )";
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateQuery</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Query Preview</h1>");
            out.println("<h2>" + query + "</h2>");
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
