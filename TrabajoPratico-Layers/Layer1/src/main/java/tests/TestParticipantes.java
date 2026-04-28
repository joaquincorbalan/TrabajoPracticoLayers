package tests;

import Modelo.Participante;
import Modelo.Participantes;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestParticipantes {

    @Test
    void TestParticipantes() throws Exception {
        Participantes participantes = new Participantes(new FakeParticipanteJDBC());
        participantes.nuevoParticipante("Joaquin Corbalan", "2920-487204", "US");
        //No supe como verificar esto
    }

    @Test
    void deberiaFallarSiNombreVacio() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Participante("", "China", "1234-567890");
        });

        assertEquals("Debe cargar un nombre", ex.getMessage());
    }


    @Test
    void deberiaFallarSiNombreNull() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Participante(null, "China", "1234-567890");
        });

        assertEquals("Debe cargar un nombre", ex.getMessage());
    }


    @Test
    void deberiaFallarSiTelefonoVacio() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Participante("Juan", "China", "");
        });

        assertEquals("Debe cargar un teléfono", ex.getMessage());
    }


    @Test
    void deberiaFallarSiTelefonoNull() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Participante("Juan", "China", null);
        });

        assertEquals("Debe cargar un teléfono", ex.getMessage());
    }


    @Test
    void deberiaFallarSiRegionInvalida() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Participante("Juan", "Argentina", "1234-567890");
        });

        assertEquals("Región desconocida. Las conocidas son: China, US, Europa", ex.getMessage());
    }

    @Test
    void deberiaFallarSiRegionNull() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Participante("Juan", null, "1234-567890");
        });

        assertEquals("Región desconocida. Las conocidas son: China, US, Europa", ex.getMessage());
    }


    @Test
    void deberiaFallarSiTelefonoFormatoInvalido() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Participante("Juan", "China", "1234567890");
        });

        assertEquals("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN", ex.getMessage());
    }
}