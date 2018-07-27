package mx.gob.catalogos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.catalogos.modelo.CompaniaTelefono;

@Repository
public interface CompaniaTelefonoRepositorio extends JpaRepository<CompaniaTelefono, Integer>{
}