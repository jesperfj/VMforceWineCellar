<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>Home</title>
	<link href="${pageContext.request.contextPath}/resources/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header"><div id="app_title">Wine Cellar</div></div>
<div id="navigation"><a href="..">Home</a> / Wines</div>
<div id="content">
<table class="itemlist" width="100%">
	<tr>
		<th>Wine</th><th>Producer</th><th>Vintage</th><th>Variety</th>
	</tr>
<c:forEach items="${wines}" var="wine">
	<tr>
		<td><a href="${wine.id}">${wine.name}</a></td>
		<td><a href="../producer/${wine.producer.id}">${wine.producer.name}</a></td>
		<td>${wine.vintage!=0?wine.vintage:""}</td>
		<td>${wine.variety}</td>
	</tr>
</c:forEach>
</table>
<p/>
<form action="" method="post">
	<input type="button" name="New Wine" value="New Wine" onclick="location.href='new'"/>
</form>
</div>
<div id="footer"></div>
</body>
</html>
