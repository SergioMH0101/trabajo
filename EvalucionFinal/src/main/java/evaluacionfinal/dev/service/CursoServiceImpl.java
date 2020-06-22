package evaluacionfinal.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import evaluacionfinal.dev.model.dao.CursoDAO;
import evaluacionfinal.dev.model.dto.CursoDTO;

@Service
public class CursoServiceImpl implements CursoService{
	@Autowired
	CursoDAO cursoDAO;
	@Override
	public List<CursoDTO> list(){
		return cursoDAO.list();
	}
	@Override
	public CursoDTO get(String id_curso) {
		return cursoDAO.get(id_curso);
	}
	@Override
	public int delete(String id_curso) {
		return cursoDAO.delete(id_curso);	
	}
	@Override
	public int insert(CursoDTO cursooDTO) {
		return cursoDAO.insert(cursooDTO);
	}
	@Override
	public int update(CursoDTO cursooDTO) {
		return cursoDAO.update(cursooDTO);
	}

}
