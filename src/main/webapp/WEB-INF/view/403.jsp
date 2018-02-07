<%@include file="header.jsp"%>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/create_user.css"/>">
<title>403</title>
</head>
<body>
	<div class="container-fluid main-wrap">
		<div class="row">
		<div class="col col-md-6 offset-md-3">
			<div class="card">
				<h1 class="card-header">Code: 403</h1>
				<div class="card-body">
					<h5 class="card-title">Access denied.</h5>
					<p class="card-text">Page you are looking for is forbidden for your account type.</p>
					<a href="${contextPath}/home" class="btn btn-outline-primary">Homepage</a>
				</div>
			</div>
		</div>
		</div>
	</div>
</body>
<script>
	$(window).on("load", function() {
		$("#preloader").hide();
	});
</script>
</html>
