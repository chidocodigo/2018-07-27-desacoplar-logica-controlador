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
import mx.gob.catalogos.servicio.PaisServicio;

import mx.gob.catalogos.modelo.Pais;

@RestController
@RequestMapping("/api")
public class PaisControlador {
	@Autowired
	PaisServicio paises;

	@GetMapping("/paises")
	public List<Pais> getPaises() {
	    return paises.getPaises();
	}

	@PostMapping("/paises")
	public Pais guardarPais(@Valid @RequestBody Pais pais) {
	    return paises.guardarPais(pais);
	}

	@GetMapping("/paises/{id}")
	public Pais getPaisById(@PathVariable(value = "id") Integer paisId) {
	    return paises.getPaisById(paisId);
	}

	@PutMapping("/paises/{id}")
	public Pais actualizarPais(@PathVariable(value = "id") Integer paisId, @Valid @RequestBody Pais nuevoPais) {
	    return paises.actualizarPais(nuevoPais, paisId);
	}

	@DeleteMapping("/paises/{id}")
	public ResponseEntity<?> borrarPais(@PathVariable(value = "id") Integer paisId) {
		paises.borrarPais(paisId);
	    return ResponseEntity.ok().build();
	}
}
