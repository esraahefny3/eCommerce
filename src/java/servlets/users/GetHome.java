package servlets.users;

import DTOS.Product;
import DTOS.User;
import Daos.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HeshamMuhammed
 */
public class GetHome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = new ArrayList<>();
        ProductDao productDao = new ProductDao();
        products = productDao.selectLatestProducts(6);
        /*for(int i=0;i<products.size();i++)
        {
            Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
            calendar.setTime(products.get(i).getPostedDate());   // assigns calendar to given date 
            calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
            calendar.get(Calendar.MINUTE);        // gets hour in 12h format
            calendar.get(Calendar.HOUR_OF_DAY);       // gets month number, NOTE this is zero based!
            System.out.println("pdate="+calendar.get(Calendar.MINUTE));
        }*/
        request.setAttribute("HomeProducts", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("./home.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
