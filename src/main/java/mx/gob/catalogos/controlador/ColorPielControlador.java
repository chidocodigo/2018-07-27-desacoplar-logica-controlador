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
import mx.gob.catalogos.servicio.ColorPielServicio;

import mx.gob.catalogos.modelo.ColorPiel;

@RestController
@RequestMapping("/api")
public class ColorPielControlador {
	@Autowired
	ColorPielServicio colorespiel;

	@GetMapping("/colorespiel")
	public List<ColorPiel> getColoresPiel() {
	    return colorespiel.getColoresPiel();
	}

	@PostMapping("/colorespiel")
	public ColorPiel guardarColorPiel(@Valid @RequestBody ColorPiel colorPiel) {
	    return colorespiel.guardarColorPiel(colorPiel);
	}

	@GetMapping("/colorespiel/{id}")
	public ColorPiel getColorPielById(@PathVariable(value = "id") Integer colorPielId) {
	    return colorespiel.getColorPielById(colorPielId);
	}

	@PutMapping("/colorespiel/{id}")
	public ColorPiel actualizarColorPiel(@PathVariable(value = "id") Integer colorPielId, @Valid @RequestBody ColorPiel nuevoColorPiel) {
	    return colorespiel.actualizarColorPiel(nuevoColorPiel, colorPielId);
	}

	@DeleteMapping("/colorespiel/{id}")
	public ResponseEntity<?> borrarColorPiel(@PathVariable(value = "id") Integer colorPielId) {
		colorespiel.borrarColorPiel(colorPielId);
	    return ResponseEntity.ok().build();
	}
}
