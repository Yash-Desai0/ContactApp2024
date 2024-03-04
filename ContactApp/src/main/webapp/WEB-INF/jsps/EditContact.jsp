<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ContactApp | EditContact</title>
</head>
<body>
<div class="form-container">


	<h1>Edit Contact</h1>	
	<form action="updateContact" modelAttribute="Edit">
		<table>
			<tr>
				<td>Contact Name</td>
				<td><input type="text" name="name" value="${Contact.name}"></td>
			</tr>
			<tr>
				<td>Contact Email</td>
				<td><input type="text" name="email" value="${Contact.email}"></td>
			</tr> 
			<tr>
				<td>Contact Tags</td>
				<td><input type="text" name="tag" value="${Contact.tag}"></td>
			</tr>
			 
		</table>
		<c:if test="${UserBean==null}">
			 <a href="openLoginView"><button>Edit Contact</button></a>
		</c:if>
		<c:if test="${UserBean!=null}">
			<input type="hidden" name="contact_sl" value="${Contact.contact_sl}"> 
			<input type="hidden" name="gender" value="${Contact.gender}">
			<input type="hidden" name="user.sl_no" value="${UserBean.sl_no}">
			<button type="submit">Update Contact</button>
		</c:if> 			
	</form>
	</div>
		<h2>${errorMsg}</h2>


</body>
</html>