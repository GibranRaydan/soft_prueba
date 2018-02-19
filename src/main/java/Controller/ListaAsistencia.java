/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Dao.AsistenciaDAO;
import Model.Asistencia;
import java.io.IOException;
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
public class ListaAsistencia extends HttpServlet{
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
            int id_curso = Integer.parseInt(request.getParameter("id_curso"));
            int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
            String fecha = (String) request.getParameter("fecha");
            int vino = Integer.parseInt(request.getParameter("vino"));
           

            AsistenciaDAO dao = new AsistenciaDAO();
            Asistencia tab = new Asistencia(id_estudiante, fecha, vino, id_curso, id_estudiante);

            dao.addAsistencia(tab);

            response.sendRedirect("addAsistencia");

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
