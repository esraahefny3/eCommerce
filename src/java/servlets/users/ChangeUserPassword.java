/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.users;

import DTOS.User;
import Daos.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HeshamMuhammed
 */
@WebServlet(name = "changeUserPassword", urlPatterns = {"/ChangeUserPassword"})
public class ChangeUserPassword extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("customer-account.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String old_password = request.getParameter("old_password");
        String new_password1 = request.getParameter("password1");
        String new_password2 = request.getParameter("password2");
        
        User user_temp = (User) request.getSession().getAttribute("user");
        UserDao udao = new UserDao();

//        out.print(user_temp.getFullName());
//        out.print(user_temp.getPassword());
//        out.print(user_temp.getCountry());
        RequestDispatcher rd = request.getRequestDispatcher("customer-account.jsp");
        if (new_password1.equals(new_password2) && old_password.equals(user_temp.getPassword())) {
            User utemp = user_temp;
            utemp.setPassword(new_password1);
            if (udao.update(user_temp)) {
                request.setAttribute("passchanged", true);
                user_temp = utemp;
                request.getSession().setAttribute("user", user_temp);
            } else {
                request.setAttribute("passchanged", false);
            }
            
        } else {
            request.setAttribute("passchanged", false);
        }
        rd.include(request, response);
    }
}
