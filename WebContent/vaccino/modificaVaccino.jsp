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
			action="${pageContext.request.contextPath }/eseModificaVaccinoSer"
			method="post">

			<div class="card text-white bg-info"
				style="position: relative; width: 100%">
				<div class="card-header txt-center">
					<h3>Modifica Vaccino</h3>
				</div>
				<div class="card-body center-card">


					<input type="hidden" value="${idCavallo}" name="idCavallo">
					<input type="hidden" value="${nomeCavallo}" name="nomeCavallo">
					<input type="hidden" value="${vaccinoAttr.id}" name="idVaccino">

					<div class="form-group">
						<h5>
							<label class="control-label" for="tipoInputId"><b>Tipo:</b></label>
						</h5>
						<input class="form-control" type="text" id="tipoInputId"
							name="tipoInput" value="${vaccinoAttr.tipo}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="dataId"><b>Data:</b></label>
						</h5>
						<input class="form-control" type="date" id="dataId"
							name="dataInput" value="${vaccinoAttr.data}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="noteInputId"><b>Note:</b></label>
						</h5>
						<textarea class="form-control" id="noteInputId" name="noteInput"
							rows="7" cols="60">${vaccinoAttr.note}</textarea>
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