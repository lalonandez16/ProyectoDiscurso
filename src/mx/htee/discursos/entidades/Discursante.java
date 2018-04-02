/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.htee.discursos.entidades;

import java.util.List;

/**
 *
 * @author lalon
 */
public class Discursante {
    
    int id;
    String nombre;
    String apellido;
    List<Discurso> discurso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Discurso> getDiscurso() {
        return discurso;
    }

    public void setDiscurso(List<Discurso> discurso) {
        this.discurso = discurso;
    }
    
    
   
    
    
    
}
