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
import mx.gob.catalogos.servicio.TipoTelefonoServicio;

import mx.gob.catalogos.modelo.TipoTelefono;

@RestController
@RequestMapping("/api")
public class TipoTelefonoControlador {
	@Autowired
	TipoTelefonoServicio tipostelefono;

	@GetMapping("/tipostelefono")
	public List<TipoTelefono> getTiposTelefono() {
	    return tipostelefono.getTiposTelefono();
	}

	@PostMapping("/tipostelefono")
	public TipoTelefono guardarTipoTelefono(@Valid @RequestBody TipoTelefono tipoTelefono) {
	    return tipostelefono.guardarTipoTelefono(tipoTelefono);
	}

	@GetMapping("/tipostelefono/{id}")
	public TipoTelefono getTipoTelefonoById(@PathVariable(value = "id") Integer tipoTelefonoId) {
	    return tipostelefono.getTipoTelefonoById(tipoTelefonoId);
	}

	@PutMapping("/tipostelefono/{id}")
	public TipoTelefono actualizarTipoTelefono(@PathVariable(value = "id") Integer tipoTelefonoId, @Valid @RequestBody TipoTelefono nuevoTipoTelefono) {
	    return tipostelefono.actualizarTipoTelefono(nuevoTipoTelefono, tipoTelefonoId);
	}

	@DeleteMapping("/tipostelefono/{id}")
	public ResponseEntity<?> borrarTipoTelefono(@PathVariable(value = "id") Integer tipoTelefonoId) {
		tipostelefono.borrarTipoTelefono(tipoTelefonoId);
	    return ResponseEntity.ok().build();
	}
}
