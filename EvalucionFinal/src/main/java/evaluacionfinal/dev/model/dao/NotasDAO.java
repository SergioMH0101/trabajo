package evaluacionfinal.dev.model.dao;

import java.util.List;

import evaluacionfinal.dev.model.dto.NotasDTO;



public interface NotasDAO {
	public List<NotasDTO> list();
	public NotasDTO get(String rut);
	public int insert(NotasDTO notasoDTO);
	public int update(NotasDTO notasoDTO);
	public int delete(String rut);

}
