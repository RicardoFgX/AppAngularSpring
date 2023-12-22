package proyecto.backend.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import proyecto.backend.dto.Usuario;
import proyecto.backend.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
/*
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
*/
    public boolean validarCredenciales(String username, String password) {
    	System.out.print(username);
    	System.out.print(password);
        Usuario usuario = usuarioRepositorio.findByUser(username);
        return usuario != null && password.matches(usuario.getPwd());
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
}
