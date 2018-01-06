<%@include file="header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-10 col-sm-offset-1 col-xs-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="wrapper">
						<h2>Here is your link!</h2>
						<a href="" id="ref"> <textarea id="area" class="js-copytextarea form-control" rows="1" readonly></textarea></a>
						<div style="padding-top: 5px; padding-down: 5px;"><button class="js-textareacopybtn btn btn-default">Copy</button></div>
						<br/>
						<p>Click the button to copy it to clipboard.</p>
						---------------------------------
						<p>Press F11 to open your presentation in full screen mode.</p>
						<p>Use arrow keys for navigation, click for next slide.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	var copyTextareaBtn = document.querySelector('.js-textareacopybtn');
	copyTextareaBtn.addEventListener('click', function(event) {
	  var copyTextarea = document.querySelector('.js-copytextarea');
	  copyTextarea.select();
	  try {
	    var successful = document.execCommand('copy');
	    var msg = successful ? 'successful' : 'unsuccessful';
	    console.log('Copying text command was ' + msg);
	  } catch (err) {
	    console.log('Oops, unable to copy');
	  }
	});
	
	document.getElementById("ref").href = domainURL + "open/" + '${id}';
	
	document.getElementById('area').innerHTML = domainURL + "open/" + '${id}';
</script>
	
<%@include file="footer.jsp" %>