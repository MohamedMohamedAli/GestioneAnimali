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
			action="${pageContext.request.contextPath }/eseInserisciCavalloSer"
			method="post">

			<div class="card text-white bg-success"
				style="position: relative; width: 100%">
				<div class="card-header txt-center">
					<h3>Inserisci Nuovo Animale</h3>
				</div>
				<div class="card-body center-card">



					<div class="form-group">
						<h5>
							<label class="control-label" for="nomeInputId"><b>Nome:</b></label>
						</h5>
						<input class="form-control" type="text" id="nomeInputId"
							name="nomeInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="soprannomeInputId"><b>Soprannome:</b></label>
						</h5>
						<input class="form-control" type="text" id="soprannomeInputId"
							name="soprannomeInput">
					</div>

					<div class="form-group">

						<h5>
							<label class="control-label" for="tipoId"> <b>Tipo
									Animale:</b></label>
						</h5>
						<select class="form-control" name="tipoInput" id="tipoSelectId">
							<option value=""></option>
							<c:forEach var="animale" items="${listaAnimaliAttr}">
								<option value="${animale}">${animale}</option>
							</c:forEach>
						</select>

					</div>
					<div id="bloccoSoloCavalloId">
						<div class="form-group">
							<h5 class="blck-inline">
								<label class="control-label"><b>Sesso:</b></label>
							</h5>
							<div class="rad-styl blck-inline">
								<input type="radio" class="rad-dim" id="maschio"
									name="sessoInput" value="M"> <label for="maschio"><b>M</b></label>
								<input type="radio" class="rad-dim" id="femmina"
									name="sessoInput" value="F"> <label for="femmina"><b>F</b></label>
							</div>

							<div class="form-group">
								<input type="checkbox" id="daCorsaId" name="daCorsaInput"
									value="true"> <label for="daCorsaId"> <b>Da
										Corsa</b></label><br> <input type="checkbox" id="puledroId"
									name="puledroInput" value="true"> <label
									for="puledroId"> <b>Puledro</b></label><br> <input
									type="checkbox" id="rescueId" name="rescueInput" value="true">
								<label for="rescueId"> <b>Rescue</b></label><br>


								<div id="cavalloFemminaId">

									<input type="checkbox" id="fatriceId" name="fatriceInput"
										value="true"> <label for="fatriceId"> <b>Fatrice</b></label><br>
									<div id="cavalloFatriceId">
										<h5>
											<label class="control-label" for="stallonePadreId"><b>Stallone
													Padre:</b></label>
										</h5>
										<input class="form-control" type="text" id="stallonePadreId"
											name="stallonePadreInput">

										<h5>
											<label class="control-label" for="dataGravidanzaId"><b>Data
													Inizio Gravidanza:</b></label>
										</h5>
										<input class="form-control" type="date" id="dataGravidanzaId"
											name="dataGravidanzaInput">
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
							name="dataNascitaInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="proprietarioInputId"><b>Proprietario:</b></label>
						</h5>
						<input class="form-control" type="text" id="proprietarioInputId"
							name="proprietarioInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="coloreInputId"><b>Colore:</b></label>
						</h5>
						<input class="form-control" type="text" id="coloreInputId"
							name="coloreInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="padreInputId"><b>Padre:</b></label>
						</h5>
						<input class="form-control" type="text" id="padreInputId"
							name="padreInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="madreInputId"><b>Madre:</b></label>
						</h5>
						<input class="form-control" type="text" id="madreInputId"
							name="madreInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="microchipInputId"><b>Microchip:</b></label>
						</h5>
						<input class="form-control" type="text" id="microchipInputId"
							name="microchipInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="passaportoInputId"><b>Passaporto:</b></label>
						</h5>
						<input class="form-control" type="text" id="passaportoInputId"
							name="passaportoInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="ricPassaportoInputId"><b>Riconoscimento
									Passaporto:</b></label>
						</h5>
						<input class="form-control" type="text" id="ricPassaportoInputId"
							name="ricPassaportoInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="noteInputId"><b>Note:</b></label>
						</h5>
						<textarea class="form-control" id="noteInputId" name="noteInput"
							rows="7" cols="60"></textarea>
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