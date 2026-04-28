package Modelo;

import java.time.LocalDate;

public class Empleado {
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;

    public Empleado(String nombre, String apellido, String email, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String toString() {
        return nombre + " " + apellido + " ";
    }
}
