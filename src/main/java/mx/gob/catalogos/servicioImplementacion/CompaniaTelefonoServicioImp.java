package mx.gob.catalogos.servicioImplementacion;

import java.util.List;

import mx.gob.catalogos.modelo.CompaniaTelefono;
import mx.gob.catalogos.servicio.CompaniaTelefonoServicio;
import mx.gob.catalogos.repositorio.CompaniaTelefonoRepositorio;
import mx.gob.catalogos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class CompaniaTelefonoServicioImp implements CompaniaTelefonoServicio {

	@Autowired
	private CompaniaTelefonoRepositorio companiaTelefonoRepositorio;

	@Override
	public CompaniaTelefono guardarCompaniaTelefono(CompaniaTelefono companiaTelefono) {
		return companiaTelefonoRepositorio.save(companiaTelefono);
	}

	@Override
	public List<CompaniaTelefono> getCompaniasTelefono() {
		return companiaTelefonoRepositorio.findAll();
	}

	@Override
	public CompaniaTelefono getCompaniaTelefonoById(Integer id) {
		return companiaTelefonoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Compañia de teléfono", "id", id));
	}

	@Override
	public CompaniaTelefono actualizarCompaniaTelefono(CompaniaTelefono nuevaCompaniaTelefono, Integer id) {
		CompaniaTelefono companiaTelefonoActual = companiaTelefonoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Compañia de teléfono", "id", id));
		
		companiaTelefonoActual.setActivo(nuevaCompaniaTelefono.getActivo());
		companiaTelefonoActual.setNombre(nuevaCompaniaTelefono.getNombre());
		
		CompaniaTelefono companiaTelefonoActualizada = companiaTelefonoRepositorio.save(companiaTelefonoActual);
		return companiaTelefonoActualizada;
	}

	@Override
	public void borrarCompaniaTelefono(Integer id) {
		CompaniaTelefono companiaTelefono = companiaTelefonoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Compañia de teléfono", "id", id));
		
		companiaTelefonoRepositorio.delete(companiaTelefono);

	}

}
