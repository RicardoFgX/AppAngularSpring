package proyecto.backend.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import proyecto.backend.entidades.Coche;

@Repository
public interface CocheRepositorio extends CrudRepository<Coche, Long> {

}
