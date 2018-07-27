package mx.gob.catalogos.servicio;

import java.util.List;
import mx.gob.catalogos.modelo.TipoTelefono;

public interface TipoTelefonoServicio {
	public TipoTelefono guardarTipoTelefono(TipoTelefono tipoTelefono);
	public List<TipoTelefono> getTiposTelefono();
	public TipoTelefono getTipoTelefonoById(Integer id);
	public TipoTelefono actualizarTipoTelefono(TipoTelefono nuevoTipoTelefono, Integer id);
	public void borrarTipoTelefono(Integer id);
}