<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
<form action = "createNewListServlet" method = "post">
	Charity Name: <input type = "text" name = "charityName"><br/>
	Donation Date: <input type="text" name = "month" placeholder="mm" size="4">
	<input type="text" name = "day" placeholder="dd" size="4">
	<input type="text" name = "year" placeholder="yyyy" size="4">
	Donor Id: <input type="text" name = "donorId"><br />
	
	Available Donors:<br />
	<select name = "allDonorsToAdd" multiple size = "6">
	<c:forEach items = "${requestScope.allDonors}" var="currentdonor">
	<option value = "${currentdonor.id}"> ${currentdonor.name} | ${currentdonor.amount}</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value="Create list and Add Donors">

</form>
<a href="index.html">Go add new donors instead</a>
</body>
</html>