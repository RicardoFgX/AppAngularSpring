package proyecto.backend.repositorio;

import org.springframework.data.repository.CrudRepository;

import proyecto.backend.dto.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    Usuario findByUser(String username);
}
