<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestisci Cavalli</title>
</head>
<body>

	<%@ include file="../header.jsp"%>
	<div class="block-container">
		<h1>Cavallo: ${nomeCavallo}</h1>
	</div>
	<div class="card-container">

		<form class="form-horizontal"
			action="${pageContext.request.contextPath }/eseModificaFerraturaSer"
			method="post">

			<div class="card text-white bg-info"
				style="position: relative; width: 100%">
				<div class="card-header txt-center">
					<h3>Modifica Ferratura</h3>
				</div>
				<div class="card-body center-card">

					<input type="hidden" value="${idCavallo}" name="idCavallo">
					<input type="hidden" value="${ferraturaAttr.id}" name="idFerratura">
					<input type="hidden" value="${nomeCavallo}" name="nomeCavallo">
					<c:if test="${ferraturaAttr.completata}">
						<div class="form-group">
							<h5>
								<label class="control-label" for="maniscalcoInputId"><b>Maniscalco:</b></label>
							</h5>
							<input class="form-control" type="text" id="maniscalcoInputId"
								name="maniscalcoInput" value="${ferraturaAttr.maniscalco}">
						</div>
						<div class="form-group">
							<h5>
								<label class="control-label" for="prezzoInputId"><b>Prezzo:</b></label>
							</h5>
							<input class="form-control" type="text" id="prezzoInputId"
								name="prezzoInput" value="${ferraturaAttr.prezzo}">
							<div id="erroreId" class="div-err">
								<span class="msg-err">Il prezzo può contenere solo
									numeri. Es: [x.x]</span>
							</div>
						</div>
					</c:if>

					<div class="form-group">
						<h5>
							<label class="control-label" for="dataId"><b>Data:</b></label>
						</h5>
						<input class="form-control" type="date" id="dataId"
							name="dataInput" value="${ferraturaAttr.data}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="tipoInputId"><b>Tipo:</b></label>
						</h5>
						<input class="form-control" type="text" id="tipoInputId"
							name="tipoInput" value="${ferraturaAttr.tipo}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="noteInputId"><b>Note:</b></label>
						</h5>
						<textarea class="form-control" id="noteInputId" name="noteInput"
							rows="7" cols="60">${ferraturaAttr.note}</textarea>
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