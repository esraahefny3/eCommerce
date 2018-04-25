/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.users;

import DTOS.Category;
import DTOS.Order;
import DTOS.Product;
import DTOS.User;
import Daos.OrderDao;
import Daos.OrderProductDao;
import Daos.UserDao;
import Daos.UserInterestDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "Login", urlPatterns = {"/users/login"})
public class Login extends HttpServlet {

   
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
          HttpSession session = request.getSession(false);
          //==============================
          
            String email = request.getParameter("email");
            String password = request.getParameter("pass");
            UserDao udao = new UserDao();
            User temp = new User();
            temp.setEmail(email);
            temp.setPassword(password);
            User client = udao.select(temp);
            RequestDispatcher rd ;
            if(client==null)
            {  //invalid user
                if(session !=null)
                {
                 
                    if(request.getHeader("Referer").contains("?wrongEmail")==true)
                     {
                      response.sendRedirect((request.getHeader("Referer").split("\\?wrongEmail"))[0]+"?wrongEmail="+email);
                     }
                    else if(request.getHeader("Referer").contains("&wrongEmail")==true)
                    {
                          response.sendRedirect((request.getHeader("Referer").split("&wrongEmail"))[0]+"&wrongEmail="+email);
                    
                    }
                    else
                    {
                        if(request.getHeader("Referer").contains("?")==false)
                        {
                            response.sendRedirect(request.getHeader("Referer")+"?wrongEmail="+email);
                        }
                        else
                        {
                               response.sendRedirect(request.getHeader("Referer")+"&wrongEmail="+email);
                       
                        }
                    }
                }
              }
            else{ //valid user
                  
                    if(session!=null)
                    {
                    session.setAttribute("user", client);
                    Order order=new Order();
                    order.setUserId(client.getId());
                    // session.setAttribute("cart",getLastUncheckedProducts);
                    if(session.getAttribute("cart")!=null)
                        {
                            HashMap<Integer, Product> cartMap=(HashMap<Integer, Product>)session.getAttribute("cart");
                           HashMap<Integer, Product>  lastCart=getLastUncheckedProducts(order);
                            if(lastCart!=null)
                            {
                                cartMap.putAll(lastCart);
                            }
                           
                            
                        }
                        UserInterestDao uidao=new UserInterestDao();
                        ArrayList<Category> uicat=uidao.selectAllUserInterests(client);
                        HashMap<Integer, Category> ui=new HashMap<Integer, Category>();
                       if((uicat!=null)&&(uicat.size()>0))
                       {
                            for(int i=0;i<uicat.size();i++)
                            {
                                ui.put(uicat.get(i).getId(), uicat.get(i));
                            }

                             session.setAttribute("user_Interestes", ui);
                        }
                    }
                    
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
          
          
      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public HashMap<Integer, Product> getLastUncheckedProducts(Order order)
    {
        OrderDao od=new OrderDao();
        Order uo= od.selectLastUncheckedOrder(order);
        HashMap<Integer, Product>cart=null;
       if(uo!=null)
       {
             OrderProductDao opd=new OrderProductDao();
        cart= opd.selectAllOrderProducts(uo);
       
           od.delete(uo);
       }//deleteeee
        return cart;
        
    }

}
