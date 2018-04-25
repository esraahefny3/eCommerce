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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HeshamMuhammed
 */
public class GetDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("name");
        Product insertProduct = new Product();
        Product returnProduct = new Product();
        insertProduct.setId(Integer.parseInt(id));
        ProductDao productDao = new ProductDao();
        returnProduct = productDao.select(insertProduct);
        request.setAttribute("detailObject", returnProduct);
        if(returnProduct== null || returnProduct.getId()==0){
            response.sendRedirect("404.jsp");
        }else{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("detail.jsp");
        requestDispatcher.forward(request, response);        
        }
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
