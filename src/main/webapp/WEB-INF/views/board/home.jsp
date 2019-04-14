<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="//mozilla.github.io/pdf.js/build/pdf.js"></script>
<script src="/Javascript/home.js"></script>

<div class="inner cover" data-ride="carousel">

  <!-- pdf 뷰어  -->
  <div class="center-block " role="listbox" >
    <canvas class="center-block active" id="the-canvas">
    </canvas>
  </div>
  <!-- 왼쪽 그라데이션 버튼 -->
  <a class="left carousel-control" role="button" data-slide="prev" id="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <!-- 오른쪽 그라데이션 버튼-->
  <a class="right carousel-control" role="button" data-slide="next" id="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>