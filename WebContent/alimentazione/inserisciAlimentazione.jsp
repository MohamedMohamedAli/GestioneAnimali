<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Alimentazione</title>
</head>
<body>


	<%@ include file="../header.jsp"%>
	<div class="block-container">
		<h1>Animale: ${nomeAnimale}</h1>
	</div>
	<div class="card-container">

		<form class="form-horizontal"
			action="${pageContext.request.contextPath }/eseInserisciAlimentazioneSer"
			method="post">

			<div class="card text-white bg-success"
				style="position: relative; width: 100%">
				<div class="card-header txt-center">
					<h3>Ordina Alimentazione</h3>
				</div>
				<div class="card-body center-card">


					<input type="hidden" value="${idAnimale}" name="idAnimale">
					<input type="hidden" value="${nomeAnimale}" name="nomeAnimale">

					<div class="form-group">
						<h5>
							<label class="control-label" for="quantitaInputId"><b>Quantità:</b></label>
						</h5>
						<input class="form-control" type="number" id="quantitaInputId"
							name="quantitaInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="integratoriInputId"><b>Integratori:</b></label>
						</h5>
						<input class="form-control" type="text" id="integratoriInputId"
							name="integratoriInput">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="dataId"><b>Data:</b></label>
						</h5>
						<input class="form-control" type="date" id="dataId"
							name="dataInput">
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