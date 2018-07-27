package mx.gob.catalogos.servicioImplementacion;

import java.util.List;

import mx.gob.catalogos.modelo.Pais;
import mx.gob.catalogos.servicio.PaisServicio;
import mx.gob.catalogos.repositorio.PaisRepositorio;
import mx.gob.catalogos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class PaisServicioImp implements PaisServicio {

	@Autowired
	private PaisRepositorio paisRepositorio;

	@Override
	public Pais guardarPais(Pais pais) {
		return paisRepositorio.save(pais);
	}

	@Override
	public List<Pais> getPaises() {
		return paisRepositorio.findAll();
	}

	@Override
	public Pais getPaisById(Integer id) {
		return paisRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("País", "id", id));
	}

	@Override
	public Pais actualizarPais(Pais nuevoPais, Integer id) {
		Pais paisActual = paisRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("País", "id", id));
		
		paisActual.setActivo(nuevoPais.getActivo());
		paisActual.setNombre(nuevoPais.getNombre());
		
		Pais paisActualizado = paisRepositorio.save(paisActual);
		return paisActualizado;
	}

	@Override
	public void borrarPais(Integer id) {
		Pais pais = paisRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("País", "id", id));
		
		paisRepositorio.delete(pais);

	}

}
