package mx.gob.catalogos.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.gob.catalogos.servicio.MunicipioServicio;
import mx.gob.catalogos.modelo.Municipio;

@RestController
@RequestMapping("/api")
public class MunicipioControlador {
	@Autowired
	MunicipioServicio municipios;

	@GetMapping("/municipios")
	public List<Municipio> getMunicipios() {
	    return municipios.getMunicipios();
	}

	@GetMapping("/municipios/estado/{estadoId}")
	public List<Municipio> getMunicipiosByEstadoId(@PathVariable (value = "estadoId") Integer estadoId ) {
	    return municipios.getMunicipiosbyEstadoId(estadoId);
	}

	@PostMapping("/municipios/estado/{estadoId}")
	public Municipio guardarMunicipio(@PathVariable (value = "estadoId") Integer estadoId,
										 @Valid @RequestBody Municipio municipio) {
	    return municipios.guardarMunicipio(municipio, estadoId);
	}

	@GetMapping("/municipios/{id}")
	public Municipio getMunicipioById(@PathVariable(value = "id") Integer municipioId) {
	    return municipios.getMunicipioById(municipioId);
	}

	@PutMapping("/municipios/{municipioId}")
	public Municipio actualizarMunicipio(@PathVariable(value = "municipioId") Integer municipioId,
											@Valid @RequestBody Municipio nuevoMunicipio) {
	    return municipios.actualizarMunicipio(nuevoMunicipio, municipioId);
	}

	@DeleteMapping("/municipios/{id}")
	public ResponseEntity<?> borrarMunicipio(@PathVariable(value = "id") Integer municipioId) {
		municipios.borrarMunicipio(municipioId);
	    return ResponseEntity.ok().build();
	}
}
