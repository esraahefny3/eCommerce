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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esraa
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("pId");
           if(request.getSession().getAttribute("cart")!=null)
           {
               
                Product insertProduct = new Product();
                Product returnProduct = new Product();
                insertProduct.setId(Integer.parseInt(id));
                ProductDao productDao = new ProductDao();
                returnProduct = productDao.select(insertProduct);
               ((HashMap<Integer, Product>)request.getSession().getAttribute("cart")).put(Integer.parseInt(id), returnProduct);
              
               
           }
           String referer=request.getHeader("Referer");
            response.sendRedirect(referer);
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
