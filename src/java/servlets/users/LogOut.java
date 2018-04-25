/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.users;

import DTOS.Order;
import DTOS.Product;
import DTOS.User;
import Daos.OrderDao;
import Daos.OrderProductDao;
import Daos.ProductDao;
import Daos.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "LogOut", urlPatterns = {"/users/logout"})
public class LogOut extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session= request.getSession(false);
        if(session!=null)
        {
            //===============================
            
            if (request.getSession() != null) 
        { 
           
            if ((request.getSession().getAttribute("user") != null)&&(request.getSession().getAttribute("cart")!=null))
            {   HashMap<Integer, Product> map = (HashMap<Integer, Product>) (request.getSession().getAttribute("cart"));
                User u=(User) request.getSession().getAttribute("user");
                OrderDao od = new OrderDao();
                Date d = new Date(System.currentTimeMillis());
                Order temp = new Order(0,u.getId(), new Date(System.currentTimeMillis()), u.getAddress());//0 y3ny uncheckedout
                    if (od.insert(temp) == true)//ok
                    {
                        Order temp2 = new Order();
                        temp2.setUserId(((User) (request.getSession().getAttribute("user"))).getId());
                        Order createdOrder = od.selectRecentCreatedOrder(temp2);
                        OrderProductDao opd = new OrderProductDao();
                        //insert l products b2a
                        for (Map.Entry<Integer, Product> entry : map.entrySet()) {
                            Integer key = entry.getKey();
                            Product value = entry.getValue();
                            opd.insertOrderProduct(value, 1, createdOrder);//1 as default value
                               
                         }
                         
                    }
                }
               
            } 
           
         }
            //================================
            session.removeAttribute("user");
            session.removeAttribute("cart");
            request.getSession().removeAttribute("orderAddress");
        
       
        response.sendRedirect("../GetHome");
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
