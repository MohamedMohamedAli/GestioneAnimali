$(document).ready(function() {
	var sessoIniziale = $("#sessoIniziale").val();
	var tipoIniziale = $("#tipoIniziale").val();
	var fatriceIniziale = $("#fatriceIniziale").val();
	if (tipoIniziale != "CAVALLO") {
		$("#bloccoSoloCavalloId").hide();
		$("#cavalloFemminaId").hide();
		$("#cavalloFatriceId").hide();
	} else if (sessoIniziale != "F") {
		$("#cavalloFemminaId").hide();
		$("#cavalloFatriceId").hide();
	}else if(fatriceIniziale != "true"){
		$("#cavalloFatriceId").hide();
	}
});

$("#tipoSelectId").change(function() {
	var selected = $("#tipoSelectId").val();
	if (selected == "CAVALLO") {
		$("#bloccoSoloCavalloId").slideDown();
	} else {
		$("#bloccoSoloCavalloId").slideUp();
	}
});

$("#femmina").change(function() {
	$("#cavalloFemminaId").slideDown();
});

$("#maschio").change(function() {
	$("#cavalloFemminaId").slideUp();
});
$("#fatriceId").change(function(){
	var fat = $("#fatriceId:checked").val();
	if(fat == "true"){
		$("#cavalloFatriceId").slideDown();
	}else{
		$("#cavalloFatriceId").slideUp();
	}
});