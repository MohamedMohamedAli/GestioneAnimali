<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Ferrature</title>
</head>
<body>


	<%@ include file="../header.jsp"%>
	<div class="block-container">
		<h1>Cavallo: ${nomeCavallo}</h1>
	</div>
	<div class="card-container">

		<form class="form-horizontal"
			action="${pageContext.request.contextPath }/eseCercaFerraturePrenotateSer"
			method="post">

			<div class="card text-white bg-secondary"
				style="position: relative; width: 100%">
				<div class="card-header txt-center">
					<h3>Cerca Ferrature</h3>
				</div>
				<div class="card-body center-card">

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
							<label class="control-label" for="tipoInputId"><b>Tipo:</b></label>
						</h5>
						<input class="form-control" type="text" id="tipoInputId"
							name="tipoInput">
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
</html>