/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.admin;

import DTOS.Category;
import DTOS.Product;
import Daos.CategoryDao;
import Daos.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nehal
 */
@WebServlet(name = "removeProduct", urlPatterns = {"/admin/removeProduct"})
public class removeProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //     HttpSession session = request.getSession(false);
        System.err.println("hnaa");
        int ido = Integer.parseInt(request.getParameter("idp"));
        System.out.println("id of product:" + ido);
        ProductDao prodDao = new ProductDao();
        Product c = new Product();
        c.setId(ido);
        prodDao.delete(c);
        
        System.err.println("catId=:" + request.getParameter("catId"));
        response.sendRedirect("../adminProducts?categoryId=" + request.getParameter("catId"));
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
