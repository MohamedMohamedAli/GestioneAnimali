<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="block-container">
		<c:if test="${messaggioConferma!=null}">
			<div class="alert alert-success" role="alert">${messaggioConferma}</div>
		</c:if>

		<c:forEach var="animale" items="${listaCavalliAttr}">
			<input type="hidden" name="listaID" value="${animale.id}">
			<input type="hidden" name="listaNomi" value="${animale.nome}">
			<input type="hidden" name="listaSoprannomi"
				value="${animale.soprannome}">
			<input type="hidden" name="listaTipi" value="${animale.tipo}">
			<input type="hidden" name="listaStati" value="${animale.attivo}">
		</c:forEach>


		<div class="dropdown txt-center">
			<button class="btn btn-light dropdown-toggle" type="button"
				id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">Menu</button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
				<a class="dropdown-item" href="${pageContext.request.contextPath}/preInserisciCavalloSer">Inserisci Nuovo Animale</a> 
				<a class="dropdown-item" href="${pageContext.request.contextPath}/preCercaCavalliSer">Cerca Animali</a>
				<a class="dropdown-item" href="${pageContext.request.contextPath}/preCreaFatturaSer">Crea Fattura</a>
				<a class="dropdown-item" href="${pageContext.request.contextPath}/preCercaVacciniSer">Cerca Vaccinazioni Prenotate</a>
				<a class="dropdown-item" href="${pageContext.request.contextPath}/preCercaFerraturePrenotateSer">Cerca Ferrature Prenotate</a>
				<a class="dropdown-item" href="${pageContext.request.contextPath}/preCercaGravidanzeSer">Cerca Gravidanze</a>
			</div>
		</div>
		<br>
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



		<c:if test="${!listAll}">
			<a style="float: right"
				href="${pageContext.request.contextPath}/homeServlet"
				class="btn btn-primary btn-md">Mostra Tutti</a>
		</c:if>


	</div>
</body>
<script>
	elementiPagina = 5;
	numeroPagine = 0;
	pagina = 0;
	listaID = [];
	listaNomi = [];
	listaSoprannomi = [];
	listaStati = [];

	$(document).ready(function() {
// 		$('.dropdown-toggle').dropdown();
		setListe();
		setNumeroPagine();
		setPaginaAttuale(0);
	});

	function setListe() {
		listaID = $("[name='listaID']");
		listaNomi = $("[name='listaNomi']");
		listaSoprannomi = $("[name='listaSoprannomi']");
		listaTipi = $("[name='listaTipi']");
		listaStati = $("[name='listaStati']");
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
		$('.dropdown-toggle').dropdown();
	}

	function creaTabella() {
		$("#tabellaID").empty();
		var elIniziale = pagina * elementiPagina;

		var table = '<table class="table table-striped"><thead>'
		table += "<tr>";
		table += "<th>Nome</th>";
		table += "<th>Soprannome</th>";
		table += "<th>Tipo</th>";
		table += "<th>Stato</th>";
		table += "<th></th>";
		table += "<th></th>";
		table += "</tr></thead>"

		for (var index = 0; index < listaID.length; index++) {
			var i = elIniziale + index;
			if (i >= listaID.length || index >= elementiPagina) {
				break;
			}
			table += "<tr>"
			table += "<td>" + listaNomi[i].value + "</td>";
			table += "<td>" + listaSoprannomi[i].value + "</td>";
			table += "<td><b>" + listaTipi[i].value + "</b></td>";
			var stato = listaStati[i].value == 'true';
			if (stato) {
				table += '<c:if test="${'true'}">';
				table += '<td style="color: green"><b>ATTIVO</b></td></c:if>';
			} else {
				table += '<c:if test="${'true'}">';
				table += '<td style="color: red"><b>DISABILITATO</b></td></c:if>';
			}

			table += "<td>"
					+ pulsantiGestione(listaID[i].value, listaNomi[i].value,
							listaTipi[i].value) + "</td>";
			table += "<td>" + pulsantiAzioni(listaID[i].value, stato) + "</td>";
			table += "</tr>";
		}

		table += "</table>";
		$("#tabellaID").append(table);

	}

	function pulsantiGestione(cavalloID, cavalloNome, tipoAnimale) {
		var gestioni = '';
		gestioni += '<div class="dropdown">';
		gestioni += '<button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestione</button>';
		gestioni += '<div class="dropdown-menu" aria-labelledby="dropdownMenu">';
		
		gestioni += ' <a href="${pageContext.request.contextPath}/listaDocumentiSer?idCavallo=';
		gestioni += cavalloID + '&nomeCavallo=' + cavalloNome + '" class="btn btn-secondary dropdown-item">Documenti</a> ';
		
		gestioni += ' <a href="${pageContext.request.contextPath}/listaAlimentazioneSer?idCavallo=';
		gestioni += cavalloID + '&nomeCavallo=' + cavalloNome + '" class="btn btn-secondary dropdown-item">Alimentazione</a>';
		
		if (tipoAnimale == "CAVALLO") {
			
			gestioni += ' <a href="${pageContext.request.contextPath}/listaFerratureSer?idCavallo=';
			gestioni += cavalloID + '&nomeCavallo=' + cavalloNome + '" class="btn btn-secondary dropdown-item">Ferrature</a> ';
		
		}
		
		gestioni += ' <a href="${pageContext.request.contextPath}/listaVisiteSer?idCavallo=';
		gestioni += cavalloID + '&nomeCavallo=' + cavalloNome + '" class="btn btn-secondary dropdown-item">Visite</a>';
		
		gestioni += ' <a href="${pageContext.request.contextPath}/listaVacciniSer?idCavallo=';
		gestioni += cavalloID + '&nomeCavallo=' + cavalloNome + '" class="btn btn-secondary dropdown-item">Vaccinazioni Prenotate</a>';
		
		gestioni += '</div></div>';
		return gestioni;
	}

	function pulsantiAzioni(cavalloID, cavalloStato) {
		var azioni = '<a href="${pageContext.request.contextPath}/dettaglioCavalloSer?idCavallo='
				+ cavalloID
				+ '" class="btn btn-info">Dettaglio</a> <a href="${pageContext.request.contextPath}/preModificaCavalloSer?idCavallo='
				+ cavalloID
				+ '" class="btn btn-info">Modifica</a> <a href="${pageContext.request.contextPath}/cambiaStatoSer?idCavallo='
				+ cavalloID + '" class="btn btn-info">';
		if (cavalloStato) {
			azioni += '<c:if test="${'true'}">Disabilita</c:if>';
		} else {
			azioni += '<c:if test="${'true'}">Attiva</c:if>';
		}
		azioni += '</a>';
		return azioni;
	}
</script>
</html>
