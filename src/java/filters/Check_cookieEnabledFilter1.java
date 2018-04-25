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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esraa
 */
public class Check_cookieEnabledFilter1 implements Filter {
    
     private FilterConfig filterConfig = null;
    
    
     @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
       
        
    }
 
    
     @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse res=(HttpServletResponse)response;
        HttpServletRequest req=(HttpServletRequest)request;
        Cookie c1= new Cookie("test","ok");
        res.addCookie(c1);
        chain.doFilter(req, res);
       /* RequestDispatcher rd =req.getRequestDispatcher("./userHome.jsp");
        rd.forward(req, res);*/
    }
 
   
     @Override
    public void destroy() {    
       
    }


   
    
}
