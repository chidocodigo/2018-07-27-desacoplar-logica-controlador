package mx.gob.catalogos.servicioImplementacion;

import java.util.List;

import mx.gob.catalogos.modelo.TipoCabello;
import mx.gob.catalogos.servicio.TipoCabelloServicio;
import mx.gob.catalogos.repositorio.TipoCabelloRepositorio;
import mx.gob.catalogos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class TipoCabelloServicioImp implements TipoCabelloServicio {

	@Autowired
	private TipoCabelloRepositorio tipoCabelloRepositorio;

	@Override
	public TipoCabello guardarTipoCabello(TipoCabello tipoCabello) {
		return tipoCabelloRepositorio.save(tipoCabello);
	}

	@Override
	public List<TipoCabello> getTiposCabello() {
		return tipoCabelloRepositorio.findAll();
	}

	@Override
	public TipoCabello getTipoCabelloById(Integer id) {
		return tipoCabelloRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Tipo de cabello", "id", id));
	}

	@Override
	public TipoCabello actualizarTipoCabello(TipoCabello nuevoTipoCabello, Integer id) {
		TipoCabello tipoCabelloActual = tipoCabelloRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Tipo de cabello", "id", id));
		
		tipoCabelloActual.setActivo(nuevoTipoCabello.getActivo());
		tipoCabelloActual.setNombre(nuevoTipoCabello.getNombre());
		
		TipoCabello tipoCabelloActualizado = tipoCabelloRepositorio.save(tipoCabelloActual);
		return tipoCabelloActualizado;
	}

	@Override
	public void borrarTipoCabello(Integer id) {
		TipoCabello tipoCabello = tipoCabelloRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Tipo de cabello", "id", id));
		
		tipoCabelloRepositorio.delete(tipoCabello);

	}

}
