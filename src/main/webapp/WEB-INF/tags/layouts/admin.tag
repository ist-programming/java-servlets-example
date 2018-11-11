<%@tag description="Admin Layout Tag" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layouts/" %>
<l:main>
  <jsp:doBody/>
  <div style="display:fixed;right:0px;top:0px;">
    <a href="<c:url value="/admin" />">Dashboard</a>
  </div>
</l:main>
