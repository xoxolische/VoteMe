<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="meta.jsp"%>
<%@include file="header.jsp"%>
<style>
.content {
	height: 75vh;
	max-height: 75vh;
}

.content-no-h {
	height: 100vh;
	max-height: 100vh;
}

.f-height {
	height: 90vh;
}

.f-height-100 {
	height: 100vh;
}

.jumbotron {
	margin-bottom: 0rem;
}

.rel {
	position: relative;
}
</style>
<title>About</title>
</head>
<body>
	<div class="content">
		<div class="jumbotron jumbotron-fluid f-height">
			<div class="container">
				<h1 class="display-4">What is VoteMe?</h1>
				<p class="lead">VoteMe it's a simple service which provides a
					possibility to people to ask for an advice in some difficult
					decisions. It's easy to use, just make an account to start. Vote
					for other user`s cases, create your own and comment.</p>
				<div class="container text-center">
					<div class="row">
						<div class="col-md-4 col-sm-4">
							<i class="fas fa-thumbs-up fa-7x"></i>
							<h4>Rate</h4>
						</div>
						<div class="col-md-4 col-sm-4">
							<i class="fas fa-comments fa-7x"></i>
							<h4>Discuss</h4>
						</div>
						<div class="col-md-4 col-sm-4">
							<i class="fas fa-bullhorn fa-7x"></i>
							<h4>Ask for an advice</h4>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- -->
	<div class="content mt-5">
		<div class="jumbotron jumbotron-fluid" style="padding: 1rem 2rem">
			<div class="container">
				<div class="row justify-content-center">
					<h1 class="display-4 col-md-12">Project Team</h1>

					<div class="card-deck" style="height: 78vh">
						<div class="card" style="width: 300px">
							<img class="card-img-top" style="height: 45vh"
								src="<c:url value="/resources/photo/nik.JPG"/>"
								alt="No photo...">
							<div class="card-body" style="height: 60vh">
								<h4 class="card-title">Nikita Pavlov</h4>
								<p class="card-text">
									Ukraine, Kiev <br>Phone: +380958451070<br>Email:
									nikita.pavlov@ukr.net
								</p>
								<a href="https://www.linkedin.com/in/никита-павлов-879b7513b/" target="blank" class="btn btn-outline-primary"><i
									class="fab fa-linkedin-in fa-2x"></i></a>
							</div>
						</div>



						<div class="card" style="width: 300px">
							<img class="card-img-top"
								src="https://www.w3schools.com/bootstrap4/img_avatar1.png"
								alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Oleh Sharychev</h4>
								<p class="card-text">
									Ukraine, Odessa<br>Phone: +380997521536<br>Email:
									shar1997@ukr.net
								</p>
								
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>

