package mx.gob.catalogos.servicio;

import java.util.List;
import mx.gob.catalogos.modelo.Banco;

public interface BancoServicio {
	public Banco guardarBanco(Banco banco);
	public List<Banco> getBancos();
	public Banco getBancoById(Integer id);
	public Banco actualizarBanco(Banco nuevoBanco, Integer id);
	public void borrarBanco(Integer id);
}