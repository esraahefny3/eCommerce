/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.admin;

import DTOS.Product;
import Daos.ProductDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Nehal
 */
@WebServlet(name = "editProduct", urlPatterns = {"/admin/editProduct"})
@MultipartConfig ( maxFileSize = Long.MAX_VALUE)

public class editProduct extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          InputStream inputStream = null;
        System.err.println("nehaaaal");
        int ido = Integer.parseInt(request.getParameter("idpu"));
        String pName = request.getParameter("productdu");
        int quantity = Integer.parseInt(request.getParameter("quantitydu"));
        String Comp = request.getParameter("companydu");
        String desc = request.getParameter("Descriptiondu");
        double price = Double.parseDouble(request.getParameter("pricedu"));

        Part filePart = request.getPart("editfile");
        if (filePart != null) {

            // obtains input stream of the upload file
            System.err.println(filePart.getInputStream());
            inputStream = filePart.getInputStream();
        }

        System.out.println("id of product:" + ido);
        ProductDao prodDao = new ProductDao();

        Product c = new Product();
        c.setName(pName);
        c.setId(ido);
        c.setCompanyName(Comp);
        c.setDescription(desc);
        c.setQuantity(quantity);
        c.setPrice(price);

        if (filePart.getSize() > 0) {
            System.err.println("d5llll");
            // fetches input stream of the upload file for the blob column
            prodDao.update(c, inputStream);
        } else {
            prodDao.update(c);
        }
             //System.err.println("catId=:"+request.getParameter("catId"));
           response.sendRedirect("../adminProducts?categoryId="+request.getParameter("cateId"));
  
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
