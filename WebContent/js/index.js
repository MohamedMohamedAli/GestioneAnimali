$("#prova").click(function() {
	console.log("funziona");
});

$(document).ready(function() {
	$("#erroreId").hide();
	$("#erroreId-2").hide();
});

$("#prezzoInputId").change(function() {
	var prezzoInput = $("#prezzoInputId").val();
	prezzoInput = Number(prezzoInput);
	console.log(prezzoInput);
	if (prezzoInput || prezzoInput == 0) {
		$("#erroreId").slideUp();
		$("#submitId").prop("disabled", false);
	} else {
		$("#erroreId").slideDown();
		$("#submitId").prop("disabled", true);
	}
});

$("#prezzoInputId-2").change(function() {
	var prezzoInput = $("#prezzoInputId-2").val();
	prezzoInput = Number(prezzoInput);
	console.log(prezzoInput);
	if (prezzoInput || prezzoInput == 0) {
		$("#erroreId-2").slideUp();
		$("#submitId").prop("disabled", false);
	} else {
		$("#erroreId-2").slideDown();
		$("#submitId").prop("disabled", true);
	}
});

$("#submitId").click(function() {
	var prezzoInput = $("#prezzoInputId").val();
	var prezzoInput2 = $("#prezzoInputId-2").val();
	prezzoInput = Number(prezzoInput);
	prezzoInput2 = Number(prezzoInput2);
	if (prezzoInput == 0) {
		console.log("setta prezzo1 a 0");
		$("#prezzoInputId").val("0");
	}
	if (prezzoInput2 == 0) {
		console.log("setta prezzo2 a 0");
		$("#prezzoInputId-2").val("");
	}
});

$("#submitVisiteId").click(function() {
	console.log("V");
	$("#tipoFatturaID").val("VISITE");
});

$("#submitFerratureId").click(function() {
	console.log("F");
	$("#tipoFatturaID").val("FERRATURE");
});