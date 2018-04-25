/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.users;

import DTOS.Product;
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
@WebServlet(name = "ProceedToCheckout", urlPatterns = {"/proceedToCheckout"})
public class ProceedToCheckout extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession() != null) {
            if (request.getSession().getAttribute("user") != null) {

                HashMap<Integer, Integer> quantities = new HashMap<Integer, Integer>();
                //prod id,quantity
                HashMap<Integer, Product> cart = (HashMap<Integer, Product>) request.getSession().getAttribute("cart");
                if ((cart != null)&&(cart.size()>0)) {
                    for (Map.Entry<Integer, Product> entry : cart.entrySet()) 
                    {
                        Integer key = entry.getKey();
                        Product p = entry.getValue();
                        if (request.getParameter(Integer.toString(key)) != null) {
                            quantities.put(key, Integer.parseInt(request.getParameter(Integer.toString(key))));
                            p.setRequested_quantity(Integer.parseInt(request.getParameter(Integer.toString(key))));
                            cart.put(key, p);
                        }
                    }
                    //response.sendRedirect("./checkout1.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("./checkout1.jsp");
                rd.forward(request, response);
                }
                else
                {
                    //empty cart
                    String error="Your cart is empty!.";
                     response.sendRedirect(request.getHeader("Referer") + "?error_modal="+error);
                }

                
            } else {
                //login first
                response.sendRedirect(request.getHeader("Referer") + "?wrongEmail=");
            }
        } else {
            //error page
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
