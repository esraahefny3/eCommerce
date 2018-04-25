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
import javax.servlet.http.HttpSession;

/**
 *
 * @author esraa
 */
@WebServlet(name = "MakeSessionServlet", urlPatterns = {"/index"})
public class MakeSessionServlet extends HttpServlet {

   
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if((boolean)request.getAttribute("cookieEnabled")==true)
        {
            //check session and make it if not exist
            HttpSession session = request.getSession(true);
            session.setAttribute("email", "esraahefny3@gmail.com");
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
