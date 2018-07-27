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
import mx.gob.catalogos.servicio.FrenteServicio;

import mx.gob.catalogos.modelo.Frente;

@RestController
@RequestMapping("/api")
public class FrenteControlador {
	@Autowired
	FrenteServicio frentes;

	@GetMapping("/frentes")
	public List<Frente> getFrentes() {
	    return frentes.getFrentes();
	}

	@PostMapping("/frentes")
	public Frente guardarFrente(@Valid @RequestBody Frente frente) {
	    return frentes.guardarFrente(frente);
	}

	@GetMapping("/frentes/{id}")
	public Frente getFrenteById(@PathVariable(value = "id") Integer frenteId) {
	    return frentes.getFrenteById(frenteId);
	}

	@PutMapping("/frentes/{id}")
	public Frente actualizarFrente(@PathVariable(value = "id") Integer frenteId, @Valid @RequestBody Frente nuevaFrente) {
	    return frentes.actualizarFrente(nuevaFrente, frenteId);
	}

	@DeleteMapping("/frentes/{id}")
	public ResponseEntity<?> borrarFrente(@PathVariable(value = "id") Integer frenteId) {
		frentes.borrarFrente(frenteId);
	    return ResponseEntity.ok().build();
	}
}
