package evaluacionfinal.dev.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import evaluacionfinal.dev.model.dto.AlumnoDTO;
import evaluacionfinal.dev.service.AlumnoService;

@RestController
@RequestMapping(value="/Alumno")
public class AlumnoController {
	@Autowired
	AlumnoService alumnnoService;
	@RequestMapping(value="/list")
	public List<AlumnoDTO> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		List<AlumnoDTO> list = alumnnoService.list();
		return list;
	}
	@RequestMapping(value="/get")
	public AlumnoDTO ajaxGet(HttpServletRequest req, HttpServletResponse res) {
		AlumnoDTO g = alumnnoService.get(req.getParameter("rut"));
		return g;
	}
	
	@RequestMapping(value="/delete")
	public int ajaxDelete(HttpServletRequest req, HttpServletResponse res) {
		int rows = alumnnoService.delete(req.getParameter("rut"));
		return rows;
	}
	
	@RequestMapping(value="/insert")
	public  int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		try {
			String requestData = req.getReader().lines().collect(Collectors.joining());
			AlumnoDTO i = new Gson().fromJson(requestData, AlumnoDTO.class);
			rows = alumnnoService.insert(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return rows;
	}
	
	@RequestMapping(value="/update")
	public  int ajaxUpdate(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		try {
			String requestData = req.getReader().lines().collect(Collectors.joining());
			AlumnoDTO u = new Gson().fromJson(requestData, AlumnoDTO.class);
			rows = alumnnoService.update(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return rows;
	}
			

}
