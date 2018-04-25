/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.users;

import DTOS.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esraa
 */
@WebServlet(name = "RmoveFromCart", urlPatterns = {"/RemoveFromCart"})
public class RemoveFromCart extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession()!=null)
        {
            if(request.getSession().getAttribute("cart")!=null)
            {   if(request.getParameter("pId")!=null)
                {  
                    ((HashMap<Integer, Product>)(request.getSession().getAttribute("cart"))).remove(Integer.parseInt(request.getParameter("pId")));
                }
            }
           HashMap<Integer, Product> map= (HashMap<Integer, Product>)(request.getSession().getAttribute("cart"));
            if(map.size()>0)
            {
                String referer = request.getHeader("Referer");
                     // handle empty referer.....
            response.sendRedirect(referer);
            //response.sendRedirect("./basket.jsp");
            }
            else
            {
                 response.sendRedirect("./GetHome");
            }
        }
   
    }
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
