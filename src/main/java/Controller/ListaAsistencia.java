/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Dao.AsistenciaDAO;
import Dao.EstudianteDAO;
import Dao.ProfesorDAO;
import Model.Asistencia;
import Model.Estudiante;
import Model.Profesor;
import java.io.IOException;
import java.io.PrintWriter;
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
             
             
            EstudianteDAO obj = new EstudianteDAO();
            Profesor p = (Profesor) request.getSession().getAttribute("profesor");
            
            
            ArrayList<Estudiante> lista = (ArrayList<Estudiante>) obj.getAsistenciaID(p.getId_curso());
            response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet1 at " + lista.get(0).getNombre_estudiante() +"," +lista.get(1).getNombre_estudiante()+"</h1>");
            
            out.println("</body>");
            out.println("</html>");
        }
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
