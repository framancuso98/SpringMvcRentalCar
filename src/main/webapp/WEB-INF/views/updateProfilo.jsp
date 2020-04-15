<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
 	 <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
      crossorigin="anonymous"
    />
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class = "container-fluid">  
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
  <a class="navbar-brand" href="<c:url value='/login/home' />">Rental Car</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value='allAuto' />">Lista auto<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='profilo' />">Profilo</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="" method="POST">
      <button class="btn btn-dark" type="submit">Logout</button>
    </form>
  </div>
</nav>
<h1>MODIFICA PROFILO</h1>
<form action="updateUser" method="POST">
	Nome: <input type="text" name="nome" value="${userLoggato.nome }"> <br> <br>
	Cognome: <input type="text" name="cognome" value="${userLoggato.cognome }"> <br> <br>
	Username: <input type="text" name="name" value="${userLoggato.name }"> <br> <br>
	Data Di Nascita: <input type="date" name="data_nascita" value="${userLoggato.data_nascita}"> <br> <br>
	<input type="hidden" name="id" value="${userLoggato.id}">
	<input type="hidden" name="password" value="${userLoggato.password}">
	<input type="hidden" name="id_authority" value="${userLoggato.authority.id}">
	<input type="submit" value="Modifica">
</form>
</div>
</body>
</html>