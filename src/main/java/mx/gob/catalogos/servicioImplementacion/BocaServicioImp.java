package mx.gob.catalogos.servicioImplementacion;

import java.util.List;
import mx.gob.catalogos.modelo.Boca;
import mx.gob.catalogos.repositorio.BocaRepositorio;
import mx.gob.catalogos.servicio.BocaServicio;
import mx.gob.catalogos.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class BocaServicioImp implements BocaServicio{
	
	@Autowired
	private BocaRepositorio bocaRepositorio;

	@Override
	public Boca guardarBoca(Boca boca) {
		return bocaRepositorio.save(boca);
	}

	@Override
	public List<Boca> getBocas() {
		return bocaRepositorio.findAll();
	}

	@Override
	public Boca getBocaById(Integer id) {
		return bocaRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Boca", "id", id));
	}

	@Override
	public Boca actualizarBoca(Boca nuevaBoca, Integer id) {
		Boca bocaActual = bocaRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Boca", "id", id));
		
		bocaActual.setActivo(nuevaBoca.getActivo());
		bocaActual.setNombre(nuevaBoca.getNombre());
		
		Boca bocaActualizada = bocaRepositorio.save(bocaActual);
		return bocaActualizada;
	}

	@Override
	public void borrarBoca(Integer id) {
		Boca boca = bocaRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Boca", "id", id));
		
		bocaRepositorio.delete(boca);
		
	}

}
