<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Gravidanze</title>
</head>
<body>

	<%@ include file="../header.jsp"%>
	<div class="card-container">

		<div class="card text-white bg-dark"
			style="position: relative; width: 100%">
			<div class="card-header txt-center">
				<h3>Confermi la cancellazione della gravidanza con i seguenti
					dati?</h3>
			</div>
			<div class="card-body">


				<table class="table table-sm table-dark">
					<tbody>
						<tr>
							<th scope="row">Stallone Padre:</th>
							<td>${gravidanzaAttr.stallonePadre}</td>
						</tr>
						<tr>
							<th scope="row">Fatrice:</th>
							<td>${gravidanzaAttr.fatrice}</td>
						</tr>
						<tr>
							<th scope="row">Data Inizio Gravidanza:</th>
							<td>${gravidanzaAttr.dataInizio}</td>
						</tr>
						<tr>
							<th scope="row">Data Parto:</th>
							<td>${gravidanzaAttr.dataFine}</td>
						</tr>
						<tr>
							<th scope="row">Puledro:</th>
							<td>${gravidanzaAttr.puledro}</td>
						</tr>
					</tbody>
				</table>

			</div>
			<div class="card-footer txt-center">
				<a href="javascript:history.back()" class="btn btn-primary btn-md">Torna
					Indietro</a> <a
					href="${pageContext.request.contextPath}/eseEliminaGravidanzaSer?idGravidanza=${gravidanzaAttr.id}"
					class="btn btn-info">Conferma</a>
			</div>
		</div>
	</div>


</body>
</html>