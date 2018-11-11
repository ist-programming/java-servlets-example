package info.istamendil.blog.controllers;

import info.istamendil.blog.ViewAndAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Alexander Ferenets (aka Istamendil) – http://istamendil.info
 */
public class DefaultController extends AbstractController{
  public ViewAndAttributes indexAction(ViewAndAttributes vaa, HttpServletRequest req){
    vaa.setView("index");
    vaa.addAttribute("name", req.getParameter("hello"));
    return vaa;
  }

}
