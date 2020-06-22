package evaluacionfinal.dev.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import evaluacionfinal.dev.model.dto.CursoDTO;


@Repository
@Transactional
public class CursoDAOImpl implements CursoDAO{
	private String list = "SELECT * FROM curso ORDER BY id_curso";
	private String select = "SELECT * FROM curso WHERE id_curso=?";
	private String insert = "INSERT INTO curso VALUES (?,?)";
	private String update = "UPDATE curso SET id_curso=?, nombre=? WHERE id_curso=?";
	private String delete = "DELETE curso WHERE id_curso=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<CursoDTO> list() {
		List<CursoDTO> listCursoDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(CursoDTO.class));
		return listCursoDTO;
	}
	@Override
	public CursoDTO get(String id_curso) {
	    Object[] args = {id_curso};
	    CursoDTO cursoDTO;
	    
	    try {
	    	cursoDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(CursoDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	cursoDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	cursoDTO=null;
	    	e.printStackTrace();
	    }
	    return cursoDTO;
	}
	@Override
	public int insert(CursoDTO cursoDTO) {
		int rows = 0;
	    Object[] args = {
	    	
	    		cursoDTO.getId_curso(),
	    		cursoDTO.getNombre()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(CursoDTO cursoDTO) {
		int rows = 0;
	    Object[] args = {
	    		cursoDTO.getId_curso(),
	    		cursoDTO.getNombre()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_curso) {
		int rows = 0;
	    Object[] args = {id_curso};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
}
