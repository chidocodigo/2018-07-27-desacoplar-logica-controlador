package mx.gob.catalogos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.catalogos.modelo.Frente;

@Repository
public interface FrenteRepositorio extends JpaRepository<Frente, Integer>{
}