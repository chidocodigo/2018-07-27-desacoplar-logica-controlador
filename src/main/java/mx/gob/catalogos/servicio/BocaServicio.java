package mx.gob.catalogos.servicio;

import java.util.List;
import mx.gob.catalogos.modelo.Boca;

public interface BocaServicio {
	public Boca guardarBoca(Boca boca);
	public List<Boca> getBocas();
	public Boca getBocaById(Integer id);
	public Boca actualizarBoca(Boca nuevaBoca, Integer id);
	public void borrarBoca(Integer id);
}
