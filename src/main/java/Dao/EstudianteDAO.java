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

    public ArrayList<Estudiante> getAsistenciaID(int a) throws SQLException, URISyntaxException {
        ArrayList<Estudiante> estudiante = null;
        String query = "SELECT * FROM estudiante where id_estudiante= " + a;
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id_estudiante = 0;
            String nombre_estudiante= null;
            String contacto_estudiante=null;
            int id_curso=0;

            while (rs.next()) {
                if (estudiante == null) {
                    estudiante = new ArrayList<Estudiante>();
                }
                Estudiante registro = new Estudiante(id_estudiante, nombre_estudiante, contacto_estudiante, id_curso);

                id_estudiante = rs.getInt("id_estudiante");
                registro.setId_estudiante(id_estudiante);

                nombre_estudiante = rs.getString("nombre_estudiante");
                registro.setNombre_estudiante(nombre_estudiante);

                
                contacto_estudiante = rs.getString("contacto_estudiante");
                registro.setContacto_estudiante(contacto_estudiante);
                
                id_curso =rs.getInt("id_curso");
                registro.setId_curso(id_curso);
                
                estudiante.add(registro);

            }
            if (estudiante != null) {
                for (int i = 0; i < estudiante.size(); i++) {
                    System.out.println(estudiante.get(i).getId_estudiante()+ " " + estudiante.get(i).getId_curso() + " " + estudiante.get(i).getNombre_estudiante()+ " " + estudiante.get(i).getContacto_estudiante());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Profesores");
            e.printStackTrace();
        }

        return estudiante;

    }

}
