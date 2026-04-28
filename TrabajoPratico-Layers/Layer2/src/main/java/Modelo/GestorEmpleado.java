package Modelo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestorEmpleado {
    private List<Empleado> empleados;

    public GestorEmpleado(List<Empleado> empleados) {
        this.empleados = new ArrayList<>();
        this.empleados = empleados;
    }

    public Optional<List<Empleado>> getEmpleadosFiltrados(LocalDate fechaHoy) {
        return Optional.of(empleados.stream().filter(e -> e.getFechaNacimiento().getMonthValue() == fechaHoy.getMonthValue()
                && e.getFechaNacimiento().getDayOfMonth() == fechaHoy.getDayOfMonth()).toList());
    }

    public Optional<Map<String, LocalDate>> getEmpleadosFiltradosMap(LocalDate fecha) {
        //return Optional.of(this.empleados = this.empleados.stream().filter(e -> e.getFechaNacimiento().equals(fecha)).toMap);
        Map<String, LocalDate> empleadosFiltrados = empleados.stream().filter(e -> e.getFechaNacimiento().equals(fecha))
                .collect(Collectors.toMap(
                        Empleado::getNombreCompleto,
                        Empleado::getFechaNacimiento
                ));
        return Optional.of(empleadosFiltrados);
    }
}