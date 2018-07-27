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
import mx.gob.catalogos.servicio.ColorOjoServicio;

import mx.gob.catalogos.modelo.ColorOjo;

@RestController
@RequestMapping("/api")
public class ColorOjoControlador {
	@Autowired
	ColorOjoServicio coloresojo;

	@GetMapping("/coloresojo")
	public List<ColorOjo> getColoresOjo() {
	    return coloresojo.getColoresOjo();
	}

	@PostMapping("/coloresojo")
	public ColorOjo guardarColorOjo(@Valid @RequestBody ColorOjo colorOjo) {
	    return coloresojo.guardarColorOjo(colorOjo);
	}

	@GetMapping("/coloresojo/{id}")
	public ColorOjo getColorOjoById(@PathVariable(value = "id") Integer colorOjoId) {
	    return coloresojo.getColorOjoById(colorOjoId);
	}

	@PutMapping("/coloresojo/{id}")
	public ColorOjo actualizarColorOjo(@PathVariable(value = "id") Integer colorOjoId, @Valid @RequestBody ColorOjo nuevoColorOjo) {
	    return coloresojo.actualizarColorOjo(nuevoColorOjo, colorOjoId);
	}

	@DeleteMapping("/coloresojo/{id}")
	public ResponseEntity<?> borrarColorOjo(@PathVariable(value = "id") Integer colorOjoId) {
		coloresojo.borrarColorOjo(colorOjoId);
	    return ResponseEntity.ok().build();
	}
}
