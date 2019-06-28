/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.Controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fernanda
 */
public class BaseDeDatos {
    private Connection conecxionBD;
    public BaseDeDatos(){
        
    }

    public Connection getConecxionBD() {
        return conecxionBD;
    }
    
    
    public void conectar(){
        String url="jdbc:postgresql://localhost:5432/MiBasedeDatos";
        String user="postgres";
        String password = "09192130";
        try{
        conecxionBD = DriverManager.getConnection(url, user, password);
       if(conecxionBD.isValid(5000)){
           System.out.println("Conexion Exitosa");
       }
    }catch(SQLException ex){
        ex.printStackTrace();
    }
}
    public void desconectar(){
        try{
            if(!conecxionBD.isClosed()){
                conecxionBD.close();
                System.out.println("Conexion cerrada");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
