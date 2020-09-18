<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Gravidanze</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div class="block-container">
		<c:if test="${messaggioConferma!=null}">
			<div class="alert alert-success" role="alert">${messaggioConferma}</div>
		</c:if>
		<h1>Storico Gravidanze:</h1>

		<c:forEach var="gravidanza" items="${listaGravidanzeAttr}">
			<input type="hidden" name="listaID" value="${gravidanza.id}">
			<input type="hidden" name="listaPadri"
				value="${gravidanza.stallonePadre}">
			<input type="hidden" name="listaFatrici"
				value="${gravidanza.fatrice}">
			<input type="hidden" name="listaInizio"
				value="${gravidanza.dataInizio}">
			<input type="hidden" name="listaFine" value="${gravidanza.dataFine}">
			<input type="hidden" name="listaPuledri" value="${gravidanza.puledro}">
			<input type="hidden" name="listaCompletata" value="${gravidanza.completata}">
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
					href="${pageContext.request.contextPath}/listaGravidanzeSer"
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
	listaPadri = [];
	listaFatrici = [];
	listaInizio = [];
	listaFine = [];
	listaCompletata = [];
	listaPuledri = [];

	$(document).ready(function() {
		setListe();
		setNumeroPagine();
		setPaginaAttuale(0);
	});

	function setListe() {
		listaID = $("[name='listaID']");
		listaPadri = $("[name='listaPadri']");
		listaFatrici = $("[name='listaFatrici']");
		listaInizio = $("[name='listaInizio']");
		listaFine = $("[name='listaFine']");
		listaCompletata = $("[name='listaCompletata']");
		listaPuledri = $("[name='listaPuledri']");
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
		table += "<th>Stallone Padre</th>";
		table += "<th>Fatrice</th>";
		table += "<th>Inizio Gravidanza</th>";
		table += "<th>Parto</th>";
		table += "<th>Puledro</th>";
		table += "<th>Azioni</th>";
		table += "</tr></thead>"

		for (var index = 0; index < listaID.length; index++) {
			var i = elIniziale + index;
			if (i >= listaID.length || index >= elementiPagina) {
				break;
			}
			table += "<tr>"
			table += "<td>" + listaPadri[i].value + "</td>";
			table += "<td>" + listaFatrici[i].value + "</td>";
			table += "<td style='color:green'>" + listaInizio[i].value + "</td>";
			table += "<td style='color:red'>" + listaFine[i].value + " </td>";
			table += "<td>" + listaPuledri[i].value + "</td>";

			table += "<td>" + pulsantiAzioni(listaID[i].value, listaCompletata[i].value) + "</td>";
			table += "</tr>";
		}

		table += "</table>";
		$("#tabellaID").append(table);

	}

	function pulsantiAzioni(ID, completata) {
		var dati = 'idGravidanza=' + ID;
		var azioni = '';
		if(completata == "true"){
			azioni += ' <a href="${pageContext.request.contextPath}/preModificaGravidanzaSer?'+ dati + '" class="btn btn-info">Modifica</a>'
			azioni += ' <a href="${pageContext.request.contextPath}/preEliminaGravidanzaSer?'+ dati + '" class="btn btn-info">Elimina</a>';
		}else{
			azioni += ' <a href="${pageContext.request.contextPath}/preCompletaGravidanzaSer?'+ dati + '" class="btn btn-info">Completa</a>';
		}
		return azioni;
	}
</script>
</html>