package es.curso.examen.logs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import es.curso.examen.modelo.Empleado;

// Esta clase representa el aspecto, pues hace operaciones transversales
@Aspect
@Component
public class FicherosLog {
	
//	@Pointcut(value="execution(* es.curso.examen.dao.IEmpleadoDAO.create(es.curso.examen.modelo.Empleado))&&args(e)")
//	public void puntoCorte1(Empleado e) {}
//	
//	@Pointcut(value="execution(* es.curso.examen.dao.IEmpleadoDAO.update(es.curso.examen.modelo.Empleado))&&args(e)")
//	public void puntoCorte2(Empleado e) {}
//	
//	@Pointcut(value="execution(* es.curso.examen.dao.IEmpleadoDAO.delete(..))&&args(codigo)")
//	public void puntoCorte3(int codigo) {}
//	
//	@AfterReturning("puntoCorte1(e)")
	public static void grabarLog(String linea, String path) {
		// Graba linea en un fichero de log, lo va añadiendo al final
		// Registra la fecha y la hora.
		FileOutputStream fOut = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
		Date ahora = new Date();
		String contenido;
		
		try {
			contenido = sdf.format(ahora) + "\t" + linea + "\n";
			fOut = new FileOutputStream(path, true);			
			fOut.write(contenido.getBytes());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		} finally {
			if (fOut != null) {
				try {
					fOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
