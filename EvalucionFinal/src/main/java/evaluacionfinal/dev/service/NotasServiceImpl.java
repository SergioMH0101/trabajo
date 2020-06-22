package evaluacionfinal.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import evaluacionfinal.dev.model.dao.NotasDAO;
import evaluacionfinal.dev.model.dto.NotasDTO;


@Service
public class NotasServiceImpl implements NotasService{
	@Autowired
	NotasDAO notasDAO;
	@Override
	public List<NotasDTO> list(){
		return notasDAO.list();
	}
	@Override
	public NotasDTO get(String id_curso) {
		return notasDAO.get(id_curso);
	}
	@Override
	public int delete(String rut) {
		return notasDAO.delete(rut);	
	}
	@Override
	public int insert(NotasDTO notasDTO) {
		return notasDAO.insert(notasDTO);
	}
	@Override
	public int update(NotasDTO notasDTO) {
		return notasDAO.update(notasDTO);
	}
}
