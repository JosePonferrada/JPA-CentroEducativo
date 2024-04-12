package ejercicio15_CentroEducativo.controladores;

import ejercicio15_CentroEducativo.entities.Profesor;

public class ControladorProfesor extends SuperControlador{
	
private static ControladorProfesor instance = null;
	
	
	public ControladorProfesor() {
		super("profesor", Profesor.class);
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static ControladorProfesor getInstance() {
		if (instance == null) {
			instance = new ControladorProfesor();
		}
		return instance;
	}
	

}
