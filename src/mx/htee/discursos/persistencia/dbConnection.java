/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.htee.discursos.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author lalon
 */
public class dbConnection {
    
    private String db =   "beshopping_discurso"; 
    private String user = "beshopping_lalo";
    private String password = "**";
    private String url = "jdbc:mysql://1a.ncomputers.org:3306/" + db;
    private Connection conn = null;
    

    
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(this.url, this.user, this.password);
            
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return conn;
    }
    
}
