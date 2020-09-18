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
		<c:if test="${messaggioConferma!=null}">
			<div class="alert alert-success" role="alert">${messaggioConferma}</div>
		</c:if>
		<h1>Alimentazione Animale: ${nomeAnimale}</h1>

		<input type="hidden" id="animaleID" value="${idAnimale}"> <input
			type="hidden" id="animaleNome" value="${nomeAnimale}">
		<c:forEach var="alimentazione" items="${listaAlimentazioneAttr}">
			<input type="hidden" name="listaID" value="${alimentazione.id}">
			<input type="hidden" name="listaQuantita" value="${alimentazione.quantita}">
			<input type="hidden" name="listaIntegratori"
				value="${alimentazione.integratori}">
			<input type="hidden" name="listaDate" value="${alimentazione.data}">
			<input type="hidden" name="listaPrezzi" value="${alimentazione.prezzo}">
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
				href="${pageContext.request.contextPath}/preInserisciAlimentazioneSer?idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
				class="btn btn-primary btn-md">Ordina Alimentazione</a> <a
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
	listaQuantita = [];
	listaIntegratori = [];
	listaDate = [];
	listaPrezzi = [];
	animaleID = "";
	animaleNome = "";

	$(document).ready(function() {
		setListe();
		setNumeroPagine();
		setPaginaAttuale(0);
	});

	function setListe() {
		cavalloID = $("#animaleID").val();
		cavalloNome = $("#animaleNome").val();
		listaID = $("[name='listaID']");
		listaQuantita = $("[name='listaQuantita']");
		listaIntegratori = $("[name='listaIntegratori']");
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
		table += "<th>Quantità</th>";
		table += "<th>Integratori</th>";
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
			table += "<td>" + listaQuantita[i].value + "</td>";
			table += "<td>" + listaIntegratori[i].value + "</td>";
			table += "<td>" + listaDate[i].value + "</td>";
			table += "<td>" + listaPrezzi[i].value + "&euro;</td>";

			table += "<td>" + pulsantiAzioni(listaID[i].value) + "</td>";
			table += "</tr>";
		}

		table += "</table>";
		$("#tabellaID").append(table);

	}

	function pulsantiAzioni(alimentazioneID) {
		var dati = 'idAlimentazione=' + alimentazioneID + '&idCavallo=' + animaleID + '&nomeCavallo=' + animaleNome;
		var azioni = '<a href="${pageContext.request.contextPath}/dettaglioAlimentazioneSer?'
				+ dati + '" class="btn btn-info">Dettaglio</a>' 
				+ ' <a href="${pageContext.request.contextPath}/preModificaAlimentazioneSer?'
				+ dati + '" class="btn btn-info">Modifica</a>' 
				+ ' <a href="${pageContext.request.contextPath}/preEliminaAlimentazioneSer?'
				+ dati + '" class="btn btn-info">Elimina</a>';
		return azioni;
	}
</script>
</html>