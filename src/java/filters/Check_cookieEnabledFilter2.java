/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import DTOS.Product;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author esraa
 */
public class Check_cookieEnabledFilter2 implements Filter {
    
     private FilterConfig filterConfig = null;
    
    
     @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
       
        
    }
 
    
     @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
             
           HttpServletRequest req=(HttpServletRequest)request;
           Cookie []c=req.getCookies();
           if(c!=null)
           {
              req.setAttribute("cookieEnabled",true);
              HttpSession session = req.getSession(true);
              if(session.getAttribute("cart")==null)
              {
                  session.setAttribute("cart", new HashMap<Integer, Product>());
              }
               
             //  session.setAttribute("email", "esraahefny3@gmail.com");
           }
           else //cookie disabled 
           {
              req.setAttribute("cookieEnabled",false);
           }
         
           chain.doFilter(req, response);
    }

   
     @Override
    public void destroy() {    
       
    }


   
    
}
