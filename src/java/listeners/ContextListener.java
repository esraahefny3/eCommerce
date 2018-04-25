/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import DTOS.Category;
import Daos.CategoryDao;
import java.util.ArrayList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author esraa
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
         CategoryDao catDao=new CategoryDao();
        ArrayList<Category> categoriesList=catDao.selectAll();
        if(categoriesList!=null)
        {
             sce.getServletContext().setAttribute("categoriesList", categoriesList);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.err.println("destroyed");
    }
}
