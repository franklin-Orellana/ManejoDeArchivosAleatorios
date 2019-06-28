/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.Controlador;
import ec.edu.ups.modelo.Principal;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
/**
 *
 * @author Fernanda
 */
public class ControladorPersona {
    private BaseDeDatos miBaseDeDtos; 

    public ControladorPersona() {

        miBaseDeDtos = new BaseDeDatos();
        
    }
            
    public void crear(Principal persona){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String FechaBD = formato.format(persona.getFechaNacimineto());
        String sql = "INSERT INTO\"PERSONA\"VALUES('"
                + persona.getCedula() + "',' "
                + persona.getNombre() + "',' "
                + persona.getApellido() + "', "
                + persona.getEdad() + ",' "
                + persona.getCelular() + "',' "
                + FechaBD + "', "
                + persona.getSalario() + ")";
    
            miBaseDeDtos.conectar();
            try{
            Statement sta = miBaseDeDtos.getConecxionBD().createStatement();
            sta.execute(sql);
            miBaseDeDtos.desconectar();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
    }
}
