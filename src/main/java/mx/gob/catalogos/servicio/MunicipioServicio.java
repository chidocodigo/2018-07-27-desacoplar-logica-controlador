package mx.gob.catalogos.servicio;

import java.util.List;
import mx.gob.catalogos.modelo.Municipio;

public interface MunicipioServicio {
	public Municipio guardarMunicipio(Municipio municipio,Integer estadoId);
	public List<Municipio> getMunicipios();
	public List<Municipio> getMunicipiosbyEstadoId(Integer estadoId);
	public Municipio getMunicipioById(Integer id);
	public Municipio actualizarMunicipio(Municipio nuevoMunicipio, Integer municipioId);
	public void borrarMunicipio(Integer id);
}