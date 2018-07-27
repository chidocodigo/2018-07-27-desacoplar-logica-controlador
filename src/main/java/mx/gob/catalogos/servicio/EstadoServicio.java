package mx.gob.catalogos.servicio;

import java.util.List;
import mx.gob.catalogos.modelo.Estado;

public interface EstadoServicio {
	public Estado guardarEstado(Estado estado);
	public List<Estado> getEstados();
	public Estado getEstadoById(Integer id);
	public Estado actualizarEstado(Estado nuevoEstado, Integer id);
	public void borrarEstado(Integer id);
}