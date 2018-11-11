package info.istamendil.blog.servlets;

import info.istamendil.blog.utils.SecurityService;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander Ferenets (aka Istamendil) – http://istamendil.info
 */
@WebServlet("/login")
public class AuthServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    showForm(req, resp);
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(SecurityService.authorize(req, resp)){
      String redirectURI = getServletContext().getContextPath() + "/profile";
      if(req.getHeader("Referer") != null){
        try{
          URI referer = new URI(req.getHeader("Referer"));
          if(!referer.getPath().equals(getServletContext().getContextPath() + "/login")){
            redirectURI = referer.getPath();
          }
        } catch (URISyntaxException ex) {}
      }
      resp.sendRedirect(redirectURI);
      return;
    }
    showForm(req, resp);
  }
  
  protected void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
       .forward(req, resp);
  }

  
}
