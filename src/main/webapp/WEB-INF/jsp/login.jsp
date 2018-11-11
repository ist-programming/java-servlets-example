<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layouts/" %>
<l:user>
  <form action="<c:url value="/login" />" method="POST">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="Submit" value="Sign In">
  </form>
</l:user>
