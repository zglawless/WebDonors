<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit a Donor</title>
</head>
<body>
		<form action="editDonorServlet" method="post">
		Name: <input type="text" name="name" value="${donorToEdit.name}">
		Amount: <input type="text" name="amount" value="${donorToEdit.amount}">
		ID: <input type="text" name="id" value="${donorToEdit.id}">
		<input type="submit" value="Save Edited Item">
	</form>
</body>
</html>