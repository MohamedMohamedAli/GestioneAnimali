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
			action="${pageContext.request.contextPath }/eseCompletaGravidanzaSer"
			method="post">

			<div class="card text-white bg-success"
				style="position: relative; width: 100%">
				<div class="card-header txt-center">
					<h3>Completa Gravidanza</h3>
				</div>
				<div class="card-body center-card">


					<input type="hidden" value="${gravidanzaAttr.id}"
						name="idGravidanza">

					<div class="form-group">
						<h5>
							<label class="control-label" for="veterinarioInputId"><b>Veterinario:</b></label>
						</h5>
						<input class="form-control" type="text" id="veterinarioInputId"
							name="veterinarioInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="dataId"><b>Data:</b></label>
						</h5>
						<input class="form-control" type="date" id="dataId"
							name="dataInput" value="${dataFine}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="causaInputId"><b>Causa:</b></label>
						</h5>
						<input class="form-control" type="text" id="causaInputId"
							name="causaInput" value="Parto">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="puledroInputId"><b>Nome
									Puledro:</b></label>
						</h5>
						<input class="form-control" type="text" id="puledroInputId"
							name="puledroInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="trattamentoInputId"><b>Trattamento:</b></label>
						</h5>
						<input class="form-control" type="text" id="trattamentoInputId"
							name="trattamentoInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="prezzoInputId"><b>Prezzo:</b></label>
						</h5>
						<input class="form-control" type="text" id="prezzoInputId"
							name="prezzoInput">
						<div id="erroreId" class="div-err">
							<span class="msg-err">Il prezzo può contenere solo numeri.
								Es: [x.x]</span>
						</div>
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
					<button type="submit" id="submitId" class="btn btn-primary btn-md">Conferma</button>
				</div>
			</div>
		</form>
	</div>



</body>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
</html>