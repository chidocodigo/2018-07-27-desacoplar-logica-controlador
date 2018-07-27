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
import mx.gob.catalogos.servicio.TipoCabelloServicio;

import mx.gob.catalogos.modelo.TipoCabello;

@RestController
@RequestMapping("/api")
public class TipoCabelloControlador {
	@Autowired
	TipoCabelloServicio tiposcabello;

	@GetMapping("/tiposcabello")
	public List<TipoCabello> getTiposCabello() {
	    return tiposcabello.getTiposCabello();
	}

	@PostMapping("/tiposcabello")
	public TipoCabello guardarTipoCabello(@Valid @RequestBody TipoCabello tipoCabello) {
	    return tiposcabello.guardarTipoCabello(tipoCabello);
	}

	@GetMapping("/tiposcabello/{id}")
	public TipoCabello getTipoCabelloById(@PathVariable(value = "id") Integer tipoCabelloId) {
	    return tiposcabello.getTipoCabelloById(tipoCabelloId);
	}

	@PutMapping("/tiposcabello/{id}")
	public TipoCabello actualizarTipoCabello(@PathVariable(value = "id") Integer tipoCabelloId, @Valid @RequestBody TipoCabello nuevoTipoCabello) {
	    return tiposcabello.actualizarTipoCabello(nuevoTipoCabello, tipoCabelloId);
	}

	@DeleteMapping("/tiposcabello/{id}")
	public ResponseEntity<?> borrarTipoCabello(@PathVariable(value = "id") Integer tipoCabelloId) {
		tiposcabello.borrarTipoCabello(tipoCabelloId);
	    return ResponseEntity.ok().build();
	}
}
