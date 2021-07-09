package es.curso.examen.dao;

import org.springframework.stereotype.Component;
import es.curso.examen.modelo.Empleado;

@Component
public class EmpleadoDAO implements IEmpleadoDAO {
	
	@Override
	public void create(Empleado e) {
		// TODO Auto-generated method stub
		System.out.println("Graba el empleado " + e + " en la BBDD.");
	}
	
	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub
		System.out.println("Borra el empleado con " + codigo + " en la BBDD.");
	}
	
	@Override
	public void update(Empleado e) {
		// TODO Auto-generated method stub
		System.out.println("Actualiza el empleado " + e + " en la BBDD.");
	}
}
