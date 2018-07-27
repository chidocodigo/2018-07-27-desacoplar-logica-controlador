package mx.gob.catalogos.servicioImplementacion;

import java.util.List;

import mx.gob.catalogos.modelo.Banco;
import mx.gob.catalogos.servicio.BancoServicio;
import mx.gob.catalogos.repositorio.BancoRepositorio;
import mx.gob.catalogos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class BancoServicioImp implements BancoServicio {

	@Autowired
	private BancoRepositorio bancoRepositorio;

	@Override
	public Banco guardarBanco(Banco banco) {
		return bancoRepositorio.save(banco);
	}

	@Override
	public List<Banco> getBancos() {
		return bancoRepositorio.findAll();
	}

	@Override
	public Banco getBancoById(Integer id) {
		return bancoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Banco", "id", id));
	}

	@Override
	public Banco actualizarBanco(Banco nuevoBanco, Integer id) {
		Banco bancoActual = bancoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Banco", "id", id));
		
		bancoActual.setActivo(nuevoBanco.getActivo());
		bancoActual.setNombre(nuevoBanco.getNombre());
		
		Banco bancoActualizado = bancoRepositorio.save(bancoActual);
		return bancoActualizado;
	}

	@Override
	public void borrarBanco(Integer id) {
		Banco banco = bancoRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Banco", "id", id));
		
		bancoRepositorio.delete(banco);
	}

}
