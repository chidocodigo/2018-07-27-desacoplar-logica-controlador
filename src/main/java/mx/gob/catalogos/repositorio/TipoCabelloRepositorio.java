package mx.gob.catalogos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.catalogos.modelo.TipoCabello;

@Repository
public interface TipoCabelloRepositorio extends JpaRepository<TipoCabello, Integer>{
}