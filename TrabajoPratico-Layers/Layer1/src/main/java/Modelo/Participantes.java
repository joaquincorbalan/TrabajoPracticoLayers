package Modelo;

public class Participantes {
    private RegistroParticipantes registroParticipantes;

    public Participantes(RegistroParticipantes registroParticipantes) {
        this.registroParticipantes = registroParticipantes;
    }

    public void nuevoParticipante(String nombre, String telefono, String region) throws Exception {
        try {
            Participante participante = new Participante(nombre, region, telefono);
            this.registroParticipantes.registrar(participante);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
