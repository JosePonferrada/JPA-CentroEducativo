package ejercicio15_CentroEducativo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ejercicio15_CentroEducativo.entities.Estudiante;
import ejercicio15_CentroEducativo.entities.Materia;
import ejercicio15_CentroEducativo.entities.Profesor;
import ejercicio15_CentroEducativo.entities.ValoracionMateria;

public class ControladorValoracionMateria extends SuperControlador{

	private static ControladorValoracionMateria instance = null;
		
	private String NOMBRE_TABLA = "valoracionmateria";
	
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
	public static ControladorValoracionMateria getInstance() {
		if(instance == null) {
			instance = new ControladorValoracionMateria();
		}
		return instance;
	}
		
	public ValoracionMateria findVMByMateriaProfesorAndEstudiante 
		(Materia materia, Profesor profesor, Estudiante estudiante) {
		
		EntityManager em = getEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM " + NOMBRE_TABLA 
				+ " where idmateria = " + materia.getId() + " and idprofesor = " 
				+ profesor.getId() + " and idestudiante = " + estudiante.getId(), ValoracionMateria.class);
		try {
			return (ValoracionMateria) q.getSingleResult();
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public void insertMark(Materia materia, Profesor profesor, Estudiante estudiante, int mark) {
		
		EntityManager em = getEntityManager();
		
		ValoracionMateria vm = new ValoracionMateria();
		
		vm.setIdMateria(materia.getId());
		vm.setIdProfesor(profesor.getId());
		vm.setIdEstudiante(estudiante.getId());
		vm.setValoracion(mark);
		
		em.getTransaction().begin();
		em.persist(vm);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void modifyMark(ValoracionMateria vm, int mark) {
		
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		vm.setValoracion(mark);
		em.merge(vm);
		em.getTransaction().commit();
		
		em.close();
	}
	
}
