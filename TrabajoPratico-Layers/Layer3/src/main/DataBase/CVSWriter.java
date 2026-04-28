import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CVSWriter implements EscritorMetod {

    @Override
    public void inscribir(Participantes participante, String path) {
        // Formato: Apellido, Nombre, Teléfono, Email, Dni, IdConcurso
        String linea = String.format("%s, %s, %s, %s, %s, %s",
                participante.getApellido(),
                participante.getNombre(),
                participante.getTelefono(),
                participante.getEmail(),
                participante.getDni(),
                participante.getIdConcurso());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(linea);
            bw.newLine(); // salto de línea
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al escribir inscripción en archivo: " + e.getMessage());
        }
    }
}
