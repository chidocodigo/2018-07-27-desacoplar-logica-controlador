package mx.gob.catalogos.servicioImplementacion;

import java.util.List;

import mx.gob.catalogos.modelo.TipoTelefono;
import mx.gob.catalogos.servicio.TipoTelefonoServicio;
import mx.gob.catalogos.repositorio.TipoTelefonoRepositorio;
import mx.gob.catalogos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class TipoTelefonoServicioImp implements TipoTelefonoServicio {

	@Autowired
	private TipoTelefonoRepositorio tipoTelefonoRepositorio;

	@Override
	public TipoTelefono guardarTipoTelefono(TipoTelefono tipoTelefono) {
		return tipoTelefonoRepositorio.save(tipoTelefono);
	}

	@Override
	public List<TipoTelefono> getTiposTelefono() {
		return tipoTelefonoRepositorio.findAll();
	}

	@Override
	public TipoTelefono getTipoTelefonoById(Integer id) {
		return tipoTelefonoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Tipo de teléfono", "id", id));
	}

	@Override
	public TipoTelefono actualizarTipoTelefono(TipoTelefono nuevoTipoTelefono, Integer id) {
		TipoTelefono tipoTelefonoActual = tipoTelefonoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Tipo de teléfono", "id", id));
		
		tipoTelefonoActual.setActivo(nuevoTipoTelefono.getActivo());
		tipoTelefonoActual.setNombre(nuevoTipoTelefono.getNombre());
		
		TipoTelefono tipoTelefonoActualizada = tipoTelefonoRepositorio.save(tipoTelefonoActual);
		return tipoTelefonoActualizada;
	}

	@Override
	public void borrarTipoTelefono(Integer id) {
		TipoTelefono tipoTelefono = tipoTelefonoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Tipo de teléfono", "id", id));
		
		tipoTelefonoRepositorio.delete(tipoTelefono);

	}

}
