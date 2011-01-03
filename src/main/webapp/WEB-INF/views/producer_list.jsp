<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>Producers</title>
	<link href="${pageContext.request.contextPath}/resources/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header"><div id="app_title">Wine Cellar</div></div>
<div id="navigation"><a href="..">Home</a> / Producers</div>
<div id="content">
<table class="itemlist" width="100%">
	<tr>
		<th>Producer Name</th><th>City</th><th>Region</th><th>Country</th>
	</tr>
<c:forEach items="${producers}" var="producer">
	<tr>
		<td><a href="${producer.id}">${producer.name}</a></td>
		<td>${producer.city}</td>
		<td>${producer.region}</td>
		<td>${producer.country}</td>
	</tr>
</c:forEach>
</table>
<p/>
<form action="" method="post">
	<input type="button" name="New Producer" value="New Producer" onclick="location.href='new'"/>
</form>
	</div><div id="footer"></div>
	
</body>
</html>
