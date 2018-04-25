/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.users;

import DTOS.Product;
import Daos.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esraa
 */
@WebServlet(name = "CheckCart", urlPatterns = {"/reviewCart"})
public class ReviewCart extends HttpServlet {

   
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.err.println("hereeeeeeeeee");
        if (request.getSession() != null) {
            if (request.getSession().getAttribute("cart") != null) {
                double total = 0;
                ProductDao pdao = new ProductDao();
                int c=0;
                HashMap<Integer, Product> cart = (HashMap<Integer, Product>) request.getSession().getAttribute("cart");
                for (Map.Entry<Integer, Product> entry : cart.entrySet()) {
                    System.err.println("c="+c++);
                    Integer key = entry.getKey();
                    Product pnew = new Product();
                    pnew.setId(key.intValue());
                    pnew = pdao.select(pnew);
                    if (pnew != null)
                    {
                        pnew.setRequested_quantity(entry.getValue().getRequested_quantity());
                       
                        
                        if (pnew.getQuantity() < pnew.getRequested_quantity()) 
                        {
                            pnew.setAvailable(pnew.getQuantity());
                            if(pnew.getAvailable()>0)
                             total+=pnew.getPrice()*pnew.getQuantity();
                          } 
                        else 
                        {
                            pnew.setAvailable(pnew.getRequested_quantity());
                            if(pnew.getAvailable()>0)
                            total+=pnew.getPrice()*pnew.getRequested_quantity();
                        }
                      

                        cart.put(key, pnew);
                    }

                }
               // request.getSession().setAttribute("cart", cart);
                request.setAttribute("total", total);
                if(request.getSession().getAttribute("orderAddress")==null)
                {
                    request.getSession().setAttribute("orderAddress", request.getParameter("addressArea"));
                }
                 RequestDispatcher rd=request.getRequestDispatcher("./checkout2.jsp");
                 rd.forward(request, response);
            }

        }
       

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
