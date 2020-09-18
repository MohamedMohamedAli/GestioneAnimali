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
			action="${pageContext.request.contextPath }/eseModificaDocumentoSer"
			method="post">

			<div class="card text-white bg-info"
				style="position: relative; width: 100%">
				<div class="card-header txt-center">
					<h3>Modifica Documento</h3>
				</div>
				<div class="card-body center-card">

					<input type="hidden" value="${documentoAttr.id}" name="idDocumento">
					<input type="hidden" value="${idCavallo}" name="idCavallo">
					<input type="hidden" value="${nomeCavallo}" name="nomeCavallo">

					<div class="form-group">
						<h5>
							<label class="control-label" for="faldoneInputId"><b>Faldone:</b></label>
						</h5>
						<input class="form-control" type="text" id="faldoneInputId"
							name="faldoneInput" value="${documentoAttr.faldone}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="documentoInputId"><b>Documento:</b></label>
						</h5>
						<input class="form-control" type="text" id="documentoInputId"
							name="documentoInput" value="${documentoAttr.documento}">
					</div>
					<div class="form-group">
						<h5>
							<label class="control-label" for="noteInputId"><b>Note:</b></label>
						</h5>
						<textarea class="form-control" id="noteInputId" name="noteInput"
							rows="7" cols="60">${documentoAttr.note}</textarea>
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
</html>