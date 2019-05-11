<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS -->
<link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/css/bootstrap/bootstrap.css">
<link href="/css/mainlayout.css" rel="stylesheet">
<!-- 자바스크립트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/Javascript/bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div id="header" class="container-fluid">
			<tiles:insertAttribute name="header"/>
		</div>
	</nav>
	<div id="content">
		<tiles:insertAttribute name="content"/>
	</div>
</body>
</html>