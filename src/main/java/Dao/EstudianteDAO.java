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
import Model.Estudiante;
import Model.Profesor;
import util.DbUtil;

/**
 *
 * @author Gibran
 */
public class EstudianteDAO {

    private Connection connection;

    public EstudianteDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }

   
    public ArrayList<Estudiante> getEstudiantesByIDCurso(int id_curso) throws SQLException,URISyntaxException {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from estudiante where id_curso="+id_curso);
        while (rs.next()) {
            Estudiante c = new Estudiante();
            c.setId_estudiante(rs.getInt("id_estudiante"));
            c.setNombre_estudiante(rs.getString("nombre_estudiante"));
            c.setContacto_estudiante(rs.getString("contacto_estudiante"));
            c.setId_curso(rs.getInt("id_curso"));
            estudiantes.add(c);
        }
        return estudiantes;
    }
    
    

    public Estudiante getEstudianteById(int idEst) throws SQLException,URISyntaxException{
        Estudiante e = new Estudiante();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from estudiante where id_estudiante="+idEst);
        while (rs.next()) {
            e.setId_estudiante(rs.getInt("id_estudiante"));
            e.setNombre_estudiante(rs.getString("nombre_estudiante"));
            e.setContacto_estudiante(rs.getString("contacto_estudiante"));
            e.setId_curso(rs.getInt("id_curso"));
        }
        return e;
    }

}
