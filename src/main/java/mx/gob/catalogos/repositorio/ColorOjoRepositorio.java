package mx.gob.catalogos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.catalogos.modelo.ColorOjo;

@Repository
public interface ColorOjoRepositorio extends JpaRepository<ColorOjo, Integer>{
}