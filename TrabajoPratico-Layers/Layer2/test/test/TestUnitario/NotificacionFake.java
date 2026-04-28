package TestUnitario;

import Modelo.Empleado;
import Modelo.Notification;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class NotificacionFake implements Notification {
    private final Optional<List<Empleado>> empleados;

    public NotificacionFake(Optional<List<Empleado>> empleados) {
        this.empleados = empleados;
    }


    @Override
    public Optional<String> enviarNotificacion() {
        return empleados
                .filter(list -> !list.isEmpty()) // asegura que no esté vacía
                .map(list -> "Feliz cumpleaños! " + list.get(0).getNombreCompleto());

    }


    private boolean hayEmpleados(Optional<Map<String, LocalDate>> empleados) {
        return empleados.isPresent();
    }
}