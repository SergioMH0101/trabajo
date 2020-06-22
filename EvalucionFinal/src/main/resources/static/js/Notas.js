function NotasController(option){
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
	var token = $("meta[name='_csrf']").attr("content");
switch(option){
	
	case "list":
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/Notas/list",
			success : function(res){
				$("#notasTable").bootstrapTable('load',res);
				$("#notasTable tbody").on('click','tr', function(){
					$("#id_curso").val($(this).find("td:eq(0)").text());
					$("#rut").val($(this).find("td:eq(1)").text());
					$("#numero_modulo").val($(this).find("td:eq(2)").text());
					$("#numero_evaluacion").val($(this).find("td:eq(3)").text());
					$("#nota").val($(this).find("td:eq(4)").text());
					$("#myModal").click()
				});
				$("#myModal").modal({show:true})
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error en la busqueda de Cliente");
			}
		});
		break;
		
	case "get":
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/Notas/get",
			data: "rut=" + $("#rut").val(),
			success : function(res){
				if (res== null || res==""){
					$("#msg").show();
					$("#msg").html("Registro no encontrado")
				}else{
					$("#id_curso").val(res.id_curso);
					$("#rut").val(res.rut);
					$("#numero_modulo").val(res.numero_modulo);
					$("#numero_evaluacion").val(res.numero_evaluacion);
					$("#nota").val(res.nota);

					
				}
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error en busqueda de Cliente");
			}
		});
		break;
	case "insert":
		var json = 
	{
			'id_curso' : $("#id_curso").val(),
			'rut' : $("#rut").val(),
			'numero_modulo' : $("#numero_modulo").val(),
			'numero_evaluacion' : $("#numero_evaluacion").val(),
			'nota' : $("#nota").val(),
					
	}
		var postData= JSON.stringify(json);
		
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/Notas/insert",
			data: postData,
			contentType : "application/json; charset=utf-8",
			success : function(res){
				if (res== 1){
					$("#msg").removeClass("alert-danger").addClass("alert-success")
					$("#msg").show();
					$("#msg").html("Registro insertado correctamente")
				}else{
					$("#msg").show();
					$("#msg").html("Error al agregar registro")
				}
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error al agregar registro");
			}
		});
		break;
		
	case "update":
		var json = 
	{
			'id_curso' : $("#id_curso").val(),
			'rut' : $("#rut").val(),
			'numero_modulo' : $("#numero_modulo").val(),
			'numero_evaluacion' : $("#numero_evaluacion").val(),
			'nota' : $("#nota").val(),
	
	}
	
		var postData= JSON.stringify(json);
		
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/Notas/update",
			data: postData,
			contentType : "application/json; charset=utf-8",
			success : function(res){
				if (res== 1){
					$("#msg").removeClass("alert-danger").addClass("alert-success")
					$("#msg").show();
					$("#msg").html("Registro actualizado correctamente")
				}else{
					$("#msg").show();
					$("#msg").html("Error al actualizar registro")
				}
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error al actualizar registro");
			}
		});
		break;
		
	case "delete":
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/Notas/delete",
			data: "rut=" + $("#rut").val(),
			success : function(res){
				if (res==1){
					$("#msg").removeClass("alert-danger").addClass("alert-success")
					$("#msg").show();
					$("#msg").html("Registro eliminado con exito")
				}else{
					$("#msg").show();
					$("#msg").html("Registro no se pudo eliminar ")
				}
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error al eliminar");
			}
		});
		break;
	default:
			$("#msg").show();
			$("#msg").html("Opcion no valida");
	}
	
}