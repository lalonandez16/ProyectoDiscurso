/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.htee.discursos.negocio.implementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.htee.discursos.negocio.interfaz.ITemaNegocio;
import mx.htee.discursos.persistencia.dbConnection;
import mx.htee.discursos.entidades.Tema;

/**
 *
 * @author lalon
 */
public  class TemaNegocio implements ITemaNegocio{
    
    dbConnection db;
    
    public TemaNegocio()
    {
        db = new dbConnection();        
    }
    public boolean agregarTema(Tema t)
    {
        boolean resultado= true;
        
        String q = "INSERT INTO tema(nombre) " +
                "VALUES(?)";
        try
        {
            PreparedStatement pstm = db.connect().prepareStatement(q);
            pstm.setString(1, t.getNombre());

            resultado = pstm.execute();
            pstm.close();

        }catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        
        return resultado;
    }
    
    
    public boolean eliminarTema(Tema t)
    {   
        
        boolean resultado = true;
        String q = "DELETE FROM tema WHERE id = ?";
        
        try{
            PreparedStatement pstm = db.connect().prepareStatement(q);
            
            pstm.setInt(1, t.getId());
            
            resultado = pstm.execute();
            pstm.close();
            
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        
        return resultado;
    }
    
    public boolean editarTema(Tema t)
    {
        boolean resultado = true;
        String q = "UPDATE tema SET nombre=? WHERE id = ?";
        
        try{
            
            PreparedStatement pstm = db.connect().prepareStatement(q);
            
            pstm.setString(1, t.getNombre());
            pstm.setInt(2, t.getId());
            
            resultado = pstm.execute();
            pstm.close();
        }catch(SQLException ex){
        System.err.println(ex.getMessage());
    }
        return resultado;
    }

    
    public List<Tema> buscarTemaPor(String tipo, String nombreT, int idT)
    {
        
        boolean resultado = true;
        Tema t = new Tema();
        List<Tema> tem = new ArrayList<Tema>();

        String q = "SELECT * FROM tema WHERE id= ?";
        String w = "SELECT * FROM tema WHERE nombre LIKE  '%"+nombreT+"%'";
        
        try
        {
            
            if(tipo=="id")
            {
                PreparedStatement pstm = db.connect().prepareStatement(q);
                
                pstm.setInt(1, idT);
                ResultSet rs = pstm.executeQuery();

                rs.next();
                t.setId(rs.getInt("id"));
                t.setNombre(rs.getString("nombre"));
                tem.add(t);
            }
            
            if(tipo=="nombre")
            {
                PreparedStatement pstm = db.connect().prepareStatement(w);
                //pstm.setString(1, nombreT);
                ResultSet rs = pstm.executeQuery();
                
                while(rs.next())
                {
                    Tema ta = new Tema();
                    ta.setId(rs.getInt("id"));
                    ta.setNombre(rs.getString("nombre"));
                    tem.add(ta);
                }
                rs.close();
            }
            
            
            

        }catch(SQLException ex)
                    {
                        System.out.println(ex.getMessage());
                    }
        return tem;
    }
    
    public List<Tema> traerTodos()
    {
        List<Tema> temas = new ArrayList<Tema>();
        
        String q = "SELECT * FROM tema";
        
        try
        {
            PreparedStatement pstm = db.connect().prepareStatement(q);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next())
            {
                Tema ta = new Tema();
                ta.setId(rs.getInt("id"));
                ta.setNombre(rs.getString("nombre"));
                temas.add(ta);
                
            }
            
            
            
            pstm.close();
            
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return temas;
    }
    
    
}
