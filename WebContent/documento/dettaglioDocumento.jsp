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
				<h3>Dettaglio Documento</h3>
			</div>
			<div class="card-body">


				<table class="table">
					<tbody>
						<tr>
							<th scope="row">Faldone:</th>
							<td>${documentoAttr.faldone}</td>
						</tr>
						<tr>
							<th scope="row">Documento:</th>
							<td>${documentoAttr.documento}</td>
						</tr>
						<tr>
							<th scope="row">Cartella:</th>
							<td><a
								href="${pageContext.request.contextPath}/dati/documenti/${documentoAttr.cartella}">link
									cartella</a>(${documentoAttr.cartella})</td>
						</tr>
						<tr>
							<th scope="row">Note:</th>
							<td>${documentoAttr.note}</td>
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