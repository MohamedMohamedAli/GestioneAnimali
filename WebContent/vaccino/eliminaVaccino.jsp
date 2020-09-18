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
		<h1>Cavallo: ${nomeCavallo}</h1>
	</div>

	<div class="card-container">

		<div class="card text-white bg-dark"
			style="position: relative; width: 100%">
			<div class="card-header txt-center">
				<h3>Confermi la cancellazione del vaccino con i seguenti dati?</h3>
			</div>
			<div class="card-body">


				<table class="table table-sm table-dark">
					<tbody>
						<tr>
							<th scope="row">Tipo:</th>
							<td>${vaccinoAttr.tipo}</td>
						</tr>
						<tr>
							<th scope="row">Data:</th>
							<td>${vaccinoAttr.data}</td>
						</tr>
						<tr>
							<th scope="row">Note:</th>
							<td>${vaccinoAttr.note}</td>
						</tr>
					</tbody>
				</table>




			</div>
			<div class="card-footer txt-center">
				<a href="javascript:history.back()" class="btn btn-primary btn-md">Torna
					Indietro</a> <a
					href="${pageContext.request.contextPath}/eseEliminaVaccinoSer?idVaccino=${vaccinoAttr.id}&idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
					class="btn btn-info">Conferma</a>
			</div>
		</div>
	</div>


</body>
</html>