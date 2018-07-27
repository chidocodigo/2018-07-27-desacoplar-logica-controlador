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
import mx.gob.catalogos.servicio.BocaServicio;

import mx.gob.catalogos.modelo.Boca;

@RestController
@RequestMapping("/api")
public class BocaControlador {
	@Autowired
	BocaServicio bocas;

	@GetMapping("/bocas")
	public List<Boca> getBocas() {
	    return bocas.getBocas();
	}

	@PostMapping("/bocas")
	public Boca guardarBoca(@Valid @RequestBody Boca boca) {
	    return bocas.guardarBoca(boca);
	}

	@GetMapping("/bocas/{id}")
	public Boca getBocaById(@PathVariable(value = "id") Integer bocaId) {
	    return bocas.getBocaById(bocaId);
	}

	@PutMapping("/bocas/{id}")
	public Boca actualizarBoca(@PathVariable(value = "id") Integer bocaId, @Valid @RequestBody Boca nuevaBoca) {
	    return bocas.actualizarBoca(nuevaBoca, bocaId);
	}

	@DeleteMapping("/bocas/{id}")
	public ResponseEntity<?> borrarBoca(@PathVariable(value = "id") Integer bocaId) {
		bocas.borrarBoca(bocaId);
	    return ResponseEntity.ok().build();
	}
}
