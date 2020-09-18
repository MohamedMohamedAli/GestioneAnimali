<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Cavalli</title>
</head>
<body>

	<%@ include file="../header.jsp"%>

	<c:if test="${messaggioConferma!=null}">
		<div class="alert alert-success" role="alert">${messaggioConferma}</div>
	</c:if>

	<div class="block-container">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome Cavallo</th>
					<th>Soprannome Cavallo</th>
					<th>Tipo Vaccino</th>
					<th>Data Vaccinazione</th>
					<th>Azioni</th>
				</tr>
			</thead>

			<c:forEach var="vaccino" items="${listaVacciniAttr}">
				<tr>
					<td>${vaccino.animale.nome}</td>
					<td>${vaccino.animale.soprannome}</td>
					<td>${vaccino.tipo}</td>
					<td>${vaccino.data}</td>
					<td><a
						href="${pageContext.request.contextPath}/preCompletaVaccinoSer?idVaccino=${vaccino.id}&idCavallo=${vaccino.animale.id}&cercaVaccini=${true}"
						class="btn btn-success">Completa Vaccinazione</a></td>
				</tr>
			</c:forEach>

		</table>


	</div>

	<div>
		<a href="${pageContext.request.contextPath}/homeServlet"
			class="btn btn-primary btn-md">Torna Indietro</a>
	</div>




</body>
</html>
