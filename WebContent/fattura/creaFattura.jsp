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
	<div class="card-container">



		<div class="card text-white bg-warning"
			style="position: relative; width: 100%">
			<div class="card-header txt-center">
				<h3>Crea Fatture</h3>
			</div>
			<div class="card-body ">

				<form class="form-horizontal"
					action="${pageContext.request.contextPath }/eseCreaFatturaSer"
					method="post">
					<input type="hidden" id="tipoFatturaID" value="" name="tipoFattura">


					<div class="form-group row">

						<div class="col-sm-6">
							<h5>
								<label class="control-label" for="dataVisiteDaId"><b>Visite
										Da:</b></label>
							</h5>
							<input class="form-control" type="date" id="dataVisiteDaId"
								name="dataVisiteDaInput">
						</div>

						<div class="col-sm-6">
							<h5>
								<label class="control-label" for="dataVisiteAId"><b>A:</b></label>
							</h5>
							<input class="form-control" type="date" id="dataVisiteAId"
								name="dataVisiteAInput">
						</div>
						<div class="col-sm-12" style="height: 20px"></div>
						<div class="col-sm-12 txt-center">
							<button type="submit" id="submitVisiteId"
								class="btn btn-primary btn-md">Crea Fattura Visite</button>
						</div>
					</div>

					<hr>


					<div class="form-group row">

						<div class="col-sm-6">
							<h5>
								<label class="control-label" for="dataFerratureDaId"><b>Ferrature
										Da:</b></label>
							</h5>
							<input class="form-control" type="date" id="dataFerratureDaId"
								name="dataFerratureDaInput">
						</div>

						<div class="col-sm-6">
							<h5>
								<label class="control-label" for="dataFerratureAId"><b>
										A:</b></label>
							</h5>
							<input class="form-control" type="date" id="dataFerratureAId"
								name="dataFerratureAInput">
						</div>
						<div class="col-sm-12" style="height: 20px"></div>
						<div class="col-sm-12 txt-center">
							<button type="submit" id="submitFerratureId"
								class="btn btn-primary btn-md">Crea Fattura Ferrature</button>
						</div>
					</div>


				</form>

			</div>
			<div class="card-footer txt-center">
				<a href="javascript:history.back()" class="btn btn-primary btn-md">Torna
					Indietro</a>

			</div>
		</div>
	</div>

</body>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
</html>