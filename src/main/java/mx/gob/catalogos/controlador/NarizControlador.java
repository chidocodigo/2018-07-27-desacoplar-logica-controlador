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
import mx.gob.catalogos.servicio.NarizServicio;

import mx.gob.catalogos.modelo.Nariz;

@RestController
@RequestMapping("/api")
public class NarizControlador {
	@Autowired
	NarizServicio narices;

	@GetMapping("/narices")
	public List<Nariz> getNarices() {
	    return narices.getNarices();
	}

	@PostMapping("/narices")
	public Nariz guardarNariz(@Valid @RequestBody Nariz nariz) {
	    return narices.guardarNariz(nariz);
	}

	@GetMapping("/narices/{id}")
	public Nariz getNarizById(@PathVariable(value = "id") Integer narizId) {
	    return narices.getNarizById(narizId);
	}

	@PutMapping("/narices/{id}")
	public Nariz actualizarNariz(@PathVariable(value = "id") Integer narizId, @Valid @RequestBody Nariz nuevaNariz) {
	    return narices.actualizarNariz(nuevaNariz, narizId);
	}

	@DeleteMapping("/narices/{id}")
	public ResponseEntity<?> borrarNariz(@PathVariable(value = "id") Integer narizId) {
		narices.borrarNariz(narizId);
	    return ResponseEntity.ok().build();
	}
}
