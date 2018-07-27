package mx.gob.catalogos.servicioImplementacion;

import java.util.List;

import mx.gob.catalogos.modelo.Nariz;
import mx.gob.catalogos.servicio.NarizServicio;
import mx.gob.catalogos.repositorio.NarizRepositorio;
import mx.gob.catalogos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class NarizServicioImp implements NarizServicio {

	@Autowired
	private NarizRepositorio narizRepositorio;

	@Override
	public Nariz guardarNariz(Nariz nariz) {
		return narizRepositorio.save(nariz);
	}

	@Override
	public List<Nariz> getNarices() {
		return narizRepositorio.findAll();
	}

	@Override
	public Nariz getNarizById(Integer id) {
		return narizRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Nariz", "id", id));
	}

	@Override
	public Nariz actualizarNariz(Nariz nuevaNariz, Integer id) {
		Nariz narizActual = narizRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Nariz", "id", id));
		
		narizActual.setActivo(nuevaNariz.getActivo());
		narizActual.setNombre(nuevaNariz.getNombre());
		
		Nariz narizActualizada = narizRepositorio.save(narizActual);
		return narizActualizada;
	}

	@Override
	public void borrarNariz(Integer id) {
		Nariz nariz = narizRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Nariz", "id", id));
		
		narizRepositorio.delete(nariz);

	}

}
