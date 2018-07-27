package mx.gob.catalogos.servicioImplementacion;

import java.util.List;

import mx.gob.catalogos.modelo.Oreja;
import mx.gob.catalogos.servicio.OrejaServicio;
import mx.gob.catalogos.repositorio.OrejaRepositorio;
import mx.gob.catalogos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class OrejaServicioImp implements OrejaServicio {

	@Autowired
	private OrejaRepositorio orejaRepositorio;

	@Override
	public Oreja guardarOreja(Oreja oreja) {
		return orejaRepositorio.save(oreja);
	}

	@Override
	public List<Oreja> getOrejas() {
		return orejaRepositorio.findAll();
	}

	@Override
	public Oreja getOrejaById(Integer id) {
		return orejaRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Oreja", "id", id));
	}

	@Override
	public Oreja actualizarOreja(Oreja nuevaOreja, Integer id) {
		Oreja orejaActual = orejaRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Oreja", "id", id));
		
		orejaActual.setActivo(nuevaOreja.getActivo());
		orejaActual.setNombre(nuevaOreja.getNombre());
		
		Oreja orejaActualizada = orejaRepositorio.save(orejaActual);
		return orejaActualizada;
	}

	@Override
	public void borrarOreja(Integer id) {
		Oreja oreja = orejaRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Oreja", "id", id));
		
		orejaRepositorio.delete(oreja);

	}

}
