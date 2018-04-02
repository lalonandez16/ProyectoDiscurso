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
import mx.htee.discursos.entidades.Discurso;
import mx.htee.discursos.entidades.Tema;
import mx.htee.discursos.negocio.interfaz.IDiscursoNegocio;
import mx.htee.discursos.negocio.interfaz.ITemaNegocio;
import mx.htee.discursos.persistencia.dbConnection;

/**
 *
 * @author lalon
 */
public class DiscursoNegocio implements IDiscursoNegocio{
    
    dbConnection db;
    
    
    public DiscursoNegocio(){
        db = new dbConnection();
    }
    public  boolean agregarDiscurso(String nombreD, Tema tema, int numeroD)
    {
        boolean resultado = true;
        
        String q = "INSERT INTO discurso(nombre, idTema, numero) VALUES (?,?,?)";
        try
        {
            PreparedStatement pstm = db.connect().prepareStatement(q);
            
            pstm.setString(1, nombreD);
            pstm.setInt(2, tema.getId());
            pstm.setInt(3, numeroD);
            
            resultado = pstm.execute();
            
            pstm.close();
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        
        
        
        
        return resultado;
    }
    
    public boolean eliminarDiscurso(int id)
    {
        boolean resultado = true;
        
        String q = "DELETE FROM tema WHERE id=?";
        try
        {
            PreparedStatement pstm = db.connect().prepareStatement(q);
            pstm.setInt(1, id);
            resultado = pstm.execute();
            pstm.close();
            
        }catch(SQLException e)
        {
            
            System.out.println(e.getMessage());
        }
        
        
        
        
        return resultado;
    }
    
    public boolean editarDiscurso(Discurso disc){
        
        boolean resultado = true;
        
        try
        {
            String q = "UPDATE discurso SET nombre = ?, idTema = ? WHERE id=?";
            PreparedStatement pstm = db.connect().prepareStatement(q);
            
            pstm.setString(1, disc.getNombre());
            pstm.setInt(2, disc.getTemaa().getId());
            pstm.setInt(3, disc.getId());
            
            resultado = pstm.execute();
            pstm.close();
            
            
            
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        
        return resultado;
    }
    
    public List<Discurso> buscarDiscursoPor(String categoria, String nombreD, int idD, int numeroD)
    {
        List<Discurso> lDiscurso = new ArrayList<Discurso>();
        ITemaNegocio tn = new TemaNegocio();
        
        String q = "SELECT * FROM discurso WHERE nombre LIKE '%?%'";
        String w = "SELECT * FROM discurso WHERE id = ?";
        String e = "SELECT * FROM discurso WHERE numero = ?";
        
        try
        {
            if(categoria == "nombre")
            {
                PreparedStatement pstm = db.connect().prepareStatement(q);
                pstm.setString(1, nombreD);
                
                ResultSet rs= pstm.executeQuery();
                Discurso dis = new Discurso();
                
                while(rs.next())
                {
                    dis.setId(rs.getInt("id"));
                    dis.setNombre(rs.getString("nombre"));
                    dis.setNumero(rs.getInt("numero"));
                    
                    Tema a = tn.buscarTemaPor("id", "",  rs.getInt("idTema")).get(0);
                    dis.setTemaa(a); 
                    
                    lDiscurso.add(dis);
                }
                pstm.close(); 
                
            }
            if(categoria == "id")
            {
                PreparedStatement pstm = db.connect().prepareStatement(w);
                pstm.setInt(1, idD);
                
                ResultSet rs = pstm.executeQuery();
                Discurso dis = new Discurso();
                
                while(rs.next())
                {
                    
                    dis.setId(rs.getInt("id"));
                    dis.setNombre(rs.getString("nombre"));
                    dis.setNumero(rs.getInt("numero"));
                    Tema a = tn.buscarTemaPor("id", "", rs.getInt("idTema")).get(0);
                    dis.setTemaa(a);
                    
                    lDiscurso.add(dis);
                    
                }
                
                pstm.close();
            }
            if(categoria == "numero")
            {
                
               PreparedStatement pstm = db.connect().prepareStatement(e);
               pstm.setInt(1, numeroD);
               
               ResultSet rs = pstm.executeQuery();
               Discurso dis = new Discurso();
               
               while(rs.next())
               {
                   dis.setId(rs.getInt("id"));
                   dis.setNombre(rs.getString("nombre"));
                   dis.setNumero(rs.getInt("numero"));
                   Tema a = tn.buscarTemaPor("id", "", rs.getInt("idTema")).get(0);
                   dis.setTemaa(a);
                   
                   lDiscurso.add(dis);
               }
                
               pstm.close();
            }
           
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        
        return lDiscurso;
    }
    
    
    public List<Discurso> traerTodosDis(){
        List<Discurso> disc = new ArrayList<Discurso>();
        Discurso dis = new Discurso();
        ITemaNegocio tn = new TemaNegocio();
        
        String q = "SELECT * FROM discurso";
        
        try
        {
            PreparedStatement pstm = db.connect().prepareStatement(q);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                dis.setId(rs.getInt("id"));
                dis.setNombre(rs.getString("nombre"));
                dis.setNumero(rs.getInt("numero"));
                Tema a = tn.buscarTemaPor("id", "", rs.getInt("idTema")).get(0);
                dis.setTemaa(a);
                
                disc.add(dis);
                
            }
            
            pstm.close();
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            
        }
        
        
        
        return disc;
    }
    
}
