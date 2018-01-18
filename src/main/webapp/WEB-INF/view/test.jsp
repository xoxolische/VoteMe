<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>VoteMe</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/mystyle.css" />">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
	integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy"
	crossorigin="anonymous">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
	integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
	crossorigin="anonymous"></script>
</head>

<body class="main">

	<nav class="navbar navbar-toggleable navbar-light bg-faded">
  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="#">Navbar</a>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>



	<!--
	<nav class="navbar navbar-dark bg-dark page-nav">
		<a class="navbar-brand" href="#">VoteMe</a>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
    		<ul class="navbar-nav mr-auto">
      			<li class="nav-item active">
        			<a class="nav-link" href="#">VSs<span class="sr-only">(current)</span></a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="#">About</a>
      			</li>
   			</ul>
  		</div>
	</nav>
	-->


	<div class="container-fluid">
		
		<div class="container">
			<div class="col-2">
				<h4 class="header" style="margin-top: 10px;">Votes</h4>
			</div>
			<div class="col-10"></div>
		</div>


		<div class="container">

			<div class="row list-item">
				<div class="col-2">
					<label class="count">999</label>
					<img class="arrow-up" src="<c:url value="/resources/images/arrow_up.png"/>">
					<img class="arrow-down" src="<c:url value="/resources/images/arrow_down.png"/>">
				</div>
				<div class="col-8">
					<p class="description"> 
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
						quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
						cillum dolore eu fugiat nulla pariatur.
					</p>
				</div>
				<div class="col-2 author">
					Author:
					<br>
					<label>Kolya loh</label>
				</div>
			</div>

			<div class="row list-item">
				<div class="col-2">
					<label class="count">9999</label>
					<img class="arrow-up" src="<c:url value="/resources/images/arrow_up.png"/>">
					<img class="arrow-down" src="<c:url value="/resources/images/arrow_down.png"/>">
				</div>
				<div class="col-8">
					<p class="description" id="desc"> 
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
						quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
						cillum dolore eu fugiat nulla pariatur.
					</p>
				</div>
				<div class="col-2 author">
					Author:
					<br>
					<label>Kolya pidor</label>
				</div>
			</div>


		</div>
	</div>
	
	

</body>
</html>