/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.htee.discursos.entidades;

/**
 *
 * @author lalon
 */
public class Discurso {
    int id;
    String nombre;
    Tema temaa;
    int numero;

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

    public Tema getTemaa() {
        return temaa;
    }

    public void setTemaa(Tema temaa) {
        this.temaa = temaa;
    }
    
    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    
}
