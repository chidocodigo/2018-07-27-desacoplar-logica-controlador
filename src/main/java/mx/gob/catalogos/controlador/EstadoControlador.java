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
import mx.gob.catalogos.servicio.EstadoServicio;

import mx.gob.catalogos.modelo.Estado;

@RestController
@RequestMapping("/api")
public class EstadoControlador {
	@Autowired
	EstadoServicio estados;

	@GetMapping("/estados")
	public List<Estado> getEstados() {
	    return estados.getEstados();
	}

	@PostMapping("/estados")
	public Estado guardarEstado(@Valid @RequestBody Estado estado) {
	    return estados.guardarEstado(estado);
	}

	@GetMapping("/estados/{id}")
	public Estado getEstadoById(@PathVariable(value = "id") Integer estadoId) {
	    return estados.getEstadoById(estadoId);
	}

	@PutMapping("/estados/{id}")
	public Estado actualizarEstado(@PathVariable(value = "id") Integer estadoId, @Valid @RequestBody Estado nuevoEstado) {
	    return estados.actualizarEstado(nuevoEstado, estadoId);
	}

	@DeleteMapping("/estados/{id}")
	public ResponseEntity<?> borrarEstado(@PathVariable(value = "id") Integer estadoId) {
		estados.borrarEstado(estadoId);
	    return ResponseEntity.ok().build();
	}
}
