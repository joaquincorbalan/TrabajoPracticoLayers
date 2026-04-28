package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
    private Connection dbConn;

    public ConnectionManager(String url, String user, String password) throws SQLException {
        setupBaseDeDatos(url, user, password);
    }

    private void setupBaseDeDatos(String url, String user, String password) throws SQLException {
        this.dbConn = DriverManager.getConnection(url, user, password);
        //Metodos que cree debido a que "no se encontraba la tabla participantes"
        //eliminarTablaParticipante();
        //generarTabla();

    }

    private void generarTabla() throws SQLException {
        try (Statement stmt = dbConn.createStatement()) {
            stmt.executeUpdate(
                    "CREATE TABLE participantes (" +
                            "nombre VARCHAR(100), " +
                            "telefono VARCHAR(100), " +
                            "region VARCHAR(100)" + ")");
        } catch (SQLException e) {
            if (!e.getSQLState().equals("Tabla ya existente")) {
                throw e;
            }
        }
    }

    private void eliminarTablaParticipante() throws SQLException {
        try (Statement stmt = dbConn.createStatement()) {
            stmt.executeUpdate("DROP TABLE participantes");
        } catch (SQLException e) {
            // X0Y32 = la tabla no existe, lo podés ignorar
            if (!"42Y55".equals(e.getSQLState())) { // 42Y55 = tabla no encontrada
                throw e;
            }
        }

    }

    public Connection getConnection() {
        return dbConn;
    }
}

