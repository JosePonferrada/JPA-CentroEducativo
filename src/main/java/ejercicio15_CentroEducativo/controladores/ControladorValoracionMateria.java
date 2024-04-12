package ejercicio15_CentroEducativo.controladores;

import ejercicio15_CentroEducativo.entities.ValoracionMateria;

public class ControladorValoracionMateria extends SuperControlador{

	private static ControladorValoracionMateria instance = null;
		
	/**
	 * 
	 * @param nombreTabla
	 */
	public ControladorValoracionMateria() {
		super("valoracionmateria", ValoracionMateria.class);
	}
	
	/**
	 * Singleton
	 * @return
	 */
	public ControladorValoracionMateria getInstance() {
		if(instance == null) {
			instance = new ControladorValoracionMateria();
		}
		return instance;
	}
		
	
}
