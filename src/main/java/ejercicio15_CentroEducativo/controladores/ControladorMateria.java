package ejercicio15_CentroEducativo.controladores;

import ejercicio15_CentroEducativo.entities.Materia;

public class ControladorMateria extends SuperControlador{


	private static ControladorMateria instance = null;
	
	
	public ControladorMateria() {
		super("materia", Materia.class);
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static ControladorMateria getInstance() {
		if (instance == null) {
			instance = new ControladorMateria();
		}
		return instance;
	}
	
}
