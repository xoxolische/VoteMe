<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>Create Versus</title>

	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/create_versus.css"/>">
</head>

<body>
	<div class="container-fluid">
		<div class="container-fluid">

			<div class="row">
				<div class="col-5"></div>
				<div class="col-2">
					<input type="text" name="versus-tittle" class="text-input" placeholder="enter versus tittle">
				</div>
				<div class="col-5"></div>
			</div>

			<div class="row">
				<div class="col-5">
					<h6 class="picture-input-label">select first picture</h6>
					<input type="file" name="picture_1" class="picture-input">
					<textarea name="opinion_1" class="opinion-input" placeholder="your opinion"></textarea>
				</div>

				<div class="col-2">
					<h1 class="vs-label">VS</h1>
				</div>

				<div class="col-5">
					<h6 class="picture-input-label">select second picture</h6>
					<input type="file" name="picture_2" class="picture-input">
					<textarea name="opinion_2" class="opinion-input" placeholder="your opinion"></textarea>
				</div>
			</div>

			<div class="row">
				<div class="col-3"></div>
				<div class="col-6">
					<textarea name="description" class="description-input" placeholder="enter some description"></textarea>
				</div>
				<div class="col-3"></div>
			</div>

		</div>
	</div>
</body>
</html>