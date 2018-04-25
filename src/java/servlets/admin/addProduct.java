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
import java.sql.Date;
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
@WebServlet(name = "addProduct", urlPatterns = {"/admin/addProduct"})
@MultipartConfig ( maxFileSize = Long.MAX_VALUE)

// upload file's size up to 16MB
public class addProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        InputStream inputStream=null;
         int ido;
        if (request.getParameter("cateid")!= null)
        {
            System.out.println(" not null  "+request.getParameter("cateid"));
            ido =Integer.parseInt( request.getParameter("cateid"));
        }
       else 
        {
           System.out.println(" null henaaa "+request.getParameter("caid"));
          ido =Integer.parseInt( request.getParameter("caid"));
        } 
     //  int ido =Integer.parseInt( request.getParameter("cateid"));
            String pName = request.getParameter("anam");
            int quantity = Integer.parseInt(request.getParameter("aquan"));
            String Comp = request.getParameter("apass");
           String desc = request.getParameter("adesc");
          double price = Double.parseDouble(request.getParameter("aprice"));
          Part filePart = request.getPart("file");
       if (filePart != null) {
        
           // obtains input stream of the upload file
           System.err.println(filePart.getInputStream());
           inputStream = filePart.getInputStream();
        }
       
             ProductDao prodDao =new  ProductDao();
            
             Product c=new Product();
            c.setName(pName);
            c.setCompanyName(Comp);
            c.setDescription(desc);
            c.setQuantity(quantity);
            c.setPrice(price);
            c.setCategoryId(ido);
            c.setPostedDate(new Date(System.currentTimeMillis()));
             if (filePart.getSize()>0) {
                 System.err.println("d5llll");
                // fetches input stream of the upload file for the blob column
                prodDao.insert(c,inputStream);
            }
             else
             {
             prodDao.insert(c);
            }
             
             //System.err.println("catId=:"+request.getParameter("catId"));
            
       if (request.getParameter("categoryId")!= null)
        {
            response.sendRedirect("../adminProducts?categoryId="+request.getParameter("categId"));
  
        }
       else 
        {
           response.sendRedirect("../adminProducts");
  
        } 
          
    }

    /**
     * 
     * 
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
