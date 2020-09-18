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
			action="${pageContext.request.contextPath }/eseCercaGravidanzeSer"
			method="post">

			<div class="card text-white bg-secondary"
				style="position: relative; width: 100%">
				<div class="card-header txt-center">
					<h3>Cerca Gravidanze</h3>
				</div>
				<div class="card-body center-card">

					<div class="form-group">
						<h5>
							<label class="control-label" for="stallonePadreInputId"><b>Stallone
									Padre:</b></label>
						</h5>
						<input class="form-control" type="text" id="stallonePadreInputId"
							name="stallonePadreInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="fatriceInputId"><b>Fatrice:</b></label>
						</h5>
						<input class="form-control" type="text" id="fatriceInputId"
							name="fatriceInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="puledroInputId"><b>Puledro:</b></label>
						</h5>
						<input class="form-control" type="text" id="puledroInputId"
							name="puledroInput">
					</div>

					<h5>
						<label class="control-label"><b>Data Inizio
								Gravidanza:</b></label>
					</h5>
					<div class="form-group row">
						<div class="col-sm-6">
							<h5>
								<label class="control-label" for="dataInizioDaId">Da</label>
							</h5>
							<input class="form-control" type="date" id="dataInizioDaId"
								name="dataInizioDaInput">
						</div>

						<div class="col-sm-6">
							<h5>
								<label class="control-label" for="dataInizioAId">A</label>
							</h5>
							<input class="form-control" type="date" id="dataInizioAId"
								name="dataInizioAInput">
						</div>
					</div>
					<h5>
						<label class="control-label"><b>Data Parto:</b></label>
					</h5>
					<div class="form-group row">

						<div class="col-sm-6">

							<h5>
								<label class="control-label" for="dataDaId">Da</label>
							</h5>
							<input class="form-control" type="date" id="dataPartoDaId"
								name="dataDaInput">
						</div>

						<div class="col-sm-6">
							<h5>
								<label class="control-label" for="dataPartoAId">A</label>
							</h5>
							<input class="form-control" type="date" id="dataPartoAId"
								name="dataPartoAInput">
						</div>
					</div>


				</div>
				<div class="card-footer txt-center">
					<a href="javascript:history.back()" class="btn btn-primary btn-md">Torna
						Indietro</a>
					<button type="submit" class="btn btn-primary btn-md">Cerca</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>