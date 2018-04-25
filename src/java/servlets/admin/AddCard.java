/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.admin;
import DTOS.Card;
import Daos.CardDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "AddCard", urlPatterns = {"/AddCard"})
public class AddCard extends HttpServlet {

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
        
        CardDao cdao = new CardDao();
        RequestDispatcher rd = request.getRequestDispatcher("admin_card.jsp");
        ArrayList<Card> cards_list = cdao.selectAll();
        request.setAttribute("cards_list", cards_list);
        rd.include(request, response);
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
        String value = request.getParameter("value");
        
        CardDao cdao = new CardDao();
        
        Card card_temp = new Card(Integer.parseInt(value), code, 0);
        if(cdao.insert(card_temp))
        {
           request.setAttribute("CheckAdd", true);
        }
        else{
             request.setAttribute("CheckAdd", false);
        }
        RequestDispatcher rd = request.getRequestDispatcher("admin_card.jsp");
        ArrayList<Card> cards_list = cdao.selectAll();
        request.setAttribute("cards_list", cards_list);
        rd.include(request, response);
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
