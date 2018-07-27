package mx.gob.catalogos.servicio;

import java.util.List;
import mx.gob.catalogos.modelo.Pais;

public interface PaisServicio {
	public Pais guardarPais(Pais pais);
	public List<Pais> getPaises();
	public Pais getPaisById(Integer id);
	public Pais actualizarPais(Pais nuevoPais, Integer id);
	public void borrarPais(Integer id);
}