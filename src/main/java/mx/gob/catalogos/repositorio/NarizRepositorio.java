package mx.gob.catalogos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.catalogos.modelo.Nariz;

@Repository
public interface NarizRepositorio extends JpaRepository<Nariz, Integer>{
}