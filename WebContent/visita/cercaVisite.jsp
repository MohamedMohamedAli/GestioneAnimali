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

		<form class="form-horizontal"
			action="${pageContext.request.contextPath }/eseCercaVisiteSer"
			method="post">

			<div class="card text-white bg-secondary"
				style="position: relative; width: 100%">
				<div class="card-header txt-center">
					<h3>Cerca Visite</h3>
				</div>
				<div class="card-body center-card">

					<input type="hidden" value="${idCavallo}" name="idCavallo">
					<input type="hidden" value="${nomeCavallo}" name="nomeCavallo">

					<div class="form-group">
						<h5>
							<label class="control-label" for="veterinarioInputId"><b>Veterinario:</b></label>
						</h5>
						<input class="form-control" type="text" id="veterinarioInputId"
							name="veterinarioInput">
					</div>
					<div class="form-group row">

						<div class="col-sm-6">
							<h5>
								<label class="control-label" for="dataDaId"><b>Data
										Da:</b></label>
							</h5>
							<input class="form-control" type="date" id="dataDaId"
								name="dataDaInput">
						</div>

						<div class="col-sm-6">
							<h5>
								<label class="control-label" for="dataAId"><b>Data
										A:</b></label>
							</h5>
							<input class="form-control" type="date" id="dataAId"
								name="dataAInput">
						</div>


					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="causaInputId"><b>Causa:</b></label>
						</h5>
						<input class="form-control" type="text" id="causaInputId"
							name="causaInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="trattamentoInputId"><b>Trattamento:</b></label>
						</h5>
						<input class="form-control" type="text" id="trattamentoInputId"
							name="trattamentoInput">
					</div>
					<div class="form-group row">
						<div class="col-sm-6">
							<h5>
								<label class="control-label" for="prezzoInputId"><b>Prezzo
										Da:</b></label>
							</h5>

							<input class="form-control" type="text" id="prezzoInputId"
								name="prezzoDaInput">
							<div id="erroreId" class="div-err">
								<span class="msg-err">Il prezzo può contenere solo
									numeri. Es: [x.x]</span>
							</div>
						</div>
						<div class="col-sm-6">
							<h5>
								<label class="control-label" for="prezzoInputId-2"><b>Prezzo
										A:</b></label>
							</h5>

							<input class="form-control" type="text" id="prezzoInputId-2"
								name="prezzoAInput">
							<div id="erroreId-2" class="div-err">
								<span class="msg-err">Il prezzo può contenere solo
									numeri. Es: [x.x]</span>
							</div>
						</div>


					</div>


				</div>
				<div class="card-footer txt-center">
					<a href="javascript:history.back()" class="btn btn-primary btn-md">Torna
						Indietro</a>
					<button type="submit" id="submitId" class="btn btn-primary btn-md">Cerca</button>
				</div>
			</div>
		</form>
	</div>

</body>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
</html>