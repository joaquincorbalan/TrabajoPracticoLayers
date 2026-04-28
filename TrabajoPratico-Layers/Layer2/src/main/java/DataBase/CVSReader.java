package DataBase;

import Modelo.Empleado;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CVSReader implements LectorDeTexto {
    List<String[]> csvData;
    String[] row;
    String path;

    public CVSReader(String path) throws FileNotFoundException {
        this.csvData = new ArrayList<String[]>();
        this.row = null;
        this.path = path;
    }

    @Override
    public List<Empleado> leer() {
        List<Empleado> empleados = new ArrayList<>();

        InputStream is = getClass().getResourceAsStream(this.path);
        if (is == null) {
            throw new RuntimeException("No se encontró el archivo ListaEmpleados.txt en resources");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) { // saltar encabezado
                    primeraLinea = false;
                    continue;
                }

                String[] partes = linea.split(",\\s*");
                String apellido = partes[0];
                String nombre = partes[1];
                LocalDate fecha = LocalDate.parse(partes[2], formatter);
                String email = partes[3];

                empleados.add(new Empleado(nombre, apellido, email, fecha));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return empleados;
    }

}
