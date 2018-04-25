package servlets.users;

import DTOS.User;
import Daos.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "changeUserData", urlPatterns = {"/ChangeUserData"})
public class ChangeUserData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("customer-account.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String fullname = request.getParameter("fullname");
        String job = request.getParameter("job");
        String country = request.getParameter("Country");
        String address = request.getParameter("address");
        String credit = request.getParameter("credit");
        String datee = request.getParameter("date");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String cards = request.getParameter("cards");
        RequestDispatcher rd = request.getRequestDispatcher("customer-account.jsp");
        User user_temp = (User) request.getSession().getAttribute("user");
        user_temp.setFullName(fullname);
        user_temp.setJob(job);
        user_temp.setAddress(address);
        user_temp.setCountry(country);
        user_temp.setEmail(email);
        user_temp.setPhone(phone);
 
        

        UserDao udao = new UserDao();
        if (udao.update(user_temp)) {
            
            request.getSession().setAttribute("user", user_temp);
            request.setAttribute("isupdated", 1);
            rd.include(request, response);
        } else {
            request.setAttribute("isupdated", 2);
            rd.include(request, response);
        }
        
    }
}
