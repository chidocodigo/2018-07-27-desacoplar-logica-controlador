package mx.gob.catalogos.servicio;

import java.util.List;
import mx.gob.catalogos.modelo.TipoCabello;

public interface TipoCabelloServicio {
	public TipoCabello guardarTipoCabello(TipoCabello tipoCabello);
	public List<TipoCabello> getTiposCabello();
	public TipoCabello getTipoCabelloById(Integer id);
	public TipoCabello actualizarTipoCabello(TipoCabello nuevoTipoCabello, Integer id);
	public void borrarTipoCabello(Integer id);
}