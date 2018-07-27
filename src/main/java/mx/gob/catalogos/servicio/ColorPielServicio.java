package mx.gob.catalogos.servicio;

import java.util.List;
import mx.gob.catalogos.modelo.ColorPiel;

public interface ColorPielServicio {
	public ColorPiel guardarColorPiel(ColorPiel colorPiel);
	public List<ColorPiel> getColoresPiel();
	public ColorPiel getColorPielById(Integer id);
	public ColorPiel actualizarColorPiel(ColorPiel nuevoColorPiel, Integer id);
	public void borrarColorPiel(Integer id);
}