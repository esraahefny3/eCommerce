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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HeshamMuhammed
 */
public class GetProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("name");
        Category category = new Category();
        category.setId(Integer.parseInt(id));
        ArrayList<Product> products = new ArrayList<>();
        ProductDao productDao = new ProductDao();
        products = productDao.selectAllCategoryProducts(category);
        request.setAttribute("Object", products);

        CategoryDao categoryDao = new CategoryDao();
        Category getCategory = new Category();
        getCategory = categoryDao.select(category);
        request.setAttribute("Cat", getCategory);
        if(getCategory == null){
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("404.jsp");
        requestDispatcher.forward(request, response);
        }else{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category.jsp");
        requestDispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
