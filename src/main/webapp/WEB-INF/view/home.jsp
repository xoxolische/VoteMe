<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>VoteMe</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>">



<script src="resources/scripts/jquery.parallax.js"></script>
	<script>

  jQuery(document).ready(function(){
    jQuery('#parallax .parallax-layer')
    .parallax({
      mouseport: jQuery('#parallax')
    });
  });
 
</script>



</head>


<body class="main">


	<div class="site_wrap">
		<div class="parallax-viewport" id="parallax">

			<div class="parallax-layer" style="width: 50%; height: 80%;">
				<img src="${contextPath}/resources/images/midground.png"/>
			</div>
			<div class="parallax-layer" style="width: 40%; height: 60%;">
				<img src="${contextPath}/resources/images/foreground.png"
					style="position: absolute; top: 5px; left: -10;" />
			</div>
		</div>
	</div>


	<div class="container-fluid">

		<div class="container">
			<div class="row">
				<div class="col-2">
					<h4 class="page-title text-light">Votings</h4>
				</div>
				<div class="col-10"></div>
			</div>
		</div>
	

		<!--
		<c:forEach items="${versuses}" var="versus">
			<div class="card">
				<div class="card-header">${versus.description}</div>
				<div class="card-block">
					<h4 class="card-title">${versus.description}</h4>
					<p class="card-text"></p>
					<c:forEach items="${versus.opinions}" var="opinion">
						<a href="#" class="btn btn-primary">${opinion.text}</a>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
-->


		<div class="container" id="versus-list">

			<c:forEach items="${versuses}" var="versus">
				<div class="row bg-dark text-light list-item">

					<div
						class="col-1 d-flex justify-content-end align-items-center rating-counter-wrap">
						<label class="rating-counter">mark</label>
					</div>

					<div class="col-1 d-flex align-items-center">
						<div>
							<img class="arrow-up"
								src="<c:url value='/resources/images/arrow_up.png'/>"> <img
								class="arrow-down"
								src="<c:url value="/resources/images/arrow_down.png"/>">
						</div>
					</div>

					<div class="col-8">
						<div>
							<h5 class="versus-title" id="${versus.id}">${versus.title}</h5>
						</div>
						<div class="versus-description">${versus.description}</div>
					</div>

					<div class="col-2 versus-author-wrap">
						<div class="versus-author">
							<h5>author</h5>
							<p class="author-nickname">${versus.author.nickName}</p>
						</div>
					</div>
				</div>
			</c:forEach>

			<div class="container">
				<div class="alert alert-info empty-list-alert" role="alert">
					<h4>Nothing to show :c</h4>
				</div>
			</div>


		</div>
	</div>

	<script type="text/javascript"
		src="<c:url value="/resources/scripts/home.js"/>"></script>
</body>
</html>

