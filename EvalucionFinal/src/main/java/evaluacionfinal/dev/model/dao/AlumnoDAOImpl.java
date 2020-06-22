package evaluacionfinal.dev.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import evaluacionfinal.dev.model.dto.AlumnoDTO;

@Repository
@Transactional
public class AlumnoDAOImpl implements AlumnoDAO{
	private String list = "SELECT * FROM alumno ORDER BY rut";
	private String select = "SELECT * FROM alumno WHERE rut=?";
	private String insert = "INSERT INTO alumno VALUES (?,?,?)";
	private String update = "UPDATE alumno SET rut=?, nombre=?, curso=? WHERE rut=?";
	private String delete = "DELETE alumno WHERE rut=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AlumnoDTO> list() {
		List<AlumnoDTO> listAlumnoDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AlumnoDTO.class));
		return listAlumnoDTO;
	}
	@Override
	public AlumnoDTO get(String rut) {
	    Object[] args = {rut};
	    AlumnoDTO alumnoDTO;
	    
	    try {
	    	alumnoDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AlumnoDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	alumnoDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	alumnoDTO=null;
	    	e.printStackTrace();
	    }
	    return alumnoDTO;
	}
	@Override
	public int insert(AlumnoDTO alumnoDTO) {
		int rows = 0;
	    Object[] args = {
	    	
	    		alumnoDTO.getRut(),
	    		alumnoDTO.getNombre(),
	    		alumnoDTO.getCurso()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AlumnoDTO alumnoDTO) {
		int rows = 0;
	    Object[] args = {
	    		alumnoDTO.getRut(),
	    		alumnoDTO.getNombre(),
	    		alumnoDTO.getCurso()
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
