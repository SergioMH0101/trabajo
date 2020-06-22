package evaluacionfinal.dev.service;

import java.util.List;

import evaluacionfinal.dev.model.dto.CursoDTO;

public interface CursoService {
	public List<CursoDTO> list();
	public CursoDTO get(String id_curso);
	public int insert(CursoDTO cursoDTO);
	public int update(CursoDTO cursoDTO);
	public int delete(String id_curso);
}
