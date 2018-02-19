/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.Profesor;
import util.DbUtil;
/**
 *
 * @author anfeg
 */
public class ProfesorDAO {
    
     private Connection connection;

    public ProfesorDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }

   public ArrayList<Profesor> getProfesorID(int a) throws SQLException, URISyntaxException {
        ArrayList<Profesor> profesor = null;
        boolean result = false;
        String query = "SELECT * FROM profesor where id_profesor= " + a;
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id_profesor = 0;
            String nombre_profesor = null;
            String descripcion_profesor = null;
            String contacto_profesor = null;
            String usuario_profesor = null;
            String password_profesor = null;
            int id_curso = 0;
           
            while (rs.next()) {
                if (profesor == null) {
                    profesor = new ArrayList<Profesor>();
                }
                Profesor registro = new Profesor(id_profesor, nombre_profesor, descripcion_profesor, contacto_profesor, usuario_profesor, password_profesor, id_curso);
                id_profesor = rs.getInt("id_profesor");
                registro.setId_profesor(id_profesor);

                nombre_profesor = rs.getString("nombre_profesor");
                registro.setNombre_profesor(nombre_profesor);

                descripcion_profesor = rs.getString("descripcion_profesor");
                registro.setDescripcion_profesor(descripcion_profesor);

                contacto_profesor = rs.getString("contacto_profesor");
                registro.setContacto_profesor(contacto_profesor);

                usuario_profesor = rs.getString("usuario_profesor");
                registro.setUsuario_profesor(usuario_profesor);

                password_profesor = rs.getString("password_profesor");
                registro.setPassword_profesor(password_profesor);

                id_curso = rs.getInt("id_curso");
                registro.setId_curso(id_curso);

                profesor.add(registro);

            }
            if (profesor != null) {
                for (int i = 0; i < profesor.size(); i++) {
                    System.out.println(profesor.get(i).getId_profesor()+ " " + profesor.get(i).getNombre_profesor()+ " " + profesor.get(i).getDescripcion_profesor()+ " " + profesor.get(i).getContacto_profesor() + " " + profesor.get(i).getUsuario_profesor() + " " + profesor.get(i).getPassword_profesor() + " " + profesor.get(i).getId_curso());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Profesores");
            e.printStackTrace();
        }

        return profesor;

    }
   
   public ArrayList<Profesor> getAllProfesores() throws SQLException {
        ArrayList<Profesor> profesores = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from profesor");
        while (rs.next()) {
            Profesor c = new Profesor();
            c.setId_profesor(rs.getInt("id_profesor"));
            c.setNombre_profesor(rs.getString("nombre_profesor"));
            c.setContacto_profesor(rs.getString("contacto_profesor"));
            c.setDescripcion_profesor(rs.getString("descripcion_profesor"));
            c.setId_curso(rs.getInt("id_curso"));
            c.setUsuario_profesor(rs.getString("usuario_profesor"));
            c.setPassword_profesor(rs.getString("password_profesor"));
            profesores.add(c);
        }
        return profesores;
    }


}
