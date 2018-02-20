/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Observador;
import util.DbUtil;

/**
 *
 * @author Gibran
 */
public class ObservadorDAO {

    private Connection connection;

    public ObservadorDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }

    public ArrayList<Observador> getObservadorByID(int id_estudiante) throws SQLException, URISyntaxException {
        ArrayList<Observador> notasObs = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from observador where id_estudiante=" + id_estudiante);
        while (rs.next()) {
            Observador c = new Observador();
            c.setId_estudiante(rs.getInt("id_estudiante"));
            c.setId_profesor(rs.getInt("id_profesor"));
            c.setCalificaciones(rs.getInt("calificacion"));
            c.setDetalles(rs.getString("detalles"));
            notasObs.add(c);
        }
        return notasObs;
    }

}
