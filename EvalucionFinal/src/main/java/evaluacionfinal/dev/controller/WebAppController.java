package evaluacionfinal.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebAppController {
	@RequestMapping("/")
	public String getHome(){
		return "index";
	}

	@RequestMapping("/Alumno")
	public String getAlumno(){
		return "Alumno";
	}
	
	@RequestMapping("/Curso")
	public String getCurso(){
		return "Curso";
	}
	@RequestMapping("/Notas")
	public String getNotas() {
		return "Notas";
	}
}
