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
import mx.gob.catalogos.servicio.BancoServicio;

import mx.gob.catalogos.modelo.Banco;

@RestController
@RequestMapping("/api")
public class BancoControlador {
	@Autowired
	BancoServicio bancos;

	@GetMapping("/bancos")
	public List<Banco> getBancos() {
	    return bancos.getBancos();
	}

	@PostMapping("/bancos")
	public Banco guardarBanco(@Valid @RequestBody Banco banco) {
	    return bancos.guardarBanco(banco);
	}

	@GetMapping("/bancos/{id}")
	public Banco getBancoById(@PathVariable(value = "id") Integer bancoId) {
	    return bancos.getBancoById(bancoId);
	}

	@PutMapping("/bancos/{id}")
	public Banco actualizarBanco(@PathVariable(value = "id") Integer bancoId, @Valid @RequestBody Banco nuevoBanco) {
	    return bancos.actualizarBanco(nuevoBanco, bancoId);
	}

	@DeleteMapping("/bancos/{id}")
	public ResponseEntity<?> borrarBanco(@PathVariable(value = "id") Integer bancoId) {
		bancos.borrarBanco(bancoId);
	    return ResponseEntity.ok().build();
	}
}
