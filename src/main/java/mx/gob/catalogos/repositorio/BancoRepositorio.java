package mx.gob.catalogos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.catalogos.modelo.Banco;

@Repository
public interface BancoRepositorio extends JpaRepository<Banco, Integer>{
}
