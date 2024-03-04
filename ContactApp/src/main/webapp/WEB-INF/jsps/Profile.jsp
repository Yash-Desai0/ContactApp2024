<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Profile</title>
  <link rel="stylesheet" href="resources/css/styles.css">
</head>
<body>
 
<div class="profile-container">
	<a href="dashboard"><button>back</button></a>
    <h2>Profile</h2>
    <div class="profile-image">
    	<img src="${UserBean.imagepath}" alt="Profile Picture"> 
    </div>
    <div class="profile-info">
      <form action="editProfile" modelAttribute="temp" method="post" enctype="multipart/form-data">
        <div class="form-group">
          <label for="name">Name:</label>
          <input type="text" id="name" name="name" value="${UserBean.name}">
        </div>
        <div class="form-group">
          <label for="email">Email:</label>
          <input type="email" id="email" name="email" value="${UserBean.email}">
        </div>
        <div class="form-group">
          <label for="password">Password:</label>
          <input type="text" id="password" name="pass" value="${UserBean.pass}">
        </div>
        <div class="form-group">
          <label for="profile-image-upload">Change Profile Picture</label>
          <input type="file" accept="image/*" id="profile-image-upload" name="file">
        </div>
 		<c:if test="${UserBean==null}">
			 <a href="openLoginView"><button>EditProfile</button></a>
		</c:if>
		<c:if test="${UserBean!=null}">
			<input type="hidden" name="imagepath" value="${UserBean.imagepath}">
			<input type="hidden" name="sl_no" value="${UserBean.sl_no}">
			<button type="submit">Save Changes</button>
			  
		</c:if>
		</form> 
		<h2>${errorMsg}</h2>
    </div>
</div> 
</body>
</html>