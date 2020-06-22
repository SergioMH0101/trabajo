package evaluacionfinal.dev.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import evaluacionfinal.dev.model.dto.NotasDTO;



@Repository
@Transactional
public class NotasDAOImpl implements NotasDAO{
	private String list = "SELECT * FROM notas ORDER BY id_curso";
	private String select = "SELECT * FROM notas WHERE id_curso=?";
	private String insert = "INSERT INTO notas VALUES (?,?,?,?,?)";
	private String update = "UPDATE notas SET id_curso=?, rut=?, numero_modulo=?, numero_evaluacion=?, nota=? WHERE id_curso=?";
	private String delete = "DELETE notas WHERE id_curso=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<NotasDTO> list() {
		List<NotasDTO> listNotasDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(NotasDTO.class));
		return listNotasDTO;
	}
	@Override
	public NotasDTO get(String id_curso) {
	    Object[] args = {id_curso};
	    NotasDTO notasDTO;
	    
	    try {
	    	notasDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(NotasDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	notasDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	notasDTO=null;
	    	e.printStackTrace();
	    }
	    return notasDTO;
	}
	@Override
	public int insert(NotasDTO notasDTO) {
		int rows = 0;
	    Object[] args = {
	    	
	    		notasDTO.getId_curso(),
	    		notasDTO.getRut(),
	    		notasDTO.getNumero_modulo(),
	    		notasDTO.getNumero_evaluacion(),
	    		notasDTO.getNota()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(NotasDTO notasDTO) {
		int rows = 0;
	    Object[] args = {
	    		notasDTO.getId_curso(),
	    		notasDTO.getRut(),
	    		notasDTO.getNumero_modulo(),
	    		notasDTO.getNumero_evaluacion(),
	    		notasDTO.getNota()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String rut) {
		int rows = 0;
	    Object[] args = {rut};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

}
