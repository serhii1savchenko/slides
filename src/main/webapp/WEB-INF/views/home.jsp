<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Online Slides</title>
</head>
<body>
	
	<form method="POST" action="uploadFile" enctype="multipart/form-data"> 
		File to upload: <input type="file" name="file"><br /> 
        Press here to upload the file! <input type="submit" value="Upload"> 
	</form>
	
</body>
</html>
