package mx.gob.catalogos.servicioImplementacion;

import java.util.List;

import mx.gob.catalogos.modelo.ColorOjo;
import mx.gob.catalogos.servicio.ColorOjoServicio;
import mx.gob.catalogos.repositorio.ColorOjoRepositorio;
import mx.gob.catalogos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class ColorOjoServicioImp implements ColorOjoServicio {

	@Autowired
	private ColorOjoRepositorio colorOjoRepositorio;

	@Override
	public ColorOjo guardarColorOjo(ColorOjo colorOjo) {
		return colorOjoRepositorio.save(colorOjo);
	}

	@Override
	public List<ColorOjo> getColoresOjo() {
		return colorOjoRepositorio.findAll();
	}

	@Override
	public ColorOjo getColorOjoById(Integer id) {
		return colorOjoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Color de ojo", "id", id));
	}

	@Override
	public ColorOjo actualizarColorOjo(ColorOjo nuevoColorOjo, Integer id) {
		ColorOjo colorOjoActual = colorOjoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Color de ojo", "id", id));
		
		colorOjoActual.setActivo(nuevoColorOjo.getActivo());
		colorOjoActual.setNombre(nuevoColorOjo.getNombre());
		
		ColorOjo colorOjoActualizado = colorOjoRepositorio.save(colorOjoActual);
		return colorOjoActualizado;
	}

	@Override
	public void borrarColorOjo(Integer id) {
		ColorOjo colorOjo = colorOjoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Color de ojo", "id", id));
		
		colorOjoRepositorio.delete(colorOjo);
	}

}
