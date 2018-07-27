package mx.gob.catalogos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.catalogos.modelo.ColorPiel;

@Repository
public interface ColorPielRepositorio extends JpaRepository<ColorPiel, Integer>{
}