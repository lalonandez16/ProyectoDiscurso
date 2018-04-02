/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.htee.discursos.entidades;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author lalon
 */
public class Discursar {
    
    int id;
    Date fecha;
    Time hora;
    String nombreCongre;
    Discurso discurso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getNombreCongre() {
        return nombreCongre;
    }

    public void setNombreCongre(String nombreCongre) {
        this.nombreCongre = nombreCongre;
    }

    public Discurso getDiscurso() {
        return discurso;
    }

    public void setDiscurso(Discurso discurso) {
        this.discurso = discurso;
    }
    
    
    
    
    
}
