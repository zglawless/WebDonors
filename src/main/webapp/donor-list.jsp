<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Donors</title>
</head>
<body>
<form method="post" action="navigationServlet">
	<table>
		<c:forEach items="${requestScope.allDonors}" var="currentdonor">
			<tr>
				<td><input type="radio" name="id" value="${currentdonor.id}"></td>
				<td>${currentdonor.id}</td>
				<td>${currentdonor.name}</td>
				<td>${currentdonor.amount}</td>
			</tr>
		</c:forEach>
	</table>
	
		<input type="submit" value="edit" name="doThisToDonor">
		<input type="submit" value="delete" name="doThisToDonor">
		<input type="submit" value="add" name="doThisToDonor">
	</form>
</body>
</html>