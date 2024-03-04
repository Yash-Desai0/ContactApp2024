<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Contact Form</title>
  <link rel="stylesheet" href="resources/css/styles.css">
</head>
<body>

 <div class="container">
  	<a href="dashboard"><button>back</button></a>
  	<h2>Add Contact</h2>
   	<form action="addContact" modelAttribute="con" method="post">
	  
	  <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${Contact.name}" required>
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${Contact.email}" required>
      </div>	
      <div class="form-group">
        <label for="subject">Tag:</label>
        <input type="text" id="subject" name="tag" value="${Contact.tag}" required>
      </div>
       
		<div>
			<label for="gen">Gender:</label> 
			<input type="radio" id="gen" name="gender" value="male" checked="checked">Male 
			<input type="radio" id="gen" name="gender" value="female">Female
		</div>
		<br>
		<c:if test="${UserBean==null}">
			<a href="openLoginView"><button>Add Contact</button></a>
		</c:if>
		<c:if test="${UserBean!=null}">
			<input type="hidden" name="user.sl_no" value="${UserBean.sl_no}">
			<button type="submit">Add Contact</button>
		</c:if> 
    </form>
  </div> 
  <h2>${errorMsg}</h2>
</body>
</html>