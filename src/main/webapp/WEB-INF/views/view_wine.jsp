<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>${wine.name}: Edit Detail</title>
	<link href="${pageContext.request.contextPath}/resources/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header"><div id="app_title">Wine Cellar</div></div>
<div id="navigation"><a href="..">Home</a> / <a href=".">Wines</a> / ${wine.name}</div>
<div id="content">
<form:form commandName="wine">
<table>
	<tr>
		<td>Name:</td><td><form:input size="40" path="name"/></td>
	</tr>
	<tr>
		<td>Vintage:</td><td><form:input size="4" path="vintage"/></td>
	</tr>
	<tr>
		<td>Variety:</td><td><form:select path="variety" items="${varietyOptions}"/></td>
	</tr>
	<tr>
		<td><a href="../producer/${wine.producer.id}">Producer</a>:</td><td><form:input size="40" path="producer.name"/></td>
	</tr>
</table>
<p/>
<input type="submit" value="Save"/>
<input type="button" value="Wine List" onclick="location.href='.'"/>
</form:form>
	</div>
<div id="footer"></div>
</body>
</html>
