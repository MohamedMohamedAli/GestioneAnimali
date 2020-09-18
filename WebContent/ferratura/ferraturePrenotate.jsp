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
		<c:if test="${messaggioConferma!=null}">
			<div class="alert alert-success" role="alert">${messaggioConferma}</div>
		</c:if>

		<c:forEach var="ferratura" items="${listaFerratureAttr}">
			<input type="hidden" name="listaID" value="${ferratura.id}">
			<input type="hidden" name="listaNomi" value="${ferratura.cavallo.nome}">
			<input type="hidden" name="listaSoprannomi" value="${ferratura.cavallo.soprannome}">
			<input type="hidden" name="listaDate" value="${ferratura.data}">
			<input type="hidden" name="forListAll" value="forListAll">
		</c:forEach>


		<div id="tabellaID"></div>


		<div class="txt-center">
			<button type="button" class="btn btn-outline-primary"
				onClick="setPaginaAttuale(-1)">Precedente</button>
			<button type="button" class="btn btn-light">
				<span id="pagAttualeID">1</span>
			</button>
			<button type="button" class="btn btn-outline-primary"
				onClick="setPaginaAttuale(1)">Successiva</button>
		</div>
		<br>


		<div>
			<c:if test="${!listAll}">
				<a style="float: right"
					href="${pageContext.request.contextPath}/ferraturePrenotateSer?"
					class="btn btn-primary btn-md">Mostra Lista Completa</a>
			</c:if>
		</div>


	</div>
</body>
<script>
	elementiPagina = 5;
	numeroPagine = 0;
	pagina = 0;
	listaID = [];
	listaNomi = [];
	listaSoprannomi = [];
	listaDate = [];
	listaTipi = [];

	$(document).ready(function() {
		setListe();
		setNumeroPagine();
		setPaginaAttuale(0);
	});

	function setListe() {
		listaID = $("[name='listaID']");
		listaNomi = $("[name='listaNomi']");
		listaSoprannomi = $("[name='listaSoprannomi']");
		listaDate = $("[name='listaDate']");
	}

	function setNumeroPagine() {
		numeroPagine = Math.ceil(listaID.length / elementiPagina);
	}

	function setPaginaAttuale(n) {
		pagina = pagina + n;
		if (pagina <= 0) {
			pagina = 0;
		}
		if (pagina >= numeroPagine) {
			pagina = numeroPagine - 1;
		}
		var pagDaMostrare = pagina + 1;
		$("#pagAttualeID").html(pagDaMostrare);
		creaTabella();
	}

	function creaTabella() {
		$("#tabellaID").empty();
		var elIniziale = pagina * elementiPagina;

		var table = '<table class="table table-striped"><thead>'
		table += "<tr>";
		table += "<th>Nome Cavallo</th>";
		table += "<th>Soprannome Cavallo</th>";
		table += "<th>Data Prenotazione</th>";
		table += "<th>Azioni</th>";
		table += "</tr></thead>"

		for (var index = 0; index < listaID.length; index++) {
			var i = elIniziale + index;
			if (i >= listaID.length || index >= elementiPagina) {
				break;
			}

			table += "<tr>"
			table += "<td>" + listaNomi[i].value + "</td>";
			table += "<td>" + listaSoprannomi[i].value + "</td>";
			table += "<td>" + listaDate[i].value + "</td>";

			table += "<td>" + pulsantiAzioni(listaID[i].value) + "</td>";
			table += "</tr>";
		}

		table += "</table>";
		$("#tabellaID").append(table);

	}

	function pulsantiAzioni(ferraturaID) {
		var dati = 'idFerratura=' + ferraturaID +'&forAllList=true';
		var azioni = '<a href="${pageContext.request.contextPath}/preCompletaFerraturaSer?' + dati + '" class="btn btn-success">Completa Ferratura</a>';
		return azioni;
	}
</script>
</html>
