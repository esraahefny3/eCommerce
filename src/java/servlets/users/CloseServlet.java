/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.users;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esraa
 */
@WebServlet(name = "CloseServlet", urlPatterns = {"/closeServlet"})
public class CloseServlet extends HttpServlet {

   @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getHeader("Referer").contains("?wrongEmail")==true)
                     {
                      response.sendRedirect((request.getHeader("Referer").split("\\?wrongEmail"))[0]);
                     }
                    else if(request.getHeader("Referer").contains("&wrongEmail")==true)
                    {
                          response.sendRedirect((request.getHeader("Referer").split("&wrongEmail"))[0]);
                    
                    }
                    else
                    {
                          response.sendRedirect(request.getHeader("Referer"));
                    }
    }

  
   @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
