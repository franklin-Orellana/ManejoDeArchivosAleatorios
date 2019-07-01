/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ControladorPersona;

import ec.edu.ups.modelo.Persona;
import java.sql.ResultSet;
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

    public void crear(Persona persona) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(persona.toString());
        String FechaBD = formato.format(persona.getFechaNacimineto());
        String sql = "INSERT INTO\"PERSONA\"VALUES('"
                + persona.getCedula() + "','"
                + persona.getNombre() + "','"
                + persona.getApellido() + "', "
                + persona.getEdad() + ",' "
                + persona.getCelular() + "', '"
                + FechaBD + "', "
                + persona.getSalario() + ")";

        miBaseDeDtos.conectar();
        try {
            Statement sta = miBaseDeDtos.getConecxionBD().createStatement();
            sta.execute(sql);
            miBaseDeDtos.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(String cedula) {
        String sql = "DELETE FROM\"PERSONA\"WHERE\"PER_CEDULA\" = '"
                + cedula + "';";
        miBaseDeDtos.conectar();
        try {
            Statement sta = miBaseDeDtos.getConecxionBD().createStatement();
            sta.execute(sql);
            miBaseDeDtos.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Persona persona) {

        String sql = "UPDATE\"PERSONA\"SET\"PER_CEDULA\" = '"
                + persona.getCedula() + "',"
                + "\"PER_NOMBRE\" = ' " + persona.getNombre() + "','"
                + "\"PER_APELLIDO\" = '" + persona.getApellido() + "', "
                + "\"PER_EDAD\" = " + persona.getEdad() + ",' "
                + "\"PER_CELULAR\" = " + persona.getCelular() + "',' "
                + "\"PER_FECHA_NACIMIENTO\" = " + persona.getFechaNacimineto() + "', "
                + "\"PER_SALARIO\" = " + persona.getSalario() + ")";

        miBaseDeDtos.conectar();
        try {
            Statement sta = miBaseDeDtos.getConecxionBD().createStatement();
            sta.execute(sql);
            miBaseDeDtos.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Persona buscar(String cedula) throws Exception {
        Persona persona = new Persona();
        String sql = "SELECT*FROM\"PERSONA\"WHERE\"PER_CEDULA\"="
                + "'" + cedula + "'";
        miBaseDeDtos.conectar();
        try {
            Statement sta = miBaseDeDtos.getConecxionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);
            res.next();
            persona.setCedula(res.getString("PER_CEDULA"));
            persona.setNombre(res.getString("PER_NOMBRES"));
            persona.setApellido(res.getString("PER_APELIDOS"));
            persona.setCelular(res.getString("PER_CELULAR"));
            persona.setEdad(res.getInt("PER_EDAD"));
            persona.setFechaNacimineto(res.getDate("PER_FECHA_NACIMIENTO"));
            persona.setSalario(res.getDouble("PER_SALARIO"));
            res.close();
            res.close();
            miBaseDeDtos.desconectar();
        } catch (SQLException ex) {
            System.out.println("");
        }
        return persona;
    }
}
