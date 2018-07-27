package mx.gob.catalogos.servicioImplementacion;

import java.util.List;

import mx.gob.catalogos.modelo.Frente;
import mx.gob.catalogos.servicio.FrenteServicio;
import mx.gob.catalogos.repositorio.FrenteRepositorio;
import mx.gob.catalogos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class FrenteServicioImp implements FrenteServicio {

	@Autowired
	private FrenteRepositorio frenteRepositorio;

	@Override
	public Frente guardarFrente(Frente frente) {
		return frenteRepositorio.save(frente);
	}

	@Override
	public List<Frente> getFrentes() {
		return frenteRepositorio.findAll();
	}

	@Override
	public Frente getFrenteById(Integer id) {
		return frenteRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Frente", "id", id));
	}

	@Override
	public Frente actualizarFrente(Frente nuevaFrente, Integer id) {
		Frente frenteActual = frenteRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Frente", "id", id));
		
		frenteActual.setActivo(nuevaFrente.getActivo());
		frenteActual.setNombre(nuevaFrente.getNombre());
		
		Frente frenteActualizada = frenteRepositorio.save(frenteActual);
		return frenteActualizada;
	}

	@Override
	public void borrarFrente(Integer id) {
		Frente frente = frenteRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Frente", "id", id));
		
		frenteRepositorio.delete(frente);

	}

}
