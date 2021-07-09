package es.curso.examen.bbdd;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import es.curso.examen.logs.FicherosLog;
import es.curso.examen.modelo.Empleado;

//Esta clase representa el aspecto, pues hace operaciones transversales
@Aspect
@Component
public class BaseDatos {
	
	@Pointcut(value="execution(* es.curso.examen.dao.IEmpleadoDAO.create(es.curso.examen.modelo.Empleado))&&args(e)")
	public void puntoCorte(Empleado e) {}
	
	@Around(value = "puntoCorte(e)")
	public void accesDb(ProceedingJoinPoint joinpoint) {
		
		// Before --> Esto ocurre antes de la ejecucion del metodo create
		FicherosLog.grabarLog(e.toString(), "src/logs/mi_log.txt");
		
		// Ejecucion del método interceptado: empleadoDAO.create
		joinpoint.proceed();
			
		
	}

}
