package mx.gob.catalogos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.catalogos.modelo.Boca;

@Repository
public interface BocaRepositorio extends JpaRepository<Boca, Integer>{
}