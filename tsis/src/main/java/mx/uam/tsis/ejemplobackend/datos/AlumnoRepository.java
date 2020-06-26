package mx.uam.tsis.ejemplobackend.datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import mx.uam.tsis.ejemplobackend.negocio.modelo.Alumno;
/**
 * 
 * @author susan~
 *se encarga de almacenar y recuperar datos 
 */
@Component
public class AlumnoRepository {
	
	// La "base de datos"
		private Map <Integer, Alumno> alumnoRepository = new HashMap <>();
	
		/*
		 * guarda alumno en base de datos
		 */
  public Alumno save(Alumno nuevoalumno)
  {
	   alumnoRepository.put(nuevoalumno.getMatricula(), nuevoalumno);
	 
	   return nuevoalumno;
  }
  
  /*
   * busca alumno por matricula
   */
  public Alumno findByMatricula(Integer matricula)
  {
	  Alumno alumno = alumnoRepository.get(matricula);
	  
	  return alumno;
  }
  
  /*
   * regresa una lista de todos los alumnos 
   */
   public List <Alumno> find()
  {
	  return new ArrayList <>(alumnoRepository.values());
	  
  }
   
   public Alumno Update(Integer matricula,Alumno actualizaAlumno)
   {
	   
	   Alumno alumno = alumnoRepository.get(matricula);
	   
	   alumno.setNombre(actualizaAlumno.getNombre());
		alumno.setCarrera(actualizaAlumno.getCarrera());
		
		alumnoRepository.put(alumno.getMatricula(),alumno);
		
		return alumno;
	   
   }
   
   
   public void Delate(Integer matricula)
   {
	   alumnoRepository.remove(matricula);
   }

}
