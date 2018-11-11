package info.istamendil.blog.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander Ferenets (aka Istamendil) – http://istamendil.info
 */
@WebServlet("/def")
public class DefaultServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("name", "Hello world!");
    req.getRequestDispatcher("/WEB-INF/jsp/index.jsp")
         .forward(req, resp);
  }
  
}
