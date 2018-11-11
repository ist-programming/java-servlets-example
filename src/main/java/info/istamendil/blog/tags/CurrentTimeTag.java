package info.istamendil.blog.tags;

import java.io.IOException;
import java.time.Instant;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Alexander Ferenets (aka Istamendil) – http://istamendil.info
 */
public class CurrentTimeTag extends SimpleTagSupport{

  @Override
  public void doTag() throws JspException, IOException {
    Instant now = Instant.now();
    JspWriter out = getJspContext().getOut();
    out.println(now.toString());
  }

}
