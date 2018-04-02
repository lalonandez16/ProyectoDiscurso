/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.htee.discursos.negocio.interfaz;

import java.util.List;
import mx.htee.discursos.entidades.Discurso;
import mx.htee.discursos.entidades.Tema;

/**
 *
 * @author lalon
 */
public interface IDiscursoNegocio {
    
    public  boolean agregarDiscurso(String nombreD, Tema tema, int numeroD);
    
    public boolean eliminarDiscurso(int id);
    
    public boolean editarDiscurso(Discurso disc);
    
    public List<Discurso> buscarDiscursoPor(String categoria, String nombreD, int idD, int numeroD);
    
    List<Discurso> traerTodosDis();
    
}
