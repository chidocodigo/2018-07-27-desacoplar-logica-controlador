package mx.gob.catalogos.servicioImplementacion;

import java.util.List;

import mx.gob.catalogos.modelo.ColorPiel;
import mx.gob.catalogos.servicio.ColorPielServicio;
import mx.gob.catalogos.repositorio.ColorPielRepositorio;
import mx.gob.catalogos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class ColorPielServicioImp implements ColorPielServicio {

	@Autowired
	private ColorPielRepositorio colorPielRepositorio;

	@Override
	public ColorPiel guardarColorPiel(ColorPiel colorPiel) {
		return colorPielRepositorio.save(colorPiel);
	}

	@Override
	public List<ColorPiel> getColoresPiel() {
		return colorPielRepositorio.findAll();
	}

	@Override
	public ColorPiel getColorPielById(Integer id) {
		return colorPielRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Color de piel", "id", id));
	}

	@Override
	public ColorPiel actualizarColorPiel(ColorPiel nuevoColorPiel, Integer id) {
		ColorPiel colorPielActual = colorPielRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Color de piel", "id", id));
		
		colorPielActual.setActivo(nuevoColorPiel.getActivo());
		colorPielActual.setNombre(nuevoColorPiel.getNombre());
		
		ColorPiel colorPielActualizado = colorPielRepositorio.save(colorPielActual);
		return colorPielActualizado;
	}

	@Override
	public void borrarColorPiel(Integer id) {
		ColorPiel colorPiel = colorPielRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Color de piel", "id", id));
		
		colorPielRepositorio.delete(colorPiel);

	}

}
