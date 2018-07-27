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
import mx.gob.catalogos.servicio.OrejaServicio;

import mx.gob.catalogos.modelo.Oreja;

@RestController
@RequestMapping("/api")
public class OrejaControlador {
	@Autowired
	OrejaServicio orejas;

	@GetMapping("/orejas")
	public List<Oreja> getOrejas() {
	    return orejas.getOrejas();
	}

	@PostMapping("/orejas")
	public Oreja guardarOreja(@Valid @RequestBody Oreja oreja) {
	    return orejas.guardarOreja(oreja);
	}

	@GetMapping("/orejas/{id}")
	public Oreja getOrejaById(@PathVariable(value = "id") Integer orejaId) {
	    return orejas.getOrejaById(orejaId);
	}

	@PutMapping("/orejas/{id}")
	public Oreja actualizarOreja(@PathVariable(value = "id") Integer orejaId, @Valid @RequestBody Oreja nuevaOreja) {
	    return orejas.actualizarOreja(nuevaOreja, orejaId);
	}

	@DeleteMapping("/orejas/{id}")
	public ResponseEntity<?> borrarOreja(@PathVariable(value = "id") Integer orejaId) {
		orejas.borrarOreja(orejaId);
	    return ResponseEntity.ok().build();
	}
}
