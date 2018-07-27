package mx.gob.catalogos.servicio;

import java.util.List;
import mx.gob.catalogos.modelo.ColorOjo;

public interface ColorOjoServicio {
	public ColorOjo guardarColorOjo(ColorOjo colorOjo);
	public List<ColorOjo> getColoresOjo();
	public ColorOjo getColorOjoById(Integer id);
	public ColorOjo actualizarColorOjo(ColorOjo nuevoColorOjo, Integer id);
	public void borrarColorOjo(Integer id);
}