<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
<h3> Employee Form</h3>

<a href="/8.2_SpringMVCInternationalizationandLocalizationExample/index.jsp?siteLanguage=en">English</a>
<a href="/8.2_SpringMVCInternationalizationandLocalizationExample/index.jsp?siteLanguage=fr">French</a>

<form action="saveAction" method="post">
<table>
	<tr>
		<td><spring:message code="label.EmpId"/></td><td>	<input type="text" name="id"/></td>
		
	</tr>
	<tr>
		<td><spring:message code="label.EmpName"/></td><td>	<input type="text" name="name"/></td>
	</tr>
	
	 <tr>
		<td><spring:message code="label.EmpDOB"/></td><td>	<input type="text" name="dateDob"/></td>
	</tr>
		
	<table>
	<tr><td><spring:message code="label.EmpAdrress"/></td></tr>
	<tr>
		<td><spring:message code="label.Country"/><input type="text" name="empAddress.country"/></td>
		<td><spring:message code="label.City"/><input type="text" name="empAddress.city"/></td>
	</tr>
	</table>
	
	<tr>
		<td><input type="submit"></td>
	</tr>
</table>
</form>
</body>
</html>