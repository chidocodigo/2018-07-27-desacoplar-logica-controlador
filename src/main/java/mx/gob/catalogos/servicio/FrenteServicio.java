package mx.gob.catalogos.servicio;

import java.util.List;
import mx.gob.catalogos.modelo.Frente;

public interface FrenteServicio {
	public Frente guardarFrente(Frente frente);
	public List<Frente> getFrentes();
	public Frente getFrenteById(Integer id);
	public Frente actualizarFrente(Frente nuevaFrente, Integer id);
	public void borrarFrente(Integer id);
}