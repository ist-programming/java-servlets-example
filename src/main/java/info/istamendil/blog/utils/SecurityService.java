package info.istamendil.blog.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander Ferenets (aka Istamendil) – http://istamendil.info
 */
public class SecurityService {
  public static boolean isUser(HttpServletRequest req){
    if(req.getSession().getAttribute("username") != null
            && !((String)req.getSession().getAttribute("username")).isEmpty()){
      return true;
    }
    else{
      return false;
    }
  }
  public static boolean isGuest(HttpServletRequest req){
    if(req.getSession().getAttribute("username") == null
            || ((String)req.getSession().getAttribute("username")).isEmpty()){
      return true;
    }
    else{
      return false;
    }
  }
  public static String getUsername(HttpServletRequest req){
    if(SecurityService.isUser(req)){
      return (String)req.getSession().getAttribute("username");
    }
    else{
      return null;
    }
  }
  public static boolean authorize(HttpServletRequest req, HttpServletResponse resp){
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    if(SecurityService.checkUser(username, password)){
      req.getSession().setAttribute("username", username);
      return true;
    }
    else{
      return false;
    }
  }
  public static void logout(HttpServletRequest req){
    req.getSession().removeAttribute("username");
  }
  public static boolean checkUser(String username, String password){
    if(username.equals("admin") && password.equals("admin")){
      return true;
    }
    else{
      return false;
    }
  }
}
