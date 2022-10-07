<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping List</title>
</head>
<body>
<form method="post" action="listNavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
	<td><input type="radio" name="id" value="${currentlist.id}"></td>
	<td><h2>${currentlist.donationName}</h2></td>
</tr>
	
<tr>
	<td colspan="3">Donation Date: ${currentlist.donationDate}</td>
</tr>

<tr>
	<td colspan="3">Donor: ${currentlist.donor.donorName}</td>
</tr>
<c:forEach var="listVal" items="${currentlist.listOfDonors}">
<tr><td></td>
<td colspan="3">
${listVal.name}, ${listVal.amount}
</td>
</tr>
</c:forEach>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToList">
<input type="submit" value="delete" name="doThisToList">
<input type="submit" value="add" name="doThisToList">

</form>
<a href="addDonorsForListServlet">Create a new list</a><br />
<a href="index.html">Insert a new donor</a>
</body>
</html>