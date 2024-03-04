<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ContactApp | Login</title>
  <link rel="stylesheet" href="resources/css/styles.css">
</head>
<body>

 <div class="container">
    <h2>Login</h2>
    <form action="Login" modelAttribute="log" method="post">
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="pass" required>
      </div>
      <button type="submit">Login</button>
    </form>
  </div>
<!-- <h1>Login</h1>

	<form action="Login" modelAttribute="log" method="post">
		<table> 			 
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="Password" name="pass"></td>
			</tr> 
		</table>
		
		<button type="submit" value="Login">Login</button>
			
	</form>
	 -->
		<h2>${errorMsg}</h2>

</body>
</html>