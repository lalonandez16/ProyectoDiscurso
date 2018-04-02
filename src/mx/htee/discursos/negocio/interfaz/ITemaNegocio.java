/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.htee.discursos.negocio.interfaz;

import java.util.List;
import mx.htee.discursos.entidades.Tema;

/**
 *
 * @author lalon
 */
public interface ITemaNegocio {
    
    public boolean agregarTema(Tema t);
    
    public boolean eliminarTema(Tema t);
    
    public boolean editarTema(Tema t);
    
    public List<Tema> buscarTemaPor(String tipo, String nombreT, int idT);
    
    public List<Tema> traerTodos();
    
}
