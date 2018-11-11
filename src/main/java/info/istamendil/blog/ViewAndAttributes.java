package info.istamendil.blog;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alexander Ferenets (aka Istamendil) – http://istamendil.info
 */
public class ViewAndAttributes {
  private String view;
  private Map<String, Object> attributes;

  public ViewAndAttributes() {
    this.view = "";
    this.attributes = new HashMap<String, Object>();    
  }
  public ViewAndAttributes(String view, Map<String, Object> attributes) {
    this.view = view;
    this.attributes = attributes;
  }
  
  //ToDo: Add more?
  

  public String getView() {
    return view;
  }

  public void setView(String view) {
    this.view = view;
  }

  public Map<String, Object> getAttributes() {
    return attributes;
  }

  public void setAttributes(Map<String, Object> attributes) {
    this.attributes = attributes;
  }
  public void addAttribute(String name, Object attribute){
    this.attributes.put(name, attribute);
  }
  
}
