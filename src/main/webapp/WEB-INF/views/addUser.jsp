<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" />
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="<c:url value='admin' />">Rental Car</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="<c:url value='allAuto' />">Lista auto<span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='allUser' />">Lista Utenti</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='addAuto' />">Aggiungi Auto</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='addUser' />">Aggiungi Utente</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='allPrenotazione' />">Lista Prenotazione</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0" action="logout" method="GET">
					<button class="btn btn-dark" type="submit">Logout</button>
				</form>
			</div>
		</nav>

		<h1>AGGIUNGI UTENTE</h1>
		<div class="col-12 mt-4 col-md-6">
			<form method="POST" action="addUser">
				<div class="form-group">
					<label for="nome">Nome</label> <input type="text"
						class="form-control" name="nome">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Cognome</label> <input
						type="text" class="form-control" name="cognome" >
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Username</label> <input type="text"
						class="form-control" aria-describedby="emailHelp" name="name">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Data di Nascita</label> <input
						type="date" class="form-control" name="data_nascita">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Ruolo</label> <select
						class="custom-select" name="ruolo">
						<option selected></option>
						<option value="utente">utente</option>
						<option value="admin">admin</option>
					</select>
				</div>

				<button type="submit" class="btn btn-dark">Aggiungi</button>
			</form>
		</div>

	</div>
</body>
</html>