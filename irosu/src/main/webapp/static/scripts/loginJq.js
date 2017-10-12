/**
 * Cambios para registrar
 */
$(document).ready(function() {
	$("#register").click(function() {
		$(".ocultar").removeClass("ocultar");
		$("#regPassword").css("required", "required");
		$("#btn").text("Registrar");
		$("#register").hide();

		return false;
	});
});