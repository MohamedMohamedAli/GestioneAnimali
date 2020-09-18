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
	<div class="block-container">
		<c:if test="${messaggioConferma!=null}">
			<div class="alert alert-success" role="alert">${messaggioConferma}</div>
		</c:if>
		<h1>Vaccini Cavallo: ${nomeCavallo}</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Tipo</th>
					<th>Data</th>
					<th>Azioni</th>
				</tr>
			</thead>

			<c:forEach var="vaccino" items="${listaVacciniAttr}">
				<tr>
					<td>${vaccino.tipo}</td>
					<td>${vaccino.data}</td>
					<td><a
						href="${pageContext.request.contextPath}/dettaglioVaccinoSer?idVaccino=${vaccino.id}&idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
						class="btn btn-info">Dettaglio</a> <a
						href="${pageContext.request.contextPath}/preModificaVaccinoSer?idVaccino=${vaccino.id}&idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
						class="btn btn-info">Modifica</a> <a
						href="${pageContext.request.contextPath}/preEliminaVaccinoSer?idVaccino=${vaccino.id}&idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
						class="btn btn-info">Elimina</a> <a
						href="${pageContext.request.contextPath}/preCompletaVaccinoSer?idVaccino=${vaccino.id}&idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
						class="btn btn-success">Completa Vaccinazione</a></td>
				</tr>
			</c:forEach>

		</table>
		<div>
			<a
				href="${pageContext.request.contextPath}/preInserisciVaccinoSer?idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
				class="btn btn-primary btn-md">Inserisci Nuovo Vaccino</a>
		</div>


	</div>

</body>
</html>