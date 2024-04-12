package ejercicio15_CentroEducativo.controladores;

import ejercicio15_CentroEducativo.entities.Estudiante;

public class ControladorEstudiante extends SuperControlador{

	private static ControladorEstudiante instance = null;
	
	
	public ControladorEstudiante() {
		super("estudiante", Estudiante.class);
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static ControladorEstudiante getInstance() {
		if (instance == null) {
			instance = new ControladorEstudiante();
		}
		return instance;
	}
	
	
}
