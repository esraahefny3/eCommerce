/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.users;

import DTOS.Card;
import DTOS.User;
import Daos.CardDao;
import Daos.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 3alilio
 */
@WebServlet(name = "RechargeCredit", urlPatterns = {"/RechargeCredit"})
public class RechargeCredit extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

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
               response.sendRedirect("customer-account.jsp");

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
        String code = request.getParameter("code");
        PrintWriter out = response.getWriter();
        CardDao cdao = new CardDao();
        Card temp = new Card();
        temp.setCode(code);
        temp = cdao.select(temp);
        UserDao udao = new UserDao();
        if(temp.getUser_id()==0 && temp.getCharged()==0 && code.equals(temp.getCode()))
        {   
           User user = (User) request.getSession().getAttribute("user");
           temp.setCharged(1);
           temp.setUser_id(user.getId());
           cdao.update(temp);
           
           int no_cards = user.getNoOfUsedCards()+1;
           if((no_cards%3)==0)
           {
               user.setNoOfUsedCards(no_cards);
               user.setCredit(user.getCredit()+temp.getValue()+50);
               udao.update(user);
               request.getSession().setAttribute("user", user);
               request.setAttribute("check", 4);
           }
           else{
               user.setNoOfUsedCards(user.getNoOfUsedCards()+1);
               user.setCredit(user.getCredit()+temp.getValue());
               udao.update(user);
               request.getSession().setAttribute("user", user);
               request.setAttribute("check", 1);
           }
           
        }
        else if (temp.getCharged()==1){
                   request.setAttribute("check", 2);
        }
        else{
            request.setAttribute("check", 3);
        }
        RequestDispatcher rd = request.getRequestDispatcher("customer-account.jsp");
        rd.forward(request, response);
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
