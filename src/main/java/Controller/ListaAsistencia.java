/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AsistenciaDAO;
import Dao.EstudianteDAO;
import Model.Asistencia;
import Model.Estudiante;
import Model.Profesor;
import java.io.IOException;
import static java.lang.System.out;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gibran
 */
public class ListaAsistencia extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            AsistenciaDAO obj = new AsistenciaDAO();
            Profesor p = (Profesor) request.getSession().getAttribute("profesor");

            ArrayList<Estudiante> lista = (ArrayList<Estudiante>) obj.getEstudiantesIDCurso(p.getId_curso());

            request.setAttribute("listaCurso", lista);

            request.getRequestDispatcher("addAsistencia.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ListaAsistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ListaAsistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            
            AsistenciaDAO obj = new AsistenciaDAO();
            Profesor p = (Profesor) request.getSession().getAttribute("profesor");
            ArrayList<Estudiante> lista = (ArrayList<Estudiante>) obj.getEstudiantesIDCurso(p.getId_curso());
            
            int id_curso= p.getId_curso();
           
            
            for (int i=0; i<lista.size();i++) {
                
               // int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
               // int vino = Integer.parseInt(request.getParameter("opciones"));
                
             
                
                //String fecha = (String) request.getParameter("fecha");
                Asistencia asistencia = new Asistencia("12/12/12", 1, id_curso, 1 );
                obj.addAsistencia(asistencia);
               
            }
            
            response.sendRedirect("ListaAsistencia");
        } catch (SQLException ex) {
            Logger.getLogger(ListaAsistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ListaAsistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}