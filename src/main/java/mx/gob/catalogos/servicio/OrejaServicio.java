package mx.gob.catalogos.servicio;

import java.util.List;
import mx.gob.catalogos.modelo.Oreja;

public interface OrejaServicio {
	public Oreja guardarOreja(Oreja oreja);
	public List<Oreja> getOrejas();
	public Oreja getOrejaById(Integer id);
	public Oreja actualizarOreja(Oreja nuevaOreja, Integer id);
	public void borrarOreja(Integer id);
}