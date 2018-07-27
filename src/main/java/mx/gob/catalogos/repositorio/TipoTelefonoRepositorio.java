package mx.gob.catalogos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.catalogos.modelo.TipoTelefono;

@Repository
public interface TipoTelefonoRepositorio extends JpaRepository<TipoTelefono, Integer>{
}