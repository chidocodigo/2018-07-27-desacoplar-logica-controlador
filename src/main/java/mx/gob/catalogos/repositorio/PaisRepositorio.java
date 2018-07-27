package mx.gob.catalogos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.catalogos.modelo.Pais;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais, Integer>{
}