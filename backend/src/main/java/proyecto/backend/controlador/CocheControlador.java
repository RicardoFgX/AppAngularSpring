package proyecto.backend.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto.backend.entidades.Coche;
import proyecto.backend.servicio.CocheServicio;

@RestController
@RequestMapping("/api/coches")
@CrossOrigin(origins = "http://localhost:4200")
public class CocheControlador {

    @Autowired
    private CocheServicio cocheServicio;

    @GetMapping
    public ResponseEntity<Iterable<Coche>> obtenerTodosLosCoches() {
        Iterable<Coche> coches = cocheServicio.listarTodosLosCoches();
        return new ResponseEntity<>(coches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coche> obtenerCochePorId(@PathVariable Long id) {
        Coche coche = cocheServicio.obtenerCochePorId(id);
        return new ResponseEntity<>(coche, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Coche> agregarCoche(@RequestBody Coche coche) {
        Coche nuevoCoche = cocheServicio.guardarCoche(coche);
        return new ResponseEntity<>(nuevoCoche, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coche> actualizarCoche(@PathVariable Long id, @RequestBody Coche cocheActualizado) {
    	cocheActualizado.setId(id);
        Coche cocheExistente = cocheServicio.obtenerCochePorId(id);

        if (cocheExistente!= null) {
            Coche cocheActualizadoDB = cocheServicio.guardarCoche(cocheActualizado);

            return new ResponseEntity<>(cocheActualizadoDB, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarCoche(@PathVariable Long id) {
        cocheServicio.eliminarCoche(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
