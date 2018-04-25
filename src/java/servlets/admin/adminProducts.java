/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.admin;

import DTOS.Category;
import DTOS.Product;
import Daos.ProductDao;
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
 * @author Nehal
 */
@WebServlet(name = "adminProducts", urlPatterns = {"/adminProducts"})
public class adminProducts extends HttpServlet {

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
        String categoryId = request.getParameter("categoryId");
            System.out.println("Hllo from adminorders products for category no: " + categoryId);
            ProductDao prodDao =new  ProductDao();
             
            RequestDispatcher rd;
            if(categoryId==null || categoryId.isEmpty())
            {   
                rd = request.getRequestDispatcher("admin_products.jsp");
                ArrayList<Product> proList=prodDao.selectAll();
             
                request.setAttribute("product_list", proList);
            }else{
                Category category=new Category(); 
                category.setId(Integer.parseInt(categoryId));
                ArrayList<Product> proList=prodDao.selectAllCategoryProducts(category);
                  for (Product p : proList)
        System.out.println(p.getCompanyName()+ " "+p.getName()+p.getDescription()+p.getPrice()+p.getQuantity()+p.getPostedDate());
        
                request.setAttribute("product_list", proList);
                rd = request.getRequestDispatcher("admin_products.jsp");
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
