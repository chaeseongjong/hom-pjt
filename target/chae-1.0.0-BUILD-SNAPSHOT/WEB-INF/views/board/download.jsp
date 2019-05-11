<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="table-responsive">
  <table class="table table-striped">
    <thead>
      <tr>
        <th class="text-left">파일 이름</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach var="result" items="${fileList}" >
		<tr><td><c:out value="${result}"/></td></tr>
	</c:forEach>
    </tbody>
  </table>
</div>