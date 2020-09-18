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
		<c:if test="${messaggioConferma!=null}">
			<div class="alert alert-success" role="alert">${messaggioConferma}</div>
		</c:if>
		<h1>Visite Cavallo: ${nomeCavallo}</h1>

		<input type="hidden" id="cavalloID" value="${idCavallo}"> <input
			type="hidden" id="cavalloNome" value="${nomeCavallo}">
		<c:forEach var="visita" items="${listaVisiteAttr}">
			<input type="hidden" name="listaID" value="${visita.id}">
			<input type="hidden" name="listaCause" value="${visita.causa}">
			<input type="hidden" name="listaTrattamenti"
				value="${visita.trattamento}">
			<input type="hidden" name="listaDate" value="${visita.data}">
			<input type="hidden" name="listaPrezzi" value="${visita.prezzo}">
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
			<a
				href="${pageContext.request.contextPath}/preInserisciVisitaSer?idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
				class="btn btn-primary btn-md">Inserisci Nuova Visita</a> <a
				href="${pageContext.request.contextPath}/preCercaVisiteSer?idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
				class="btn btn-primary btn-md">Cerca Visite</a>
			<c:if test="${!listAll}">
				<a style="float: right"
					href="${pageContext.request.contextPath}/listaVisiteSer?idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
					class="btn btn-primary btn-md">Mostra Tutti</a>
			</c:if>
		</div>


	</div>
</body>
<script>
	elementiPagina = 5;
	numeroPagine = 0;
	pagina = 0;
	listaID = [];
	listaCause = [];
	listaTrattamenti = [];
	listaDate = [];
	listaPrezzi = [];
	cavalloID = "";
	cavalloNome = "";

	$(document).ready(function() {
		setListe();
		setNumeroPagine();
		setPaginaAttuale(0);
	});

	function setListe() {
		cavalloID = $("#cavalloID").val();
		cavalloNome = $("#cavalloNome").val();
		listaID = $("[name='listaID']");
		listaCause = $("[name='listaCause']");
		listaTrattamenti = $("[name='listaTrattamenti']");
		listaDate = $("[name='listaDate']");
		listaPrezzi = $("[name='listaPrezzi']");
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
		table += "<th>Causa</th>";
		table += "<th>Trattamento</th>";
		table += "<th>Data</th>";
		table += "<th>Prezzo</th>";
		table += "<th>Azioni</th>";
		table += "</tr></thead>"

		for (var index = 0; index < listaID.length; index++) {
			var i = elIniziale + index;
			if (i >= listaID.length || index >= elementiPagina) {
				break;
			}

			table += "<tr>"
			table += "<td>" + listaCause[i].value + "</td>";
			table += "<td>" + listaTrattamenti[i].value + "</td>";
			table += "<td>" + listaDate[i].value + "</td>";
			table += "<td>" + listaPrezzi[i].value + "&euro;</td>";

			table += "<td>" + pulsantiAzioni(listaID[i].value) + "</td>";
			table += "</tr>";
		}

		table += "</table>";
		$("#tabellaID").append(table);

	}

	function pulsantiAzioni(visitaID) {
		var dati = 'idVisita=' + visitaID + '&idCavallo=' + cavalloID
				+ '&nomeCavallo=' + cavalloNome;
		var azioni = '<a href="${pageContext.request.contextPath}/dettaglioVisitaSer?'
				+ dati
				+ '" class="btn btn-info">Dettaglio</a> <a href="${pageContext.request.contextPath}/preModificaVisitaSer?'
				+ dati
				+ '" class="btn btn-info">Modifica</a> <a href="${pageContext.request.contextPath}/preEliminaVisitaSer?'
				+ dati + '" class="btn btn-info">Elimina</a>';
		return azioni;
	}
</script>
</html>