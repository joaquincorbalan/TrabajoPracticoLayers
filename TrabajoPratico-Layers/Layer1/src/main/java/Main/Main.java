package Main;

import DataBase.ConnectionManager;
import DataBase.ParticipanteJDBC;
import Layer.AgregarParticipante;
import Modelo.Participantes;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConnectionManager connectionManager = new ConnectionManager("jdbc:derby://localhost:1527/participantes;create=true", "app", "app");
                    new AgregarParticipante(new Participantes(new ParticipanteJDBC(connectionManager)));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}