package mx.gob.catalogos.servicioImplementacion;

import java.util.List;

import mx.gob.catalogos.modelo.Estado;
import mx.gob.catalogos.servicio.EstadoServicio;
import mx.gob.catalogos.repositorio.EstadoRepositorio;
import mx.gob.catalogos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class EstadoServicioImp implements EstadoServicio {

	@Autowired
	private EstadoRepositorio estadoRepositorio;

	@Override
	public Estado guardarEstado(Estado estado) {
		return estadoRepositorio.save(estado);
	}

	@Override
	public List<Estado> getEstados() {
		return estadoRepositorio.findAll();
	}

	@Override
	public Estado getEstadoById(Integer id) {
		return estadoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Estado", "id", id));
	}

	@Override
	public Estado actualizarEstado(Estado nuevoEstado, Integer id) {
		Estado estadoActual = estadoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Estado", "id", id));
		
		estadoActual.setActivo(nuevoEstado.getActivo());
		estadoActual.setNombre(nuevoEstado.getNombre());
		
		Estado estadoActualizado = estadoRepositorio.save(estadoActual);
		return estadoActualizado;
	}

	@Override
	public void borrarEstado(Integer id) {
		Estado estado = estadoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Estado", "id", id));
		
		estadoRepositorio.delete(estado);

	}

}
