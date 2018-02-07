<%@include file="header.jsp"%>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/create_user.css"/>">
<title>500</title>
</head>
<body>
	<div class="container-fluid main-wrap">
		<div class="row">
			<div class="col col-md-6 offset-md-3">
				<div class="card">
					<h1 class="card-header">Code: 500</h1>
					<div class="card-body">
						<h5 class="card-title">Something went wrong.</h5>
						<p class="card-text">Server got some error while trying to
							load your page. Please, try again. If you continue to receive an
							error message, report a bug.</p>
						<a href="${contextPath}/home" class="btn btn-outline-primary">Homepage</a>
						<a href="#" class="btn btn-outline-danger">Report a bug</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
