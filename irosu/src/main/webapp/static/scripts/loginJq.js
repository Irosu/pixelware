/**
 * Cambios para registrar
 */
$(document).ready(function() {
	// Para registrarse
	$("#register").click(function() {
		$("h3").text("New here?");
		$(".ocultar").removeClass("ocultar");
		$(".regist").attr("required", "required");
		$("#btn").text("Register");
		$("#register").hide();
		$("#form").attr("action", "register");

		return false;
	});
});