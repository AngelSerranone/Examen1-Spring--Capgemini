package es.curso.examen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import es.curso.examen.dao.IEmpleadoDAO;
import es.curso.examen.logs.FicherosLog;
import es.curso.examen.modelo.Empleado;

public class Application {
	

	public static void main(String[] args) {
		ejemploGrabarEnElLog();
		
		pruebaConXML();
		pruebaConAnotaciones();
	}
		

	private static void ejemploGrabarEnElLog() {
		// Codigo de prueba para ver como se utiliza el metodo grabarLog de la clase FicherosLog
		
		// Grabamos una linea en el fichero de Log:
		FicherosLog.grabarLog("contenido de la linea de log", "src/logs/mi_log.txt");
		FicherosLog.grabarLog("Otra linea de log", "src/logs/mi_log.txt");
		FicherosLog.grabarLog("Una tercera linea de log", "src/logs/mi_log.txt");
	}



	private static void pruebaConAnotaciones() {
		// Cargar el contexto para anotaciones.
		ApplicationContext contexto;

		// Recuperar el contexto
		contexto = new ClassPathXmlApplicationContext("context.xml");

		// Recuperar un bean del contexto:
		IEmpleadoDAO empleadoDao = (IEmpleadoDAO) contexto.getBean("empleadoDAO");
		empleadoDao.create(new Empleado(33, "Pepe", "Capgemini", "Junior"));
		empleadoDao.update(new Empleado(33, "Pepe", "Capgemini", "Senior"));
		empleadoDao.delete(45);
		// Cerrar el contexto
		((ClassPathXmlApplicationContext) contexto).close();
		
	}

	private static void pruebaConXML() {
		// Cargar el contexto para XML
		
	}

}
