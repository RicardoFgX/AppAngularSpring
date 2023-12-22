package proyecto.backend.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import proyecto.backend.entidades.Coche;
import proyecto.backend.servicio.CocheServicio;

@Component
public class InicializarDatos {

    @Autowired
    private CocheServicio servicio;

    @PostConstruct
    public void init() {
        Coche c1 = new Coche();
        c1.setMarca("Toyota");
        c1.setMatricula("123ABC");
        c1.setModelo("Corolla");

        Coche c2 = new Coche();
        c2.setMarca("Honda");
        c2.setMatricula("456XYZ");
        c2.setModelo("Civic");

        Coche c3 = new Coche();
        c3.setMarca("Ford");
        c3.setMatricula("789DEF");
        c3.setModelo("Focus");

        Coche c4 = new Coche();
        c4.setMarca("Chevrolet");
        c4.setMatricula("101GHJ");
        c4.setModelo("Malibu");

        Coche c5 = new Coche();
        c5.setMarca("Nissan");
        c5.setMatricula("112KLM");
        c5.setModelo("Altima");

        Coche c6 = new Coche();
        c6.setMarca("BMW");
        c6.setMatricula("131PQR");
        c6.setModelo("3 Series");

        Coche c7 = new Coche();
        c7.setMarca("Mercedes-Benz");
        c7.setMatricula("415STU");
        c7.setModelo("E-Class");

        Coche c8 = new Coche();
        c8.setMarca("Audi");
        c8.setMatricula("516VWX");
        c8.setModelo("A4");

        Coche c9 = new Coche();
        c9.setMarca("Hyundai");
        c9.setMatricula("617YZA");
        c9.setModelo("Elantra");

        Coche c10 = new Coche();
        c10.setMarca("Volkswagen");
        c10.setMatricula("718BCD");
        c10.setModelo("Jetta");

        System.out.print(c1);
        servicio.guardarCoche(c1);
        servicio.guardarCoche(c2);
        servicio.guardarCoche(c3);
        servicio.guardarCoche(c4);
        servicio.guardarCoche(c5);
        servicio.guardarCoche(c6);
        servicio.guardarCoche(c7);
        servicio.guardarCoche(c8);
        servicio.guardarCoche(c9);
        servicio.guardarCoche(c10);
    }
}
