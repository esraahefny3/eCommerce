/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.users;

import DTOS.Category;
import DTOS.User;
import Daos.UserDao;
import Daos.UserInterestDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 3alilio
 */
@WebServlet(name = "signUp", urlPatterns = {"/users/signUp"})
public class SignUp extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("name");
        String userMail = request.getParameter("email");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        String country = request.getParameter("country");

        UserDao udao = new UserDao();
        User temp=new User();
        temp.setEmail(userMail);
        if(udao.selectUserbyEmail(temp)==null)//user not exist
        {
            User newClient = new User(userName, password, 50, address, telephone, userMail);
            newClient.setCountry(country);

           if(udao.insert(newClient)==true)//ok registred w ro7 ll home
           {
                //7ot l interests
              temp=udao.selectUserbyEmail(temp);//h select l user 34an a7oto 3la l session
               
                String[]interestsList= request.getParameterValues("interestsList");
                 HttpSession session = request.getSession(false);
                 
                
               if(interestsList!=null)
               {
                   UserInterestDao uiDao=new UserInterestDao();
                   ArrayList<Category> interestsArrayList=new ArrayList<>();
                   for(int i=0;i<interestsList.length;i++)
                    {
                        Category c=new Category();
                        c.setId(Integer.parseInt(interestsList[i]));
                        interestsArrayList.add(c);
                    }
                     uiDao.insertUserInterests(temp, interestsArrayList);
                      if(session!=null)
                        {
                            HashMap<Integer, Category> ui=new HashMap<Integer, Category>();
                            if((interestsArrayList!=null)&&(interestsArrayList.size()>0))
                             {
                                 for(int i=0;i<interestsArrayList.size();i++)
                                 {
                                     ui.put(interestsArrayList.get(i).getId(), interestsArrayList.get(i));
                                 }

                                  session.setAttribute("user_Interestes", ui);
                            }
                        }
               }
               //====================
                 if(session!=null)
                 {
                     session.setAttribute("user", temp);
                 }
                  response.sendRedirect("../GetHome");
           }
           else 
           {
                 response.sendRedirect("../register.jsp?error=0");//0 means database server error
           }
        }
        else//user exist
        {
             response.sendRedirect("../register.jsp?error=1");//1 means user exist
        }
    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
