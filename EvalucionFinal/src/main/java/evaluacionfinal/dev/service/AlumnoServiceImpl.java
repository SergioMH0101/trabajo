package evaluacionfinal.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import evaluacionfinal.dev.model.dao.AlumnoDAO;
import evaluacionfinal.dev.model.dto.AlumnoDTO;


@Service
public class AlumnoServiceImpl implements AlumnoService{
	@Autowired
	AlumnoDAO alumnoDAO;
	@Override
	public List<AlumnoDTO> list(){
		return alumnoDAO.list();
	}
	@Override
	public AlumnoDTO get(String rut) {
		return alumnoDAO.get(rut);
	}
	@Override
	public int delete(String id_cliente) {
		return alumnoDAO.delete(id_cliente);	
	}
	@Override
	public int insert(AlumnoDTO alumnoDTO) {
		return alumnoDAO.insert(alumnoDTO);
	}
	@Override
	public int update(AlumnoDTO alumnoDTO) {
		return alumnoDAO.update(alumnoDTO);
	}
}
