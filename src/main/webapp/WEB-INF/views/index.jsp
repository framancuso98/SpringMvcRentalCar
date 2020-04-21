<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12 text-center mt-4">
				<h1>Benvenuti in RentalCar</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-6 mt-4 col-md-6">
				<div class="row">
					<div class="col-12 ">
						<form id="accedi" method="POST" action="login">
							<div class="form-group">
								<label for="exampleInputEmail1">Username</label> <input
									type="text" class="form-control" name="username"
									aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" name="password">
							</div>
							<button type="submit" class="btn btn-dark">Accedi</button>
						</form>
					</div>
				</div>
				<div class="row">
					<div class="col-12 ">
						<c:choose>
							<c:when test="${erroreOk == null}">
								
							</c:when>
							<c:otherwise>
								<div class="alert alert-success" role="alert">${erroreOk}</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="row">
					<div class="col-12 ">
						<c:choose>
							<c:when test="${errore == null}">
								
							</c:when>
							<c:otherwise>
								<div class="alert alert-danger col-12" role="alert">
									${errore}</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<div class="col-12 mt-4 col-md-6">
				<form method="POST" action="registraUser">
					<div class="form-group">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" name="nome" value="${newUser.nome}">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Cognome</label> <input
							type="text" class="form-control" name="cognome"
							value="${newUser.cognome}">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Username</label> <input
							type="text" class="form-control" aria-describedby="emailHelp"
							name="name" value="${newUser.name}">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" name="password">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Data di Nascita</label> <input
							type="date" class="form-control" name="data_nascita"
							value="${newUser.data_nascita}">
					</div>
					<button type="submit" class="btn btn-dark">Registrati</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>