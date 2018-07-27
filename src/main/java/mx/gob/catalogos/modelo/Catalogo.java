package mx.gob.catalogos.modelo;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Catalogo {
	private String nombre;
	private boolean activo;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}