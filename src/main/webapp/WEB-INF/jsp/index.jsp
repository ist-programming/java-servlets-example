<%@taglib prefix="l" tagdir="/WEB-INF/tags/layouts/" %>
<%@taglib prefix="b" tagdir="/WEB-INF/tags/bootstrap/" %>
<%@taglib prefix="dt" uri="/WEB-INF/datetime.tld" %>
<l:main>
  <h2>${name}</h2>
  <b:badge text="Badge Text" type="secondary" />
  <b:badge text="Badge Text" type="primary" link="http://google.com" />
  <dt:time />
</l:main>