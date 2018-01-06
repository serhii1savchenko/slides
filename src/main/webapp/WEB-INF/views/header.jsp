<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Online Slides</title>
	<meta name="description" content="Slide sharing service" />
	<meta name="keywords" content="Online Slides, SlideShare, Slide, Share" />
		<!-- jQuery -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-3.2.0.min.js"/></script>
		<!-- Bootstrap -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-theme.min.css"> 
		<script src="${pageContext.request.contextPath}/resources/bootstrap.min.js"></script>
		<!-- Font Awesome -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome-4.7.0/css/font-awesome.min.css">
		<!-- Social Buttons for Bootstrap -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-social-gh-pages/bootstrap-social.css">
		<!-- Style for upload button -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/upload_button.css">
		<!-- Favicon -->
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
		<!-- root path -->
		<script type="text/javascript"> var domainURL = window.location.protocol + "//"  + window.location.host + /* "" + window.location.pathname; */ "/"; </script>
</head>
<body>
	<center>
		<a href="" id="home"><img src = "${pageContext.request.contextPath}/resources/images/new.png" style="padding-top: 5px; padding-bottom: 5px; max-width: 100%; height: auto;"/></a>
		<script type="text/javascript">
			document.getElementById("home").href = domainURL;
		</script>
	</center>
