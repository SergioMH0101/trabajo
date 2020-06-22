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

import evaluacionfinal.dev.model.dto.CursoDTO;
import evaluacionfinal.dev.service.CursoService;


@RestController
@RequestMapping(value="/Curso")
public class CursoController {
	@Autowired
	CursoService cursoService;
	@RequestMapping(value="/list")
	public List<CursoDTO> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		List<CursoDTO> list = cursoService.list();
		return list;
	}
	@RequestMapping(value="/get")
	public CursoDTO ajaxGet(HttpServletRequest req, HttpServletResponse res) {
		CursoDTO g = cursoService.get(req.getParameter("id_curso"));
		return g;
	}
	
	@RequestMapping(value="/delete")
	public int ajaxDelete(HttpServletRequest req, HttpServletResponse res) {
		int rows = cursoService.delete(req.getParameter("id_curso"));
		return rows;
	}
	
	@RequestMapping(value="/insert")
	public  int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		try {
			String requestData = req.getReader().lines().collect(Collectors.joining());
			CursoDTO i = new Gson().fromJson(requestData, CursoDTO.class);
			rows = cursoService.insert(i);
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
			CursoDTO u = new Gson().fromJson(requestData, CursoDTO.class);
			rows = cursoService.update(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return rows;
	}
}
