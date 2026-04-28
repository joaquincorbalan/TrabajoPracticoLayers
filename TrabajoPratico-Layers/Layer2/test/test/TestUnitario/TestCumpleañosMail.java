package TestUnitario;

import Modelo.Empleado;
import Modelo.GestorEmpleado;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.testng.AssertJUnit.assertEquals;

public class TestCumpleañosMail {

    @Test
    public void enviarNotificacionAfirmativaTest() {
        Empleado empleado = new Empleado("Tania", "Balbuena", "tania123@gmail", LocalDate.of(2003, 7, 18));
        GestorEmpleado g1 = new GestorEmpleado(List.of(empleado));
        NotificacionFake noti = new NotificacionFake(g1.getEmpleadosFiltrados(LocalDate.of(2003, 7, 18)));
        assertEquals("Feliz cumpleaños! " + empleado.getNombreCompleto(), noti.enviarNotificacion().get());


    }

    @Test
    public void enviarNotificacionNegativaTest() {
        Empleado empleado = new Empleado("Tania", "Balbuena", "tania123@gmail", LocalDate.of(2003, 7, 18));
        GestorEmpleado g1 = new GestorEmpleado(List.of(empleado));
        NotificacionFake noti = new NotificacionFake(g1.getEmpleadosFiltrados(LocalDate.now()));
        assertEquals(Optional.empty(), noti.enviarNotificacion());

    }

}

