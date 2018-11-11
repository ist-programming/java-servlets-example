<%@tag description="Make a Badge" pageEncoding="UTF-8" %>

<%@attribute name="text" required="true" type="java.lang.String" %>
<%@attribute name="type" type="java.lang.String" %>
<%@attribute name="link" type="java.lang.String" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty type}">
  <c:set var="type" value="primary" />
</c:if>
<!-- ToDo: check type for bootstrap typical values -->

<c:choose>
  <c:when test="${empty link}">
    <span class="badge badge-${type}">${text}</span>
  </c:when>
  <c:otherwise>
    <a href="${link}" class="badge badge-${type}">${text}</a>
  </c:otherwise>
</c:choose>
