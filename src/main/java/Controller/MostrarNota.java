/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.NotaDAO;
import Model.Nota;
import Model.Profesor;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class MostrarNota extends HttpServlet {

    private static final long serialVersionUID = 1L;

    List<Nota> notas = new LinkedList<Nota>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
            
            response.setContentType("application/json");         
            PrintWriter out = response.getWriter();         
            JSONObject obj = new JSONObject();         
        try {         
            obj.put("estudiante", "Laura Sofia");
            obj.put("estudiante", "Laura ");
            obj.put("tema", "Lectoescritura");
            obj.put("tema", "Lectoescritura");
            obj.put("nota", "Excelente");
            obj.put("nota", "Malo");

        } catch (JSONException ex) {
            Logger.getLogger(MostrarNota.class.getName()).log(Level.SEVERE, null, ex);
        }
            out.print(obj);

       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. get received JSON data from request
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if (br != null) {
            json = br.readLine();
        }

        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();

        // 3. Convert received JSON to Article
        Nota nota = mapper.readValue(json, Nota.class);

        // 4. Set response type to JSON
        response.setContentType("application/json");

        // 5. Add article to List<Article>
        notas.add(nota);

        // 6. Send List<Article> as JSON to client
        mapper.writeValue(response.getOutputStream(), notas);
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
