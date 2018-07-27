package mx.gob.catalogos.servicioImplementacion;

import java.util.List;

import mx.gob.catalogos.modelo.Municipio;
import mx.gob.catalogos.servicio.MunicipioServicio;
import mx.gob.catalogos.repositorio.MunicipioRepositorio;
import mx.gob.catalogos.repositorio.EstadoRepositorio;
import mx.gob.catalogos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipioServicioImp implements MunicipioServicio {

	@Autowired
	private MunicipioRepositorio municipioRepositorio;

	@Autowired
	private EstadoRepositorio estadoRepositorio;

	@Override
	public Municipio guardarMunicipio(Municipio municipio,Integer estadoId) {
		estadoRepositorio.findById(estadoId).map(estado -> {
            municipio.setEstado(estado);
            return municipio;
        }).orElseThrow(() -> new ResourceNotFoundException("Estado ","id",estadoId));

		return municipioRepositorio.save(municipio);
	}

	@Override
	public List<Municipio> getMunicipios() {
		return municipioRepositorio.findAll();
	}

	@Override
	public List<Municipio> getMunicipiosbyEstadoId(Integer estadoId) {
		return municipioRepositorio.findByEstadoId(estadoId);
	}

	

	@Override
	public Municipio getMunicipioById(Integer id) {
		return municipioRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Municipio", "id", id));
	}

	@Override
	public Municipio actualizarMunicipio(Municipio nuevoMunicipio, Integer municipioId) {
		return municipioRepositorio.findById(municipioId).map(municipio -> {
            municipio.setNombre(nuevoMunicipio.getNombre());
            municipio.setActivo(nuevoMunicipio.getActivo());
            return municipioRepositorio.save(municipio);
        }).orElseThrow(() -> new ResourceNotFoundException("Municipio ","id", municipioId));
	}

	@Override
	public void borrarMunicipio(Integer id) {
		Municipio municipio = municipioRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Municipio", "id", id));
		
		municipioRepositorio.delete(municipio);

	}

}
