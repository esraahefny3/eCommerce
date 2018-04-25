/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

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
@WebFilter(filterName = "LoggedIn", urlPatterns = {"/register.jsp"})
public class LoggedIn implements Filter {
    


    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        if(req.getSession()!=null)
        {
            if(req.getSession().getAttribute("user")!=null)
            {
                 HttpServletResponse res=(HttpServletResponse)response;
                 res.sendRedirect("./GetHome");
            }
            else
            {
                chain.doFilter(request, response);
            }
        }
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
    
}
