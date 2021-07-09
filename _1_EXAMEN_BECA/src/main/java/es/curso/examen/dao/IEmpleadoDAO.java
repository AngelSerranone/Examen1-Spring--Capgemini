package es.curso.examen.dao;

import es.curso.examen.modelo.Empleado;

public interface IEmpleadoDAO {
	
	public void create(Empleado e);
	public void delete(int codigo);
	public void update(Empleado e);

}
