package info.istamendil.blog.servlets;

import info.istamendil.blog.utils.SecurityService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander Ferenets (aka Istamendil) – http://istamendil.info
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("username", SecurityService.getUsername(req));
    req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp")
       .forward(req, resp);
  }

  
}
