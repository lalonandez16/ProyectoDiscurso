/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.htee.discursos.entidades;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.htee.discursos.negocio.implementacion.DiscursoNegocio;
import mx.htee.discursos.persistencia.dbConnection;
import mx.htee.discursos.negocio.implementacion.TemaNegocio;
import mx.htee.discursos.negocio.interfaz.IDiscursoNegocio;
import mx.htee.discursos.negocio.interfaz.ITemaNegocio;

/**
 *
 * @author lalon
 */
public class Discu {

    dbConnection connect;
    /**
     * @param args the command line arguments
     */
    public Discu(){
        connect = new dbConnection();
    }
   
    public static void main(String[] args) {
        ITemaNegocio nt = new TemaNegocio();
        Tema t = new Tema();
        t.setId(3);
        t.setNombre("litu");
        List<Tema> te = new ArrayList<Tema>();
        
        Discu dis = new Discu();
        IDiscursoNegocio dn = new DiscursoNegocio();
        List<Discurso> lDiscurso = new ArrayList<Discurso>();
        
        
        dn.agregarDiscurso("El amor", t, 34);
        lDiscurso = dn.buscarDiscursoPor("id", "", 2, 0);
        
        for(Discurso listD : dn.traerTodosDis()){
            
        }
        
        
        
        /** METODOS de TEMA
         * 
         * nt.agregarTema(t);
         * nt.eliminarTema(t);
         * nt.editarTema(t);
         * te = nt.buscarTema("nombre","s", 3);
         *
         *
         * te = nt.traerTodos();
         * int total =te.size();
         * 
         * 
         * 
         * for(int i=0; i<=total-1; i++)
         * {
         *    System.out.println("Id: "+te.get(i).getId() +" Nombre: "+te.get(i).getNombre());            
         * }
         * System.out.println("_________________________________________________");
         * for(Tema ListaNombres : te)
         * {
         *     System.out.println("ID: "+ListaNombres.getId()+" NOMBRE: "+ListaNombres.getNombre());
         * }
         * 
         */
        
        
        
        
    }
    
}
