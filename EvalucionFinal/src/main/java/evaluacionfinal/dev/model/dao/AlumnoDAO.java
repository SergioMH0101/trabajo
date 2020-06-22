package evaluacionfinal.dev.model.dao;

import java.util.List;

import evaluacionfinal.dev.model.dto.AlumnoDTO;



public interface AlumnoDAO {
	public List<AlumnoDTO> list();
	public AlumnoDTO get(String rut);
	public int insert(AlumnoDTO alumnoDTO);
	public int update(AlumnoDTO alumnoDTO);
	public int delete(String rut);
}
