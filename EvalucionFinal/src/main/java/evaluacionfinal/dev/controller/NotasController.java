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

import evaluacionfinal.dev.model.dto.NotasDTO;
import evaluacionfinal.dev.service.NotasService;

@RestController
@RequestMapping(value="/Notas")
public class NotasController {
	@Autowired
	NotasService notasService;
	@RequestMapping(value="/list")
	public List<NotasDTO> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		List<NotasDTO> list = notasService.list();
		return list;
	}
	@RequestMapping(value="/get")
	public NotasDTO ajaxGet(HttpServletRequest req, HttpServletResponse res) {
		NotasDTO g = notasService.get(req.getParameter("rut"));
		return g;
	}
	
	@RequestMapping(value="/delete")
	public int ajaxDelete(HttpServletRequest req, HttpServletResponse res) {
		int rows = notasService.delete(req.getParameter("rut"));
		return rows;
	}
	
	@RequestMapping(value="/insert")
	public  int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		try {
			String requestData = req.getReader().lines().collect(Collectors.joining());
			NotasDTO i = new Gson().fromJson(requestData, NotasDTO.class);
			rows = notasService.insert(i);
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
			NotasDTO u = new Gson().fromJson(requestData, NotasDTO.class);
			rows = notasService.update(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return rows;
	}
}
