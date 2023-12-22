package proyecto.backend.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.backend.entidades.Coche;
import proyecto.backend.repositorio.CocheRepositorio;

@Service
public class CocheServicio {

	@Autowired
	private CocheRepositorio cocherepositorio;
	
	public Iterable<Coche> listarTodosLosCoches(){
		return cocherepositorio.findAll();
	}
	
	public Coche guardarCoche(Coche coche) {
		System.out.print(coche);
		return cocherepositorio.save(coche);
	}
	
	public Coche obtenerCochePorId(Long id) {
		return cocherepositorio.findById(id).orElseThrow( ()  ->
		new IllegalArgumentException("Coche no encontrado con id: " + id));
	}
	
	public void eliminarCoche(Long id) {
		cocherepositorio.deleteById(id);
	}
}
