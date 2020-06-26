package mx.uam.tsis.ejemplobackend.servicios;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mx.uam.tsis.ejemplobackend.negocio.modelo.Alumno;
import mx.uam.tsis.ejemplobackend.negocios.AlumnoService;

/**
 * Controlador para el API rest
 * 
 * @author humbertocervantes
 *
 */
@RestController
@Slf4j
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	Logger logger =Logger.getLogger("AlumnoController");
	
	
	
	@PostMapping(path = "/alumnos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <?> create(@RequestBody @Valid Alumno nuevoAlumno) {
		 
		 Alumno alumno= alumnoService.create(nuevoAlumno);
		
		if(alumno!=null)
		{
		   return ResponseEntity.status(HttpStatus.CREATED).body(alumno);
		 
		}else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("esa matricula ya existe para el alumno nuevo");
		}
		
		
	}
	
	@GetMapping(path = "/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <?> retrieveAll() {
		
		List <Alumno> resultado = alumnoService.retrieveAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(resultado);
		
	}

	@GetMapping(path = "/alumnos/{matricula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <?> retrieve(@PathVariable("matricula") Integer matricula) {
		
		///log.info("Buscando al alumno con matricula "+matricula);
		logger.log( Level.INFO, "alumno con matricula"+matricula);
		
		Alumno alumno= alumnoService.retieve(matricula);
		
		if(alumno != null) {
			return ResponseEntity.status(HttpStatus.OK).body(alumno);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("alumno con matricula: "+matricula+" no existe");
		}
		
		
	}
	
 	@PutMapping(path = "alumnos/{matricula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <?> update(@PathVariable("matricula") Integer matricula,@RequestBody Alumno actualizaAlumno)
	{
 		Alumno alumno= alumnoService.updatealumno(matricula, actualizaAlumno);
 		if(alumno!=null)
 		{
 	      return ResponseEntity.status(HttpStatus.CREATED).body(alumno);
 		}
 		else
 		{
 			return  ResponseEntity.status(HttpStatus.CONFLICT).build();
 		}
	}
		
	
	
@DeleteMapping(path = "alumnos/{matricula}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity <?> delete(@PathVariable("matricula") Integer matricula)
{
	 alumnoService.delete(matricula);
		
     return ResponseEntity.status(HttpStatus.OK).build();
		
}
	
	
}
