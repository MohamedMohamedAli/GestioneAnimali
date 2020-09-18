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

		<form class="form-horizontal"
			action="${pageContext.request.contextPath }/eseModificaCavalloSer"
			method="post">

			<div class="card text-white bg-info"
				style="position: relative; width: 100%">
				<div class="card-header txt-center">
					<h3>Modifica Animale</h3>
				</div>
				<div class="card-body center-card">

					<input type="hidden" value="${cavalloAttr.id}"
						name="idCavalloInput"> <input type="hidden"
						value="${cavalloAttr.attivo}" name="attivoInput"> <input
						type="hidden" value="${cavalloAttr.sesso}" id="sessoIniziale">
					<input type="hidden" value="${cavalloAttr.tipo}" id="tipoIniziale">
					<input type="hidden" value="${cavalloAttr.fatrice}" id="fatriceIniziale">
					<div class="form-group">

						<h5>
							<label class="control-label" for="nomeInputId"><b>Nome:</b></label>
						</h5>
						<input class="form-control" type="text" id="nomeInputId"
							name="nomeInput" value="${cavalloAttr.nome}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="soprannomeInputId"><b>Soprannome:</b></label>
						</h5>
						<input class="form-control" type="text" id="soprannomeInputId"
							name="soprannomeInput" value="${cavalloAttr.soprannome}">
					</div>



					<div class="form-group">

						<h5>
							<label class="control-label" for="tipoId"> <b>Tipo
									Animale:</b></label>
						</h5>
						<select class="form-control" name="tipoInput" id="tipoSelectId">
							<option value=""></option>
							<c:forEach var="animale" items="${listaAnimaliAttr}">
								<c:if test="${cavalloAttr.tipo == animale}">
									<option selected value="${animale}">${animale}</option>
								</c:if>
								<c:if test="${cavalloAttr.tipo != animale}">
									<option value="${animale}">${animale}</option>
								</c:if>
							</c:forEach>
						</select>

					</div>
					<div id="bloccoSoloCavalloId">
						<div class="form-group">
							<h5 class="blck-inline">
								<label class="control-label"><b>Sesso:</b></label>
							</h5>
							<div class="rad-styl blck-inline">
								<c:if test="${cavalloAttr.sesso == 'M'}">
									<input type="radio" class="rad-dim" id="maschio"
										name="sessoInput" value="M" checked>
									<label for="maschio"><b>M</b></label>
									<input type="radio" class="rad-dim" id="femmina"
										name="sessoInput" value="F">
									<label for="femmina"><b>F</b></label>
								</c:if>
								<c:if test="${cavalloAttr.sesso == 'F'}">
									<input type="radio" class="rad-dim" id="maschio"
										name="sessoInput" value="M">
									<label for="maschio"><b>M</b></label>
									<input type="radio" class="rad-dim" id="femmina"
										name="sessoInput" value="F" checked>
									<label for="femmina"><b>F</b></label>
								</c:if>
								<c:if test="${cavalloAttr.sesso == null}">
									<input type="radio" class="rad-dim" id="maschio"
										name="sessoInput" value="M">
									<label for="maschio"><b>M</b></label>
									<input type="radio" class="rad-dim" id="femmina"
										name="sessoInput" value="F">
									<label for="femmina"><b>F</b></label>
								</c:if>
							</div>

							<div class="form-group">


								<c:if test="${cavalloAttr.daCorsa}">
									<input type="checkbox" id="daCorsaId" name="daCorsaInput"
										checked value="true">
								</c:if>
								<c:if test="${!cavalloAttr.daCorsa}">
									<input type="checkbox" id="daCorsaId" name="daCorsaInput"
										value="true">
								</c:if>
								<label for="daCorsaId"> <b>Da Corsa</b></label><br>
								<c:if test="${cavalloAttr.puledro}">
									<input type="checkbox" id="puledroId" name="puledroInput"
										checked value="true">
								</c:if>
								<c:if test="${!cavalloAttr.puledro}">
									<input type="checkbox" id="puledroId" name="puledroInput"
										value="true">
								</c:if>
								<label for="puledroId"> <b>Puledro</b></label><br>

								<c:if test="${cavalloAttr.rescue}">
									<input type="checkbox" id="rescueId" name="rescueInput" checked
										value="true">
								</c:if>
								<c:if test="${!cavalloAttr.rescue}">
									<input type="checkbox" id="rescueId" name="rescueInput"
										value="true">
								</c:if>
								<label for="rescueId"> <b>Rescue</b></label><br>


								<div id="cavalloFemminaId">
									<c:if test="${cavalloAttr.fatrice}">
										<input type="checkbox" id="fatriceId" name="fatriceInput"
											checked value="true">
									</c:if>
									<c:if test="${!cavalloAttr.fatrice}">
										<input type="checkbox" id="fatriceId" name="fatriceInput"
											value="true">
									</c:if>
									<label for="fatriceId"> <b>Fatrice</b></label><br>
									
									<div id="cavalloFatriceId">
										<h5>
											<label class="control-label" for="stallonePadreId"><b>Stallone
													Padre:</b></label>
										</h5>
										<input class="form-control" type="text" id="stallonePadreId"
											name="stallonePadreInput"
											value="${gravidanzaAttr.stallonePadre}">

										<h5>
											<br> <label class="control-label" for="dataGravidanzaId"><b>Data
													Inizio Gravidanza:</b></label>
										</h5>
										<input class="form-control" type="date" id="dataGravidanzaId"
											name="dataGravidanzaInput"
											value="${gravidanzaAttr.dataInizio}">
									</div>
									

								</div>
							</div>
						</div>
					</div>





					<div class="form-group">
						<h5>
							<label class="control-label" for="dataNascitaId"><b>Data
									Di Nascita:</b></label>
						</h5>
						<input class="form-control" type="date" id="dataNascitaId"
							name="dataNascitaInput" value="${cavalloAttr.dataNascita}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="proprietarioInputId"><b>Proprietario:</b></label>
						</h5>
						<input class="form-control" type="text" id="proprietarioInputId"
							name="proprietarioInput" value="${cavalloAttr.proprietario}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="coloreInputId"><b>Colore:</b></label>
						</h5>
						<input class="form-control" type="text" id="coloreInputId"
							name="coloreInput" value="${cavalloAttr.colore}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="padreInputId"><b>Padre:</b></label>
						</h5>
						<input class="form-control" type="text" id="padreInputId"
							name="padreInput" value="${cavalloAttr.padre}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="madreInputId"><b>Madre:</b></label>
						</h5>
						<input class="form-control" type="text" id="madreInputId"
							name="madreInput" value="${cavalloAttr.madre}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="microchipInputId"><b>Microchip:</b></label>
						</h5>
						<input class="form-control" type="text" id="microchipInputId"
							name="microchipInput" value="${cavalloAttr.microchip}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="passaportoInputId"><b>Passaporto:</b></label>
						</h5>
						<input class="form-control" type="text" id="passaportoInputId"
							name="passaportoInput" value="${cavalloAttr.passaporto}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="ricPassaportoInputId"><b>Riconoscimento
									Passaporto:</b></label>
						</h5>
						<input class="form-control" type="text" id="ricPassaportoInputId"
							name="ricPassaportoInput"
							value="${cavalloAttr.riconoscimentoPassaporto}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="noteInputId"><b>Note:</b></label>
						</h5>
						<textarea class="form-control" id="noteInputId" name="noteInput"
							rows="7" cols="60">${cavalloAttr.note}</textarea>
					</div>



				</div>
				<div class="card-footer txt-center">
					<a href="javascript:history.back()" class="btn btn-primary btn-md">Torna
						Indietro</a>
					<button type="submit" class="btn btn-primary btn-md">Conferma</button>
				</div>
			</div>
		</form>
	</div>


</body>
<script src="${pageContext.request.contextPath}/js/js_tipoAnimale.js"></script>
</html>