<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit List of Donors</title>
</head>
<body>
<form action = "editDonationDetailsServlet" method="post">
	<input type ="hidden" name = "id" value= "${listToEdit.id}">
	Charity Name: <input type ="text" name = "charityName" value= "${listToEdit.charityName}"><br />
	Donation Date: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
	Donor Id: <input type = "text" name = "donorId" value= "${listToEdit.donors.donorId}"><br />
	
	Available Donors:<br />
	<select name="allDonorsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allDonors}" var="currentdonor">
	   <option value = "${currentdonor.id}">${currentdonor.name} | ${currentdonor.amount}</option>
	</c:forEach>
	</select>
	<br />
	<input type = "submit" value="Edit List and Add Donors">
</form>
<a href = "index.html">Go add new donors instead.</a>
</body>
</html>