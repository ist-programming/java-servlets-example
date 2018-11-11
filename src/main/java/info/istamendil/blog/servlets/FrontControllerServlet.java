package info.istamendil.blog.servlets;

import info.istamendil.blog.ViewAndAttributes;
import info.istamendil.blog.controllers.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet("/")
public class FrontControllerServlet extends HttpServlet {

  protected static final String TEMPLATE_PATH = "/WEB-INF/jsp/";
  protected static final String TEMPLATE_EXTENSION = "jsp";

  protected static final String DEFAULT_CONTROLLER = "default";
  protected static final String DEFAULT_ACTION = "index";
  protected Map<String, Controller> controllers;

  @Override
  public void init() throws ServletException {
    super.init();
    initControllers();
  }

  protected void initControllers() {
    controllers = new HashMap<>();
    controllers.put("default", new DefaultController());
    controllers.put("security", new SecurityController());
  }

  protected boolean checkPath(Path requestPath, String controllerName) {
    String cn;
    if (requestPath.getName(0).toString().equals("")) {
      cn = DEFAULT_CONTROLLER;
    } else {
      cn = requestPath.getName(0).toString();
    }
    return cn.equals(controllerName);
  }

  protected void loadTemplate(ViewAndAttributes vaa, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    for (String name : vaa.getAttributes().keySet()) {
      req.setAttribute(name, vaa.getAttributes().get(name));
    }
    req.getRequestDispatcher(TEMPLATE_PATH + vaa.getView() + "." + TEMPLATE_EXTENSION)
            .forward(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Path requestPath = Paths.get(req.getServletPath().substring(1));
    Path contextPath = Paths.get(req.getServletContext().getRealPath(""));
    Path filePath = contextPath.resolve(requestPath);
    File file = filePath.toFile();

    if (file.exists() && file.canRead() && file.isFile()) {
      resp.setContentType(Files.probeContentType(filePath));
      FileInputStream in = new FileInputStream(file);
      byte[] buffer = new byte[8 * 1024];
      int len;
      while ((len = in.read(buffer)) > 0) {
        resp.getOutputStream().write(buffer, 0, len);
      }
    } else {
      for (String controllerPath : controllers.keySet()) {
        if (checkPath(requestPath, controllerPath)) {
          Controller currentController = controllers.get(controllerPath);
          String action = requestPath.getNameCount() < 2 ? "" : requestPath.getName(1).toString();
          if (action.equals("")) {
            action = "index";
          }
          action = action + "Action";
          try {
            ViewAndAttributes vaa = new ViewAndAttributes();
            Method method = currentController.getClass().getMethod(action, ViewAndAttributes.class, HttpServletRequest.class);
            vaa = (ViewAndAttributes) method.invoke(currentController, vaa, req);
            //ToDo: check if action give us what we need
            loadTemplate(vaa, req, resp);
            //ToDo: Rearrange catch reactions?
          } catch (SecurityException | IllegalAccessException | InvocationTargetException e) {
            throw new ServletException("Bad controller action", e);
          } catch (NoSuchMethodException e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
          } catch (IllegalArgumentException ex) {
            //ToDo: make better reaction
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
          }
          break;
        }
      }
    }
  }

}
