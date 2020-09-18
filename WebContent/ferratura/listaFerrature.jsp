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
		<h1>Ferrature Cavallo: ${nomeCavallo}</h1>

		<input type="hidden" id="cavalloID" value="${idCavallo}"> <input
			type="hidden" id="cavalloNome" value="${nomeCavallo}">
		<c:forEach var="ferratura" items="${listaFerratureAttr}">
			<input type="hidden" name="listaID" value="${ferratura.id}">
			<input type="hidden" name="listaManiscalchi"
				value="${ferratura.maniscalco}">
			<input type="hidden" name="listaDate" value="${ferratura.data}">
			<input type="hidden" name="listaTipi" value="${ferratura.tipo}">
			<input type="hidden" name="listaPrezzi" value="${ferratura.prezzo}">
			<input type="hidden" name="listaCompletati" value="${ferratura.completata}">
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
				href="${pageContext.request.contextPath}/preInserisciFerraturaSer?idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
				class="btn btn-primary btn-md">Prenota Ferratura</a> <a
				href="${pageContext.request.contextPath}/preCercaFerratureSer?idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
				class="btn btn-primary btn-md">Cerca Ferrature</a>
			<c:if test="${!listAll}">
				<a style="float: right"
					href="${pageContext.request.contextPath}/listaFerratureSer?idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
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
	listaManiscalchi = [];
	listaDate = [];
	listaTipi = [];
	listaPrezzi = [];
	listaCompletati = [];
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
		listaManiscalchi = $("[name='listaManiscalchi']");
		listaDate = $("[name='listaDate']");
		listaTipi = $("[name='listaTipi']");
		listaPrezzi = $("[name='listaPrezzi']");
		listaCompletati = $("[name='listaCompletati']");
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
		table += "<th>Maniscalco</th>";
		table += "<th>Data</th>";
		table += "<th>Tipo</th>";
		table += "<th>Prezzo</th>";
		table += "<th>Azioni</th>";
		table += "</tr></thead>"

		for (var index = 0; index < listaID.length; index++) {
			var i = elIniziale + index;
			if (i >= listaID.length || index >= elementiPagina) {
				break;
			}

			table += "<tr>";
			table += "<td>" + listaManiscalchi[i].value + "</td>";
			table += "<td>" + listaDate[i].value + "</td>";
			table += "<td>" + listaTipi[i].value + "</td>";
			table += "<td>" + listaPrezzi[i].value + "&euro;</td>";

			table += "<td>" + pulsantiAzioni(listaID[i].value, listaCompletati[i].value) + "</td>";
			table += "</tr>";
		}

		table += "</table>";
		$("#tabellaID").append(table);

	}

	function pulsantiAzioni(ferraturaID, completata) {
		var dati = 'idFerratura=' + ferraturaID + '&idCavallo=' + cavalloID
				+ '&nomeCavallo=' + cavalloNome;
		var azioni = '';
			azioni += '<a href="${pageContext.request.contextPath}/dettaglioFerraturaSer?' + dati + '" class="btn btn-info">Dettaglio</a>';
			azioni += ' <a href="${pageContext.request.contextPath}/preModificaFerraturaSer?' + dati + '" class="btn btn-info">Modifica</a>';
			azioni += ' <a href="${pageContext.request.contextPath}/preEliminaFerraturaSer?' + dati + '" class="btn btn-info">Elimina</a>';
			if(completata != "true"){
				azioni += ' <a href="${pageContext.request.contextPath}/preCompletaFerraturaSer?' + dati + '" class="btn btn-success">Completa Ferratura</a>';
			}		
		return azioni;
	}
</script>
</html>