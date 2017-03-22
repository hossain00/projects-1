<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="indexHeader.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reimbursement</title>
<!-- Bootstap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
	<!-- Custom Style -->
	<link href="css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	
<div class="container">

      <form action="login.do" method="post" class="form-signin">
        <h2 class="form-signin-heading">Please Sign In</h2>
        <label for="inputUsername" class="sr-only">Username</label>
        
        <input type="username" id="inputUsername" name="Username" class="form-control" placeholder="Username" required="" autofocus="">
        <label for="inputPassword" class="sr-only">Password</label>
        
        <input type="password" id="inputPassword" name="Password" class="form-control" placeholder="Password" required="">
        <div class="checkbox">
        
        <p><font color="red">${Incorrect}</font></p>
        <c:remove var ="Incorrect" scope="session"/>
        
          <label>
            <input type="checkbox" value="remember-me"> Remember Me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign In</button>
      </form>
    </div>

</body>
</html>