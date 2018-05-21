<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>

	<style type="text/css">
		body {
    background: url(img/header.jpg) no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;

}

.login {
  margin: 20px auto;
  width: 300px;
  padding: 30px 25px;

}

.login-input {
  width: 285px;
  height: 50px;
  margin-bottom: 25px;
  padding-left:10px;
  font-size: 15px;
  background: #fff;
  border: 1px solid #ccc;
  border-radius: 4px;
}
.login-input:focus {
    border-color:#6e8095;
    outline: none;
  }
.login-button {
  width: 100%;
  height: 50px;
  padding: 0;
  font-size: 20px;
  color: #fff;
  text-align: center;
  background: #f0776c;
  border: 0;
  border-radius: 5px;
  cursor: pointer; 
  outline:0;
}

.login-lost
{
  text-align:center;
  margin-bottom:0px;
}

.login-lost a
{
  color:white;
  text-decoration:none;
  font-size:13px;
}

	</style>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-4">
				<h4 class="text-center">Login</h4>
				<hr>
				<form:form method="post" action="login" class="login">
					<div class="form-group">
						<label for="login" style="color:white" id="h3">Codigo: </label>
						<form:input path="login" class="login-input" placeholder="angie@gmail.com"/>
					</div>
					<div class="form-group">
						<label for="password" style="color: white" id="h3">Password: </label>
						<form:password path="password" class="login-input"  class="btn btn-success" placeholder="********" />
					</div>
					<div class="form-group">
						<input type="submit" value="Login" class="login-button"/>
					</div>
					<p class="login-lost"><a href="">Olvidaste tu contraseña?</a></p>
				</form:form>
				<font color="red">${message}</font>
			</div>
		</div>
	</div>
	
</body>
</html>
