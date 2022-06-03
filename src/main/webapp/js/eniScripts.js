$(document).ready(function () {
	$("#buttonRadioAchat").click(function(){
		if ($("#achatsActifs").attr( "disabled" )) {
			$("#buttonRadioAchat").prop("checked", true);
			$("#radioVentes").prop("checked", false);
			
			$("#achatsActifs").prop("disabled", false);
			$("#encheresActifs").prop("disabled", false);
			$("#encheresFinis").prop("disabled", false);
			
			$("#ventesFinis").prop("disabled", true);
			$("#ventesInactifs").prop("disabled", true);
			$("#ventesActifs").prop("disabled", true);
			$("#ventesFinis").prop("checked", false);
			$("#ventesInactifs").prop("checked", false);
			$("#ventesActifs").prop("checked", false);
			
		}
		else {
			$("#radioAchats").prop("checked", false);
			$("#radioVentes").prop("checked", true);
			
			$("#achatsActifs").prop("disabled", true);
			$("#encheresActifs").prop("disabled", true);
			$("#encheresFinis").prop("disabled", true);
			$("#achatsActifs").prop("checked", false);
			$("#encheresActifs").prop("checked", false);
			$("#encheresFinis").prop("checked", false);
			
			$("#ventesFinis").prop("disabled", false);
			$("#ventesInactifs").prop("disabled", false);
			$("#ventesActifs").prop("disabled", false);
			
		}
	});
	$("#buttonRadioVente").click(function(){
		if ($("#achatsActifs").attr( "disabled" )) {
			$("#buttonRadioAchat").prop("checked", true);
			$("#radioVentes").prop("checked", false);
			
			$("#achatsActifs").prop("disabled", false);
			$("#encheresActifs").prop("disabled", false);
			$("#encheresFinis").prop("disabled", false);
			
			$("#ventesFinis").prop("disabled", true);
			$("#ventesInactifs").prop("disabled", true);
			$("#ventesActifs").prop("disabled", true);
			$("#ventesFinis").prop("checked", false);
			$("#ventesInactifs").prop("checked", false);
			$("#ventesActifs").prop("checked", false);
			
		}
		else {
			$("#radioAchats").prop("checked", false);
			$("#radioVentes").prop("checked", true);
			
			$("#achatsActifs").prop("disabled", true);
			$("#encheresActifs").prop("disabled", true);
			$("#encheresFinis").prop("disabled", true);
			$("#achatsActifs").prop("checked", false);
			$("#encheresActifs").prop("checked", false);
			$("#encheresFinis").prop("checked", false);
			
			$("#ventesFinis").prop("disabled", false);
			$("#ventesInactifs").prop("disabled", false);
			$("#ventesActifs").prop("disabled", false);
			
		}
	});
	
	document.getElementById("debut_enchere").valueAsDate = new Date();
	let oneWeek = new Date();
	oneWeek.setDate(oneWeek.getDate() + 7);
	document.getElementById("fin_enchere").valueAsDate = oneWeek;
	
});