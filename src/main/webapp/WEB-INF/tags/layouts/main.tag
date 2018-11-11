<%@tag description="Main Layout Tag" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html>
<html>
  <head>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/css/main.css" />">
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="<c:url value="/" />"></a>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="<c:url value="/" />">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<c:url value="/login" />">Sign In</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<c:url value="/profile" />">Profile</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<c:url value="/logout" />">Exit</a>
          </li>
        </ul>
      </div>
    </nav>
    <div class="main-wrapper">
      <jsp:doBody/>
    </div>
  </body>
</html>

