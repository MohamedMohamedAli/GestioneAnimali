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

		<div class="card bg-light" style="position: relative; width: 100%">
			<div class="card-header txt-center">
				<h3>Dettaglio Ferratura</h3>
			</div>
			<div class="card-body">


				<table class="table">
					<tbody>
						<tr>
							<th scope="row">Maniscalco:</th>
							<td>${ferraturaAttr.maniscalco}</td>
						</tr>
						<tr>
							<th scope="row">Data:</th>
							<td>${ferraturaAttr.data}</td>
						</tr>
						<tr>
							<th scope="row">Tipo:</th>
							<td>${ferraturaAttr.tipo}</td>
						</tr>
						<tr>
							<th scope="row">Prezzo:</th>
							<td>${ferraturaAttr.prezzo}&euro;</td>
						</tr>
						<tr>
							<th scope="row">Note:</th>
							<td>${ferraturaAttr.note}</td>
						</tr>
					</tbody>
				</table>




			</div>
			<div class="card-footer txt-center">
				<a href="javascript:history.back()" class="btn btn-primary btn-md">Torna
					Indietro</a>
			</div>
		</div>
	</div>


</body>
</html>