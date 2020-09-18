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

		<div class="card bg-light" style="position: relative; width: 100%">
			<div class="card-header txt-center">
				<h3>Fattura Ferrature</h3>
			</div>
			<div class="card-body">


				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Soprannome</th>
							<th>Data</th>
							<th>Prezzo</th>
						</tr>
					</thead>

					<c:forEach var="ferratura" items="${listaFerratureAttr}">
						<tr>
							<td>${ferratura.cavallo.nome}</td>
							<td>${ferratura.cavallo.soprannome}</td>
							<td>${ferratura.data}</td>
							<td style="color:red">${ferratura.prezzo}&euro;</td>
						</tr>
					</c:forEach>

				</table>
				<div class="txt-center">
				<b>TOTALE: <span style="color:darkgreen">${totaleAttr}&euro;</span></b>
				</div>




			</div>
			<div class="card-footer txt-center">
				<a href="javascript:history.back()" class="btn btn-primary btn-md">Torna
					Indietro</a>
			</div>
		</div>
	</div>

</body>
</html>
