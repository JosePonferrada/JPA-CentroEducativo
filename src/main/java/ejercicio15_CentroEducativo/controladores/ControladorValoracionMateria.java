package ejercicio15_CentroEducativo.controladores;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ejercicio15_CentroEducativo.entities.Estudiante;
import ejercicio15_CentroEducativo.entities.Materia;
import ejercicio15_CentroEducativo.entities.Profesor;
import ejercicio15_CentroEducativo.entities.ValoracionMateria;


public class ControladorValoracionMateria extends SuperControlador{

	private static ControladorValoracionMateria instance = null;
		
	private static String NOMBRE_TABLA = "valoracionmateria";
	
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
	
	public void insertMark(Materia materia, Profesor profesor, Estudiante estudiante, int mark, Date fecha) {
		
		EntityManager em = getEntityManager();
		
		ValoracionMateria vm = new ValoracionMateria();
		
		vm.setIdMateria(materia.getId());
		vm.setIdProfesor(profesor.getId());
		vm.setIdEstudiante(estudiante.getId());
		vm.setValoracion(mark);
		vm.setFecha(fecha);
		
		em.getTransaction().begin();
		em.persist(vm);
		em.getTransaction().commit();
		
		//No lo cerramos para poder hacer varias cosas una tras otra
//		em.close();
	}
	
	public void modifyMark(ValoracionMateria vm, int mark, Date fecha) {
		
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		vm.setValoracion(mark);
		vm.setFecha(fecha);
		em.merge(vm);
		em.getTransaction().commit();
		
		//No lo cerramos para poder hacer varias cosas una tras otra
//		em.close();
	}
	
	private static void deleteEntity (ValoracionMateria vm, int mark) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CentroEducativo");

		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<ValoracionMateria> q = 
				em.createQuery("SELECT * FROM " + NOMBRE_TABLA + " where valoracion = " + mark, ValoracionMateria.class);
		
		List<ValoracionMateria> valoraciones = q.getResultList();
		
		em.getTransaction().begin();
		em.remove(valoraciones);
		em.getTransaction().commit();
		
		
		em.close();
	}
	
}
