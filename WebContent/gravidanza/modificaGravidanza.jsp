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

		<form class="form-horizontal"
			action="${pageContext.request.contextPath }/eseModificaGravidanzaSer"
			method="post">

			<div class="card text-white bg-info"
				style="position: relative; width: 100%">
				<div class="card-header txt-center">
					<h3>Modifica Gravidanza</h3>
				</div>
				<div class="card-body center-card">

					<input type="hidden" value="${gravidanzaAttr.id}"
						name="idGravidanza">

					<div class="form-group">
						<h5>
							<label class="control-label" for="padreId"><b>Stallone
									Padre:</b></label>
						</h5>
						<input class="form-control" type="text" id="padreId"
							name="padreInput" value="${gravidanzaAttr.stallonePadre}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="fatriceId"><b>Fatrice:</b></label>
						</h5>
						<input class="form-control txt-readonly" type="text"
							id="fatriceId" name="fatriceInput"
							value="${gravidanzaAttr.fatrice}" readOnly>
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="dataInizioId"><b>Data
									Inizio Gravidanza:</b></label>
						</h5>
						<input class="form-control" type="date" id="dataInizioId"
							name="dataInizioInput" value="${gravidanzaAttr.dataInizio}">
					</div>

					<div class="form-group">
						<h5>
							<label class="control-label" for="dataFineId"><b>Data
									Parto:</b></label>
						</h5>
						<input class="form-control" type="date" id="dataFineId"
							name="dataFineInput" value="${gravidanzaAttr.dataFine}">
					</div>


					<div class="form-group">
						<h5>
							<label class="control-label" for="puledroId"><b>Nome
									Puledro:</b></label>
						</h5>
						<input class="form-control" type="text" id="puledroId"
							name="puledroInput" value="${gravidanzaAttr.puledro}">
					</div>


				</div>
				<div class="card-footer txt-center">
					<a href="javascript:history.back()" class="btn btn-primary btn-md">Torna
						Indietro</a>
					<button type="submit" id="submitId" class="btn btn-primary btn-md">Conferma</button>
				</div>
			</div>
		</form>
	</div>


</body>
</html>