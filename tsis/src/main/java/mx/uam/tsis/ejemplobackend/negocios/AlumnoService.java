package mx.uam.tsis.ejemplobackend.negocios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.tsis.ejemplobackend.datos.AlumnoRepository;
import mx.uam.tsis.ejemplobackend.negocio.modelo.Alumno;

@Service
public class AlumnoService {
  
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	/**
	 * 
	 * @param nuevoAlumno
	 * @return el alumno que se acaba de crear si la creacion es exitosa, null de
	 * lo contrario 
	 */
	public Alumno create(Alumno nuevoAlumno)
	{
		//regla de negicio no se puede crear mas de un alumno con la misma matricula
	  Alumno alumno= alumnoRepository.findByMatricula(nuevoAlumno.getMatricula());
	
	  if(alumno==null)
	  {
		 return alumnoRepository.save(nuevoAlumno);
	  }else
	  {
		return null;  
	  }
	  
	}
	
	
	/**
	 * 
	 * @return todos los alumnos
	 */
	public List <Alumno> retrieveAll()
	{
		return alumnoRepository.find();
	}
	
	
	public Alumno retieve(Integer matricula)
	{
		return alumnoRepository.findByMatricula(matricula);
	}
	
	
	public Alumno updatealumno(Integer matricula, Alumno actualizaAlumno)
	{
		 Alumno  alumnofind =alumnoRepository.findByMatricula(matricula);
		if(alumnofind!=null)
		{
		Alumno alumno= alumnoRepository.findByMatricula(actualizaAlumno.getMatricula());
		
		alumno.setNombre(actualizaAlumno.getNombre());
		alumno.setCarrera(actualizaAlumno.getCarrera());
		
		
		Alumno actualizadoAlumno= alumnoRepository.save(actualizaAlumno);
		
		
		return actualizadoAlumno;
		}
		else
		{
			return null;
		}
	}
	
	public void delete(Integer matricula)
	{
		alumnoRepository.Delate(matricula);
	}
}
