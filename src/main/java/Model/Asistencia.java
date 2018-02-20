/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author anfeg
 */
public class Asistencia {

  
    private String fecha;
    private int vino;
    private int id_curso;
    private int id_estudiante;

    public Asistencia( String fecha, int vino, int id_curso, int id_estudiante) {
        
        this.fecha = fecha;
        this.vino = vino;
        this.id_curso = id_curso;
        this.id_estudiante = id_estudiante;
    }

    public Asistencia() {
    }

    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getVino() {
        return vino;
    }

    public void setVino(int vino) {
        this.vino = vino;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

}
