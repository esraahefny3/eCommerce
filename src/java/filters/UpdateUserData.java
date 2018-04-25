/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import DTOS.User;
import Daos.UserDao;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esraa
 */
@WebFilter(filterName = "UpdateUserData", urlPatterns = {"/customer-account.jsp"})
public class UpdateUserData implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public UpdateUserData() {
    }    
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        
        HttpServletResponse res=(HttpServletResponse)response;
        HttpServletRequest req=(HttpServletRequest)request;
        UserDao udao =new UserDao();
        if(req.getSession()!=null)
        {
            User temp =(User) req.getSession().getAttribute("user");
        
        
         User u = udao.select(temp);
         
         req.getSession().setAttribute("user", u);
         
        }
        chain.doFilter(req, res);
        
        
        
         }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
      
  
 
   
    
}
