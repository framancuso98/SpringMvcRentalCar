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
  <a class="navbar-brand" href="<c:url value='user' />">Rental Car</a>
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
    <form class="form-inline my-2 my-lg-0" action="logout" method="GET">
      <button class="btn btn-dark" type="submit">Logout</button>
    </form>
  </div>
</nav>
<h1>${userLoggato.nome.toUpperCase()} BENVENUTO IN RENTAL CAR</h1>
<br><br>
<c:choose>
<c:when test="${prenotazioneUser != null }">
<h3>PRENOTAZIONI ATTIVE:</h3>
<table class="table">
		<tr>
		<th>Costruttore</th>
		<th>Modello</th>
		<th>Targa</th>
		<th>Anno Immatricolazione </th>
		<th>Categoria</th>
		<th>Stato Prenotazione</th>
		<th></th>
		<th></th>
	</tr>
		<tr>
			<td>
				${prenotazioneUser.auto.costruttore}
			</td>
			<td>
				${prenotazioneUser.auto.modello}
			</td>
			<td>
				${prenotazioneUser.auto.targa}
			</td>
			<td>
				${prenotazioneUser.auto.anno}
			</td>
			<td> 
 				${prenotazioneUser.auto.categoria.descrizione}
			</td> 
			<td>
				${prenotazioneUser.stato}
			</td>
			<td>
 				<form action="eliminaPrenotazione" method="POST">
						<input type="submit" class="btn btn-outline-danger" value="Elimina" name="elimina">
						<input type="hidden" name= "idelimina" value="${prenotazioneUser.id}">
				</form>
			</td>
			</tr>
</table>
</c:when>
<c:otherwise>
<h3>NESSUNA PRENOTAZIONE ATTIVA</h3>
</c:otherwise>
</c:choose>
</div>
</body>

</html>