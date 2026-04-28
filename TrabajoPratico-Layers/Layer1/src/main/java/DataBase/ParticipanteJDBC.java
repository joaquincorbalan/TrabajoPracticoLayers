package DataBase;

import Modelo.Participante;
import Modelo.RegistroParticipantes;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ParticipanteJDBC implements RegistroParticipantes {
    private Connection conexion;

    public ParticipanteJDBC(ConnectionManager connectionManager) {
        this.conexion = connectionManager.getConnection();
    }

    @Override
    public void registrar(Participante participante) throws Exception {
        try (PreparedStatement st = conexion
                .prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)")) {
            st.setString(1, participante.getNombre());
            st.setString(2, participante.getTelefono());
            st.setString(3, participante.getRegion());
            st.executeUpdate();
        }
    }

    @Override
    public String registrarTest(Participante participante) throws Exception {
        return "";
    }


}
