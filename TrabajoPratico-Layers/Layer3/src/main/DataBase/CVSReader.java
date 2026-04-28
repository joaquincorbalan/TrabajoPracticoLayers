import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CVSReader implements LectorMetod {
    @Override
    public List<Concursos> recuperarConcursos(String path) {
        List<Concursos> concursos = new ArrayList<>();
        InputStream is = getClass().getResourceAsStream(path);
        if (is == null) {
            throw new RuntimeException("No se encontró el archivo" + path + "en resources");
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
                String idConcurso = partes[0];
                String nombre = partes[1];
                LocalDate fechaInicioIns = LocalDate.parse(partes[2], formatter);
                LocalDate fechaFinIns = LocalDate.parse(partes[3], formatter);

                concursos.add(new Concursos(idConcurso, nombre, fechaInicioIns, fechaFinIns));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return concursos;
    }


}
