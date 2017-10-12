/**
 * Cambios para registrar
 */
$(document).ready(function() {
	
	// Comprobaciones del formulario
	$("#form").submit(function() {
		if(checkPasswords($("#btn"))) {
			$(this).submit();
		}
		
		return false;
	});
	
	// Contraseñas coincidentes en el registro
	var checkPasswords = function(btn) {		
		if(btn.text() == "Register") {
			if($("#password").val() == $("#confPassword").val()) {
				return true;
			}
			
			else {
				alert("Your passwords don't match");
				return false;
			}
		}
		
		else {
			return true;
		}
	}
	
	// Para registrarse
	$("#register").click(function() {
		$("h3").text("Register");
		$(".ocultar").removeClass("ocultar");
		$(".regist").attr("required", "required");
		$("#btn").text("Register");
		$("#register").hide();
		$("#form").attr("action", "register");

		return false;
	});
});