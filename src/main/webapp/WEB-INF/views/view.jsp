<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Online Slides</title>
<!-- Favicon -->
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
<!-- jQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-3.2.0.min.js" /></script>
<script>
var currentSlide = 0;
var lastSlideId = "";
var elements;

    function load() {
		elements = $('[id^="img_"]');
    	//alert(elements.length);
    	jQuery.each(elements, function( i, val ) {
			if (i>0){
				document.getElementById("img_"+i).style.display = 'none';
    		}
    	});
    	// Initialization of JS var
    	lastSlideId = document.getElementById("nos").innerHTML - 1;
    }
    window.onload = load;
     
    function checkKey(e) {
        e = e || window.event;
        if (e.keyCode == '38') {				// UP
			if(currentSlide != lastSlideId){
				showNext((currentSlide+1));
			}else{
				showNext(0);
			}
        }
        else if (e.keyCode == '40') {			// DOWN
        	showPrev();
        }
        else if (e.keyCode == '37') {			// LEFT
			showPrev();
        }
        else if (e.keyCode == '39') {			// RIGHT
        	if(currentSlide != lastSlideId){
				showNext((currentSlide+1));
			}else{
				showNext(0);
			}
         }
	}
    document.onkeydown = checkKey;
</script>
</head>

<body style="background-color:black;">
<div style="display:none;"><p id="nos">${numberOfSlides}</p></div>

<div style="width: 100%; height: 100%;">
	<center>
		<c:forEach var="slide" items="${slidesArray}">
			<img id="img_${slide.id}" src="data:image/png;base64,${slide.img}" style="width:auto; height:100%; margin:0px; padding:0px;" onclick="showNext(${slide.nextId}); return false;" />
		</c:forEach>
	</center>
</div>

<script type="text/javascript">
function showNext(id){
	jQuery.each(elements, function( i, val ) {
		document.getElementById("img_"+i).style.display = 'none';
	});
	jQuery.each(elements, function( i, val ) {
		if (i==id){
			document.getElementById("img_"+i).style.display = '';
			currentSlide = i;
		 }
	});
}

function showPrev(){
	jQuery.each(elements, function( i, val ) {
		  document.getElementById("img_"+i).style.display = 'none';
	});
	if(currentSlide==0){
		  document.getElementById("img_"+lastSlideId).style.display = '';
		  currentSlide = lastSlideId;
	}else{
		jQuery.each(elements, function( i, val ) {
			if (i==(currentSlide-1)){
				document.getElementById("img_"+i).style.display = '';
				currentSlide = currentSlide-1;
			}
		});
	}
}
</script>

</body>
</html>