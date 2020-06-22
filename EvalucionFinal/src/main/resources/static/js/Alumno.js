function AlumnoController(option){
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
switch(option){
	
	case "list":
		$.ajax({
			type : "post",
			url : "/Alumno/list",
			success : function(res){
				$("#alumnoTable").bootstrapTable('load',res);
				$("#alumnoTable tbody").on('click','tr', function(){
					$("#rut").val($(this).find("td:eq(0)").text());
					$("#nombre").val($(this).find("td:eq(1)").text());
					$("#curso").val($(this).find("td:eq(2)").text());
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
			url : "/Alumno/get",
			data: "rut=" + $("#rut").val(),
			success : function(res){
				if (res== null || res==""){
					$("#msg").show();
					$("#msg").html("Registro no encontrado")
				}else{
					$("#rut").val(res.rut);
					$("#nombre").val(res.nombre);
					$("#curso").val(res.curso);

					
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
			'rut' : $("#rut").val(),
			'nombre' : $("#nombre").val(),
			'curso' : $("#curso").val(),
					
	}
		var postData= JSON.stringify(json);
		
		$.ajax({
			type : "post",
			url : "/Alumno/insert",
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
			'rut' : $("#rut").val(),
			'nombre' : $("#nombre").val(),
			'curso' : $("#curso").val(),
	
	}
	
		var postData= JSON.stringify(json);
		
		$.ajax({
			type : "post",
			url : "/Alumno/update",
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
			url : "/Alumno/delete",
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