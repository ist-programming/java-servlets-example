package info.istamendil.blog.filters;

import info.istamendil.blog.utils.SecurityService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander Ferenets (aka Istamendil) – http://istamendil.info
 */
@WebFilter("/*")
public class SecurityFilter extends HttpFilter {
  
  protected static final String[] securedPaths = new String[]{"/profile", "/admin"};
  

  @Override
  protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
    //Path without context
    String path = req.getRequestURI().substring(getServletContext().getContextPath().length());
    // Check for only some paths
    for(String pathForCheck : SecurityFilter.securedPaths){
      if(path.startsWith(pathForCheck)){
        if (SecurityService.isGuest(req)) {
          req.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
           .forward(req, res);
          return;
        }
      }
    }
    chain.doFilter(req, res);
  }

}
