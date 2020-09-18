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
		<h1>Documenti Cavallo: ${nomeCavallo}</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Faldone</th>
					<th>Documento</th>
					<th>Cartella</th>
					<th>Azioni</th>
				</tr>
			</thead>

			<c:forEach var="documento" items="${listaDocumentiAttr}">
				<tr>
					<td>${documento.faldone}</td>
					<td>${documento.documento}</td>
					<td><a
						href="${pageContext.request.contextPath}/dati/documenti/${documento.cartella}">link
							cartella</a>(${documento.cartella})</td>
					<td><a
						href="${pageContext.request.contextPath}/dettaglioDocumentoSer?idDocumento=${documento.id}&idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
						class="btn btn-info">Dettaglio</a> <a
						href="${pageContext.request.contextPath}/preModificaDocumentoSer?idDocumento=${documento.id}&idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
						class="btn btn-info">Modifica</a> <a
						href="${pageContext.request.contextPath}/preEliminaDocumentoSer?idDocumento=${documento.id}&idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
						class="btn btn-info">Elimina</a></td>
				</tr>
			</c:forEach>

		</table>
		<div>
			<a
				href="${pageContext.request.contextPath}/preInserisciDocumentoSer?idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
				class="btn btn-primary btn-md">Crea Nuovo Documento</a> <a
				href="${pageContext.request.contextPath}/preCercaDocumentiSer?idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
				class="btn btn-primary btn-md">Cerca Documento</a>
			<c:if test="${!listAll}">
				<a style="float: right"
					href="${pageContext.request.contextPath}/listaDocumentiSer?idCavallo=${idCavallo}&nomeCavallo=${nomeCavallo}"
					class="btn btn-primary btn-md">Mostra Tutti</a>
			</c:if>
		</div>


	</div>
</body>
</html>