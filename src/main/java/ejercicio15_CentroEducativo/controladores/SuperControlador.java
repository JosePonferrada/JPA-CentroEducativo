package ejercicio15_CentroEducativo.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ejercicio15_CentroEducativo.entities.Entidad;

public class SuperControlador {
	
	private static EntityManager em = null;
	private Class tipoEntidad;
	private String nombreTabla = "";
	
	/**
	 * 
	 * @param nombreTabla
	 * @param tipoEntidad
	 */
	public SuperControlador (String nombreTabla, Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}
	
	protected EntityManager getEntityManager() {
		if (em == null) {
			em = Persistence.createEntityManagerFactory("CentroEducativo").
					createEntityManager();
		}
		return em;
	}
	
	private void updateEntidad(Entidad e) {

		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		
	}
	
	public List<? extends Entidad> findAll () {
		
		EntityManager em = getEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM " + this.nombreTabla, this.tipoEntidad);
		
		return (List<Entidad>) q.getResultList();
		
		//Otra manera de hacerlo:
		//return (List<ValoracionMateria>) getEntityManager()
		//.createNativeQuery("SELECT * FROM valoracionmateria;", ValoracionMateria.class)
		//.getResultList();
	}

}
