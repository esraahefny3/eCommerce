/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.admin;

import DTOS.Order;
import Daos.OrderDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.AdminUtilities;

/**
 *
 * @author 3alilio
 */
@WebServlet(name = "AdminOrders", urlPatterns = {"/AdminOrders"})
public class AdminOrders extends HttpServlet {

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
        
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
            ArrayList<String> formatted_date = new ArrayList<>();
            String userID = request.getParameter("userId");
            System.out.println("Hllo from adminorders Dervlet " + userID);
            OrderDao odao = new OrderDao();
            RequestDispatcher rd;
            if(userID==null || userID.isEmpty())
            {   
                rd = request.getRequestDispatcher("admin_orders.jsp");
                ArrayList<Order> orders_list = odao.selectAll();
                for(Order temp: orders_list)
                {
                    String element_date =sdf.format(temp.getOrderDate());
                    formatted_date.add(element_date);
                }
                request.setAttribute("orders_list", orders_list);
                request.setAttribute("formatted_date", formatted_date);
            }else{
                Order userOrders = new Order();
                userOrders.setUserId(Integer.parseInt(userID));
                ArrayList<Order> orders_list = odao.selectAllUserOrders(userOrders);
                for(Order temp: orders_list)
                {
                    String element_date =sdf.format(temp.getOrderDate());
                    formatted_date.add(element_date);
                }
                request.setAttribute("orders_list", orders_list);
                request.setAttribute("formatted_date", formatted_date);
                rd = request.getRequestDispatcher("admin_orders.jsp");
            }
            rd.include(request, response);
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
