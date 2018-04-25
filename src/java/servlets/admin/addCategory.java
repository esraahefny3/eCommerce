/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.admin;

import DTOS.Category;
import DTOS.User;
import Daos.CategoryDao;
import Daos.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nehal
 */
@WebServlet(name = "addCategory", urlPatterns = {"/admin/addCategory"})
public class addCategory extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
          //==============================
          
            String Categorym = request.getParameter("category");
            String description = request.getParameter("description");
            //System.out.println(Category + description);
             CategoryDao catDao=new CategoryDao();
             Category c=new Category();
            c.setName(Categorym);
            c.setDescription(description);
            
            if(catDao.insert(c)==true)
            {
                 ArrayList<Category> categoriesList=catDao.selectAll();
                if(categoriesList!=null)
                {
                     request.getServletContext().setAttribute("categoriesList", categoriesList);
                }
            }
            
            
           response.sendRedirect("../admin_home.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
