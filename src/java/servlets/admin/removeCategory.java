/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.admin;

import DTOS.Category;
import Daos.CategoryDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nehal
 */
@WebServlet(name = "removeCategory", urlPatterns = {"/admin/removeCategory"})
public class removeCategory extends HttpServlet {

    

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
       HttpSession session = request.getSession(false);
          //==============================
          System.err.println("hnaanehaaalremove");
            int ido =Integer.parseInt( request.getParameter("Qp"));
            String Categorym = request.getParameter("categoryQp");
            String description = request.getParameter("categoryDesp");
            //System.out.println(Category + description);
             CategoryDao catDao=new CategoryDao();
             Category c=new Category();
            c.setName(Categorym);
            c.setDescription(description);
            c.setId(ido);
            if(catDao.delete(c)==true)
            {
                 ArrayList<Category> categoriesList=catDao.selectAll();
               
                     request.getServletContext().setAttribute("categoriesList", categoriesList);
                
            }
           response.sendRedirect("../admin_home.jsp");
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
