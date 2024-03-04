<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.yash.bean.RegisterBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Navigation Bar</title>
  <link rel="stylesheet" href="resources/css/Menu.css">
</head>
<body>

<% RegisterBean UserBean = (RegisterBean) session.getAttribute("UserBean"); %>

<c:if test="${UserBean == null}">
	<c:redirect url = "openLoginView" />
</c:if>

<div class="navbar">
    <a href="#home">Home</a>
    <a href="openAddContactView">Add Contact</a>
    <a href="viewcontacts/1">View Contacts</a>
    <a href="openProfileView">Profile</a>
    <a href="logout">Logout</a>
    <div class="search-container">
        <form action="SearchContact">
      		<input type="text" placeholder="Search.." name="str">
      		<button type="submit">Submit</button>
    	</form>
    </div>
</div>

<div class="form-container"> 
<h2>Contact Lists</h2>

	<table border="1">
		<thead>
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Tags</th>
				<th>Gender</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
		</thead>
		
		<tbody> 
		<c:if test="${Contacts!=null}">
			<c:forEach items="${Contacts}" var="Contact">
				<tr>
					<td>${Contact.contact_sl}</td>
					<td>${Contact.name}</td>
					<td>${Contact.email}</td>
					<td>${Contact.tag}</td>
					<td>${Contact.gender}</td>
					<td><a href="deleteContact/${Contact.contact_sl}"><button>Delete</button></a></td>
					<td><a href="openEditContactView/${Contact.contact_sl}"><button>Edit</button></a></td> 
				</tr>
			</c:forEach>
		</c:if> 
		</tbody>
		 
	</table>
	<h3>${NotFound}</h3>
</div> 
</body>
</html>