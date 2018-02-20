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
public class Observador {

    private int id_estudiante;
    private int id_profesor;
    private String detalles;
    private int calificaciones;

    public Observador(int id_estudiante, int id_profesor, String detalles, int calificaciones) {
        this.id_estudiante = id_estudiante;
        this.id_profesor = id_profesor;
        this.detalles = detalles;
        this.calificaciones = calificaciones;
    }

    public Observador() {
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(int calificaciones) {
        this.calificaciones = calificaciones;
    }

}
