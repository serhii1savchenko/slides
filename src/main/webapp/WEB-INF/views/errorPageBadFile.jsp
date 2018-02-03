<%@include file="header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-10 col-sm-offset-1 col-xs-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="wrapper">
						${msg}
						<p>error...</p>
						<a href="" id="ref">Return to Home Page</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	document.getElementById("ref").href = domainURL;
</script>

<%@include file="footer.jsp" %> 