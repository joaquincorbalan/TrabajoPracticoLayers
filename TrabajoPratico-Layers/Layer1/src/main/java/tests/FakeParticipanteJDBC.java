package tests;

import Modelo.Participante;
import Modelo.RegistroParticipantes;

public class FakeParticipanteJDBC implements RegistroParticipantes {
    @Override
    public void registrar(Participante participante) throws Exception {

    }

    @Override
    public String registrarTest(Participante participante) throws Exception {
        return "Fake Registro llevado con exito";
    }
}
