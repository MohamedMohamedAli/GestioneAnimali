<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Animali</title>
</head>
<body>
	<%@ include file="../header.jsp"%>


	<div class="card-container">

		<div class="card bg-light" style="position: relative; width: 100%">
			<div class="card-header txt-center">
				<h3>Dettaglio Animale</h3>
			</div>
			<div class="card-body">
				<div class="txt-center">
					<img
						src="${pageContext.request.contextPath}/dati/foto/${cavalloAttr.foto}"
						alt="${cavalloAttr.nome}" width="600" height="400">
					<p>${cavalloAttr.foto}</p>
				</div>
				<table class="table">
					<tbody>
						<tr>
							<th scope="row">Nome:</th>
							<td>${cavalloAttr.nome}</td>
						</tr>
						<tr>
							<th scope="row">Soprannome:</th>
							<td>${cavalloAttr.soprannome}</td>
						</tr>
						<tr>
							<th scope="row">Tipo Animale:</th>
							<td>${cavalloAttr.tipo}</td>
						</tr>
						<c:if test="${cavalloAttr.tipo == 'CAVALLO'}">
							<tr>
								<th scope="row">Sesso:</th>
								<td>${cavalloAttr.sesso}</td>
							</tr>
							<tr>
								<th scope="row">Da Corsa:</th>
								<c:if test="${cavalloAttr.daCorsa}">
									<td style="color: darkgreen"><b>SI</b></td>
								</c:if>
								<c:if test="${!cavalloAttr.daCorsa}">
									<td style="color: red"><b>NO</b></td>
								</c:if>
							</tr>
							<tr>
								<th scope="row">Rescue:</th>
								<c:if test="${cavalloAttr.rescue}">
									<td style="color: green"><b>SI</b></td>
								</c:if>
								<c:if test="${!cavalloAttr.rescue}">
									<td style="color: red"><b>NO</b></td>
								</c:if>
							</tr>
							<tr>
								<th scope="row">Puledro:</th>
								<c:if test="${cavalloAttr.puledro}">
									<td style="color: green"><b>SI</b></td>
								</c:if>
								<c:if test="${!cavalloAttr.puledro}">
									<td style="color: red"><b>NO</b></td>
								</c:if>
							</tr>
							<c:if test="${cavalloAttr.sesso == 'F'}">
								<tr>
									<th scope="row">Fatrice:</th>
									<c:if test="${cavalloAttr.fatrice}">
										<td style="color: green"><b>SI</b></td>
									</c:if>
									<c:if test="${!cavalloAttr.fatrice}">
										<td style="color: red"><b>NO</b></td>
									</c:if>
								</tr>
								<c:if test="${cavalloAttr.fatrice}">
									<tr>
										<th scope="row">Stallone Padre:</th>
										<td>${cavalloAttr.stallonePadre}</td>
									</tr>
								</c:if>
							</c:if>

						</c:if>
						<tr>
							<th scope="row">Data Di Nascita:</th>
							<td>${cavalloAttr.dataNascita}</td>
						</tr>
						<tr>
							<th scope="row">Proprietario:</th>
							<td>${cavalloAttr.proprietario}</td>
						</tr>
						<tr>
							<th scope="row">Colore:</th>
							<td>${cavalloAttr.colore}</td>
						</tr>
						<tr>
							<th scope="row">Padre:</th>
							<td>${cavalloAttr.padre}</td>
						</tr>
						<tr>
							<th scope="row">Madre:</th>
							<td>${cavalloAttr.madre}</td>
						</tr>
						<tr>
							<th scope="row">Microchip:</th>
							<td>${cavalloAttr.microchip}</td>
						</tr>
						<tr>
							<th scope="row">Passaporto:</th>
							<td>${cavalloAttr.passaporto}</td>
						</tr>
						<tr>
							<th scope="row">Riconoscimento Passaporto:</th>
							<td>${cavalloAttr.riconoscimentoPassaporto}</td>
						</tr>
						<tr>
							<th scope="row">Stato:</th>
							<c:if test="${cavalloAttr.attivo}">
								<th style="color: green;">ATTIVO</th>
							</c:if>
							<c:if test="${!cavalloAttr.attivo}">
								<th style="color: red;">DISABILITATO</th>
							</c:if>
						</tr>
						<tr>
							<th scope="row">Note:</th>
							<td>${cavalloAttr.note}</td>
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