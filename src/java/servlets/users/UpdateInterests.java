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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esraa
 */
@WebServlet(name = "UpdateInterests", urlPatterns = {"/updateInterests"})
public class UpdateInterests extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //7ot l interests
        if (request.getSession() != null) {
            if (request.getSession().getAttribute("user") != null) {
                UserDao udao = new UserDao();
                User u=(User) request.getSession().getAttribute("user");
                UserInterestDao uidao=new UserInterestDao();
                if(uidao.deleteAllUserInterests(u)==true)
                 { 
                     String[] interestsList = request.getParameterValues("interestsList");
                    if (interestsList != null) {
                        UserInterestDao uiDao = new UserInterestDao();
                        ArrayList<Category> interestsArrayList = new ArrayList<>();
                        for (int i = 0; i < interestsList.length; i++) {
                            Category c = new Category();
                            c.setId(Integer.parseInt(interestsList[i]));
                            interestsArrayList.add(c);
                        }
                        uiDao.insertUserInterests(u, interestsArrayList);
                        if(request.getSession()!=null)
                        {
                            HashMap<Integer, Category> ui=new HashMap<Integer, Category>();
                            if((interestsArrayList!=null)&&(interestsArrayList.size()>0))
                             {
                                 for(int i=0;i<interestsArrayList.size();i++)
                                 {
                                     ui.put(interestsArrayList.get(i).getId(), interestsArrayList.get(i));
                                 }

                                  request.getSession().setAttribute("user_Interestes", ui);
                            }
                        }
                    }
                }//else failed to delete
                //====================
            }
        }
        response.sendRedirect("./customer-account.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
