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
import mx.gob.catalogos.servicio.CompaniaTelefonoServicio;

import mx.gob.catalogos.modelo.CompaniaTelefono;

@RestController
@RequestMapping("/api")
public class CompaniaTelefonoControlador {
	@Autowired
	CompaniaTelefonoServicio companiastelefono;

	@GetMapping("/companiastelefono")
	public List<CompaniaTelefono> getCompaniasTelefono() {
	    return companiastelefono.getCompaniasTelefono();
	}

	@PostMapping("/companiastelefono")
	public CompaniaTelefono guardarCompaniaTelefono(@Valid @RequestBody CompaniaTelefono companiaTelefono) {
	    return companiastelefono.guardarCompaniaTelefono(companiaTelefono);
	}

	@GetMapping("/companiastelefono/{id}")
	public CompaniaTelefono getCompaniaTelefonoById(@PathVariable(value = "id") Integer companiaTelefonoId) {
	    return companiastelefono.getCompaniaTelefonoById(companiaTelefonoId);
	}

	@PutMapping("/companiastelefono/{id}")
	public CompaniaTelefono actualizarCompaniaTelefono(@PathVariable(value = "id") Integer companiaTelefonoId, @Valid @RequestBody CompaniaTelefono nuevoCompaniaTelefono) {
	    return companiastelefono.actualizarCompaniaTelefono(nuevoCompaniaTelefono, companiaTelefonoId);
	}

	@DeleteMapping("/companiastelefono/{id}")
	public ResponseEntity<?> borrarCompaniaTelefono(@PathVariable(value = "id") Integer companiaTelefonoId) {
		companiastelefono.borrarCompaniaTelefono(companiaTelefonoId);
	    return ResponseEntity.ok().build();
	}
}
