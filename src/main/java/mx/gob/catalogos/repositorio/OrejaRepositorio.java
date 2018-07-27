package mx.gob.catalogos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.catalogos.modelo.Oreja;

@Repository
public interface OrejaRepositorio extends JpaRepository<Oreja, Integer>{
}