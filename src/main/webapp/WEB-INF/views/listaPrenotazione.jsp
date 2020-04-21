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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class = "container-fluid">
  

<nav class="navbar navbar-expand-lg navbar-light bg-light" >
  <a class="navbar-brand" href="<c:url value='admin' />">Rental Car</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value='allAuto' />">Lista auto<span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value='allUser' />">Lista Utenti</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='addAuto' />">Aggiungi Auto</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='addUser' />">Aggiungi Utente</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='allPrenotazione' />">Lista Prenotazione</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="logout" method="GET">
      <button class="btn btn-dark" type="submit">Logout</button>
    </form>
  </div>
</nav>
<h1>LISTA PRENOTAZIONI</h1>
<table class = "table table-striped ">
<thead class="thead-dark">
	<tr>
		<th>Nome</th>
		<th>Cognome</th>
		<th>Costruttore</th>
		<th>Modello</th>
		<th>Targa</th>
		<th>Anno Immatricolazione </th>
		<th>Categoria</th>
		<th>Stato Prenotazione</th>
		<th></th>
		<th></th>
	</tr>
	</thead>
        <tbody>
		<c:forEach items="${listaPre}" var="prenotazione">
		<tr>
 			<td>
				${prenotazione.user.nome} 
			</td>
			<td>
				${prenotazione.user.cognome}
			</td>
			<td>
				${prenotazione.auto.costruttore}
			</td>
			<td>
				${prenotazione.auto.modello}
			</td>
			<td>
				${prenotazione.auto.targa}
			</td>
			<td>
				${prenotazione.auto.anno}
			</td>
			<td> 
 				${prenotazione.auto.categoria.descrizione}
			</td> 
			<td>
				${prenotazione.stato}
			</td>
			<c:choose>
			<c:when test="${prenotazione.stato.equalsIgnoreCase('in sospeso') }">
 				<td> 
 					<form action="accetta" method="POST"> 
						<input type="submit" class="btn btn-outline-danger"  value="Accetta"> 
 						<input type="hidden" name="id" value="${prenotazione.id}"> 
 					</form>
				</td> 
				<td> 
 					<form action="rifiuta" method="POST">
						<input type="submit" class="btn btn-outline-danger"  value="Rifiuta"> 
 						<input type="hidden" name="id" value="${prenotazione.id}">
 					</form>
				</td>
			</c:when>
			<c:otherwise>
			<td></td>
			</c:otherwise>
			</c:choose>
 		</tr> 
		</c:forEach>
		</tbody>
</table>
</div>
</body>
</html>