package mx.uam.tsis.ejemplobackend.negocio.modelo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Alumno {
	
	@NotNull
	private Integer matricula;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String carrera;
	
	public Integer getMatricula() {
		// TODO Auto-generated method stub
		return matricula;
	}
	
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	public String getCarrera() {
		// TODO Auto-generated method stub
		return carrera;
	}
	
	public void setMatricula(Integer matricula) {
		
	this.matricula=matricula;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
		
	}
	
	public void setCarrera(String carrera) {
	
      this.carrera=carrera;
	}



	
}
