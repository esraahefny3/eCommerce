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
import static java.lang.System.out;
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
@WebServlet(name = "categoriesList", urlPatterns = {"/categoriesList"})
public class categoriesList extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
         if ((session!=null)&&(session.getAttribute("categoriesList")!=null))
         {
            CategoryDao catDao=new CategoryDao();
            ArrayList<Category> catList=catDao.selectAll();
              for (Category g : catList)
            System.out.println(g.getDescription()+ g.getName());
            
           //for (Category g : hobbies)
           //out.println(g.getDescription()+ g.getName());
                
            //session.setAttribute("categoriesList", catList);
         }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
