package mx.gob.catalogos.servicio;

import java.util.List;
import mx.gob.catalogos.modelo.CompaniaTelefono;

public interface CompaniaTelefonoServicio {
	public CompaniaTelefono guardarCompaniaTelefono(CompaniaTelefono companiaTelefono);
	public List<CompaniaTelefono> getCompaniasTelefono();
	public CompaniaTelefono getCompaniaTelefonoById(Integer id);
	public CompaniaTelefono actualizarCompaniaTelefono(CompaniaTelefono nuevaCompaniaTelefono, Integer id);
	public void borrarCompaniaTelefono(Integer id);
}