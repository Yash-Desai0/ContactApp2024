<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ContactApp | Account</title>
<link rel="stylesheet" href="resources/css/styles.css">
</head>
<body>

<div class="container">
  <form action="Register" modelAttribute="reg" method="post" enctype="multipart/form-data">
    <h2>User Registration</h2>
    <div class="form-group">
      <label for="username">Username:</label>
      <input type="text" id="username" name="name" required>
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" id="email" name="email" required>
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" id="password" name="pass" required>
    </div>
    <div class="form-group">
      <label for="image">Select Image:</label>
      <input type="file" id="image" name="file">
    </div>
    <button type="submit">Register</button>
  </form>
</div>

<!-- 	<form action="Register" modelAttribute="reg" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="Password" name="pass"></td>
			</tr>
			<tr>
				<td>Repeat Password</td>
				<td><input type="Password" name="rpass"></td>
			</tr>
			<tr>
				<td>Select File:</td>
				<td><input type="file" name="file"></td>
			</tr> 
		</table>
		
		<button type="submit" value="Register">Register</button>
			
	</form> -->
	
		<h2>${errorMsg}</h2>

</body>
</html>