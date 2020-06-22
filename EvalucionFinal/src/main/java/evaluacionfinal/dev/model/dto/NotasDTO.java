package evaluacionfinal.dev.model.dto;

public class NotasDTO {
	private Integer id_curso;
	private Integer rut;
	private Integer numero_modulo;
	private Integer numero_evaluacion;
	private Integer nota;
	public Integer getId_curso() {
		return id_curso;
	}
	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}
	public Integer getRut() {
		return rut;
	}
	public void setRut(Integer rut) {
		this.rut = rut;
	}
	public Integer getNumero_modulo() {
		return numero_modulo;
	}
	public void setNumero_modulo(Integer numero_modulo) {
		this.numero_modulo = numero_modulo;
	}
	public Integer getNumero_evaluacion() {
		return numero_evaluacion;
	}
	public void setNumero_evaluacion(Integer numero_evaluacion) {
		this.numero_evaluacion = numero_evaluacion;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}

}
