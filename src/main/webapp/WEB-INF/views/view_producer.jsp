<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>${producer.name}: Edit Detail</title>
	<link href="${pageContext.request.contextPath}/resources/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header"><div id="app_title">Wine Cellar</div></div>
<div id="navigation"><a href="..">Home</a> / <a href=".">Producers</a> / ${producer.name}</div>
<div id="content">
<form:form commandName="producer">
<table>
	<tr>
		<td>Producer:</td><td><form:input size="40" path="name"/></td>
	</tr>
	<tr>
		<td>City:</td><td><form:input size="40" path="city"/></td>
	</tr>
	<tr>
		<td>Region:</td><td><form:input size="40" path="region"/></td>
	</tr>
	<tr>
		<td>Country:</td><td><form:input size="40" path="country"/></td>
	</tr>
</table>
<p/>
<input type="submit" value="Save"/>
<input type="button" value="Producer List" onclick="location.href='.'"/>
</form:form>
</div>
<div id="footer"></div>
</body>
</html>
