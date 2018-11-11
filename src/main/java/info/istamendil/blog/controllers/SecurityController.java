package info.istamendil.blog.controllers;

import info.istamendil.blog.ViewAndAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Alexander Ferenets (aka Istamendil) – http://istamendil.info
 */
public class SecurityController extends AbstractController{
  public ViewAndAttributes loginAction(ViewAndAttributes vaa, HttpServletRequest req){
    vaa.setView("login");
    return vaa;
  }
  public ViewAndAttributes logoutAction(ViewAndAttributes vaa, HttpServletRequest req){
    vaa.setView("index");
    vaa.addAttribute("name", "world");
    return vaa;
  }
}
