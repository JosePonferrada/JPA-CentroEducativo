package ejercicio15_CentroEducativo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "profesor")
public class Profesor extends Entidad{

	@Id
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	@OneToMany(mappedBy="profesor")
	private List<ValoracionMateria> vm;
	
	public Profesor() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public List<ValoracionMateria> getVm() {
		return vm;
	}

	public void setVm(List<ValoracionMateria> vm) {
		this.vm = vm;
	}

	@Override
	public String toString() {
		return nombre + " " + apellido1 + " " + apellido2;
	}
	
}
