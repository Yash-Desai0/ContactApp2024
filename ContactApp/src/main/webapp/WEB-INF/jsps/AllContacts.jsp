<%@page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.yash.bean.RegisterBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contacts</title>
</head>
<body>
 
<h2>ContactLists</h2>
<% RegisterBean UserBean = (RegisterBean) session.getAttribute("UserBean"); %>

<c:if test="${UserBean == null}">
	<c:redirect url = "openLoginView" />
</c:if>

	<table border="1">
		<thead>
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Tags</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>
		<c:if test="${Contacts==null }">
			<tr>
				<p>Your list is Empty.</p>
			</tr>
		</c:if>

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
	<c:if test="${count!=0}">
	<c:forEach begin="1" end="${count}/5" varStatus="loop">
    	<a href="viewcontacts/${loop.index}">${loop.index}</a> 
	</c:forEach>
	</c:if>
	<%-- <c:if test="${count%5==0}">
		<c:if test="(${count/5})<${count}">
		
		</c:if>
	</c:if>
	if(${count}%5==0)
	{
		if((count/5)<count)
		{
			System.out.print("Page"+0+" ");
		}
	}%> --%>
	
</body>
</html>