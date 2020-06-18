<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>User Management Application</title>
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	intergrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1FQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="crossorigin">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
</header>
<br>
	<div class="row">
	<!-- <div class="alert alert-success" "ngIf='message'>{{message}}</div> -->
	
	<div class="container">
	<h3 class ="text-center">List of Users</h3>
	<hr>
	<div class="container text-left">
		<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New User</a>
	</div>
	<br>
	
<table class="table table-bordered">
	<thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
    </thead>
    <tbody>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value=" ${user.id}"></c:out></td>
                    <td><c:out value=" ${user.name}"></c:out></td>
                    <td><c:out value=" ${user.email}"></c:out></td>
                     <td><c:out value=" ${user.country}"></c:out></td>
                    <td>
                    	<a href="edit?id=<c:out value=' ${user.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value=' ${user.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>	
    </div>
</body>
</html>