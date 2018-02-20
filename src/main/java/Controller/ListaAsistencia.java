/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Dao.AsistenciaDAO;
import Model.Asistencia;
import Model.Estudiante;
import Model.Profesor;
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
        String fecha= null;
        int id_estudiante =0;
        String vino = null;
        for(int i=0; i<lista.size();i++){           
            
            fecha= (String) request.getParameter("fecha");
            id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
            vino = (String) request.getParameter("asistencia");
            
            System.out.println(fecha);
            System.out.println(id_estudiante);
            System.out.println(vino);
           
            int aux=1;
            if (vino == "false"){
                aux=2;
            }
            Asistencia asistencia = new Asistencia( fecha, aux, 0 , id_estudiante);
            
            AsistenciaDAO dao = new AsistenciaDAO();
            dao.addAsistencia(asistencia);
          
        }
        
        
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
