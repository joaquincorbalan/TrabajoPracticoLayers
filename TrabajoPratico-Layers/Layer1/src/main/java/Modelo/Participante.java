package Modelo;

public class Participante {
    private String nombre;
    private String region;
    private String telefono;

    public Participante(String nombre, String region, String telefono) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un nombre");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un teléfono");
        }
        if (region == null ||
                (!region.equalsIgnoreCase("China") &&
                        !region.equalsIgnoreCase("US") &&
                        !region.equalsIgnoreCase("Europa"))) {
            throw new IllegalArgumentException("Región desconocida. Las conocidas son: China, US, Europa");
        }
        if (!validarTelefono(telefono)) {
            throw new IllegalArgumentException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }

        this.nombre = nombre;
        this.region = region;
        this.telefono = telefono;
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public String getNombre() {
        return nombre;
    }

    public String getRegion() {
        return region;
    }

    public String getTelefono() {
        return telefono;
    }
}
