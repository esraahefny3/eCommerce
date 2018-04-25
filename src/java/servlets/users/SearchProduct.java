/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.users;

import DTOS.Category;
import DTOS.Product;
import Daos.CategoryDao;
import Daos.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HeshamMuhammed
 */
@WebServlet(name = "searchProduct", urlPatterns = {"/SearchProduct"})
public class SearchProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String search = request.getParameter("getsearch");
        String priceLow = request.getParameter("pricelow");
        String priceHigh = request.getParameter("pricehigh");
        ProductDao pdao = new ProductDao();
        RequestDispatcher rd = request.getRequestDispatcher("category.jsp");
        if (name == null || name.isEmpty()) {
            if (priceLow == null || priceLow.isEmpty()) {
                ArrayList<Product> product_list = pdao.searchByName(search);
                request.setAttribute("Object", product_list);
                request.setAttribute("name_search", search);
            } else {
                if (Integer.parseInt(priceLow) <= Integer.parseInt(priceHigh)) {

                    ArrayList<Product> product_list = pdao.searchByPrice(search, Integer.parseInt(priceLow), Integer.parseInt(priceHigh));
                    request.setAttribute("Object", product_list);
                    request.setAttribute("name_search", search);
                    request.setAttribute("price_low", priceLow);
                    request.setAttribute("price_high", priceHigh);

                } else {
                    request.setAttribute("name_search", search);
                    request.setAttribute("pricevalid", false);
                }

            }
        } else {
            if (priceLow == null || priceLow.isEmpty()) {
                Category cat = new Category();
                CategoryDao cdao = new CategoryDao();
                cat.setId(Integer.parseInt(name));
                cat = cdao.select(cat);
                ArrayList<Product> product_list = pdao.searchByCategoray(cat, search);
               product_list.forEach((t) -> {
               });
                request.setAttribute("Object", product_list);
                request.setAttribute("name_search", search);
                request.setAttribute("Cat", cat);

            } else {
                if (Integer.parseInt(priceLow) <= Integer.parseInt(priceHigh)) {
                    
                    Category cat = new Category();
                CategoryDao cdao = new CategoryDao();
                cat.setId(Integer.parseInt(name));
                cat = cdao.select(cat);
                ArrayList<Product> product_list = pdao.searchByPriceCategory(search, Integer.parseInt(priceLow), Integer.parseInt(priceHigh), cat);
                product_list.forEach((t) -> {
                });
                request.setAttribute("Object", product_list);
                request.setAttribute("name_search", search);
                request.setAttribute("Cat", cat);
                request.setAttribute("price_low", priceLow);
                request.setAttribute("price_high", priceHigh);

                } else {
                    Category cat = new Category();
                    CategoryDao cdao = new CategoryDao();
                    cat.setId(Integer.parseInt(name));
                    cat = cdao.select(cat);
                    request.setAttribute("name_search", search);
                    request.setAttribute("pricevalid", false);
                    request.setAttribute("Cat", cat);
                }

            }

        }
        rd.include(request, response);
          
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                  
    }

}
