<%@include file="header.jsp" %>

ERROR!<br /> ${msg}

<p>We have some small problem or such page does not exist.</p>
<a href="" id="ref">Return to Home Page</a>

<script type="text/javascript">
	document.getElementById("ref").href = domainURL;
</script>

<%@include file="footer.jsp" %> 