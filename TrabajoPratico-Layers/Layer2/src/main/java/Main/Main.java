package Main;

import DataBase.CVSReader;
import DataBase.LectorDeTexto;
import Modelo.Empleado;
import Modelo.GestorEmpleado;
import Modelo.Notificacion;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Optional<List<Empleado>> empleados = Optional.ofNullable(inicializarEmpleados());
        GestorEmpleado gestor = new GestorEmpleado(empleados.orElse(null));
        empleados = gestor.getEmpleadosFiltrados(LocalDate.now());
        Notificacion notificacion = new Notificacion("a61df6ee928375",
                "sandbox.smtp.mailtrap.io", "2525", "184b2d5fa04073", "CompañiaDeEjemplo",
                "Feliz Cumpleaños!!!!", empleados.orElse(null));
        System.out.println(notificacion.enviarNotificacion().get());
    }


    private static List<Empleado> inicializarEmpleados() throws FileNotFoundException {
        LectorDeTexto lector = new CVSReader("/ListaEmpleados.txt");
        List<Empleado> empleados = lector.leer();
        return empleados;
    }
}
