<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Online Slides</title>
</head>
<body>
	
<c:forEach var="slide" items="${slidesArray}">
	<p> <img src="data:image/png;base64,${slide}" width="150px" height="200px"/> </p> 
</c:forEach>

	
</body>
</html>
