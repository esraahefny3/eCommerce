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
import java.time.Instant;

import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.Integer;
import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author esraa
 */
@WebServlet(name = "SubmitOrder", urlPatterns = {"/SubmitOrder"})
public class SubmitOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        if (request.getSession() != null) 
        { 
           
            if ((request.getSession().getAttribute("user") != null)&&(request.getParameter("total")!=null)&&(request.getSession().getAttribute("cart")!=null))
            { 
                HashMap<Integer, Product> map = (HashMap<Integer, Product>) (request.getSession().getAttribute("cart"));
            //    User u=(User) request.getSession().getAttribute("user");
             UserDao ud=new UserDao();
             User u=ud.select( (User)request.getSession().getAttribute("user"));
                if (u.getCredit()>=Double.parseDouble(request.getParameter("total")))
                {   
                    System.err.println("totalnowww="+Double.parseDouble(request.getParameter("total")));
                    OrderDao od = new OrderDao();
                    Date d = new Date(System.currentTimeMillis());
                    Order temp = new Order(1,u.getId(), new Date(System.currentTimeMillis()), (String) request.getSession().getAttribute("orderAddress"));//1 y3ny checkedout
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
                            if(value.getAvailable()>0)
                            {
                                if(opd.insertOrderProduct(value, value.getAvailable(), createdOrder)==true)
                                {
                                    //hro7 aall l quantity bta3t l product fl product nafso
                                    ProductDao pdao=new ProductDao();
                                    value.setQuantity(value.getQuantity()-value.getAvailable());
                                    pdao.update(value);
                                  
                                }
                            }
                           // else hytl3 message mn l awel asln anna hnsubmit l available bs
                        }
                          u.setCredit(u.getCredit()-Double.parseDouble(request.getParameter("total")));
                                    (new UserDao()).update(u);
                        //afdy l cart b2aa
                        map.clear();
                         request.getSession().removeAttribute("orderAddress");
                         String done="The available product have successfully requested..";
                         response.sendRedirect(request.getHeader("Referer") + "?done_modal="+done);
              
                    }
                }
                else 
                {
                    //have no credit error
                    System.err.println("have no credit");
                    //empty cart
                    String error="You don`t have enough credit!.";
                     response.sendRedirect(request.getHeader("Referer") + "?error_modal="+error);
              
                   
                }
            } 
            else 
            {
                //login first
            }
          //  response.sendRedirect("./GetHome");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
