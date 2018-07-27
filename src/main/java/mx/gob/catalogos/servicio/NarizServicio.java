package mx.gob.catalogos.servicio;

import java.util.List;
import mx.gob.catalogos.modelo.Nariz;

public interface NarizServicio {
	public Nariz guardarNariz(Nariz nariz);
	public List<Nariz> getNarices();
	public Nariz getNarizById(Integer id);
	public Nariz actualizarNariz(Nariz nuevaNariz, Integer id);
	public void borrarNariz(Integer id);
}