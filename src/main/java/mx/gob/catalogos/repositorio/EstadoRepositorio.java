package mx.gob.catalogos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.catalogos.modelo.Estado;

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, Integer>{
}