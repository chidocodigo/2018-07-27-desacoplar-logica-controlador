package mx.gob.catalogos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.catalogos.modelo.Estado;
import mx.gob.catalogos.modelo.Municipio;
import java.util.List;

@Repository
public interface MunicipioRepositorio extends JpaRepository<Municipio, Integer>{
	List<Municipio> findByEstadoId(Integer estadoId);
}