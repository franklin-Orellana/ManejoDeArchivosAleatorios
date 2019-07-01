/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ControladorDirecciones;

import ec.edu.ups.ControladorPersona.BaseDeDatos;
import ec.edu.ups.modelo.Direcciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fernanda
 */
public class ControladorDirecciones {

    private BaseDeDatos BaseDeDatos;

    public ControladorDirecciones() {

        BaseDeDatos = new BaseDeDatos();

    }

    public void crear(Direcciones direccion) {

        String sql = "INSERT INTO\"DIRECCION\"VALUES("
                + direccion.getCodigo() + ",'"
                + direccion.getCedula() + "','"
                + direccion.getcPrincipal() + "','"
                + direccion.getcSecundaria() + "','"
                + direccion.getNumCasa() + "')";

        BaseDeDatos.conectar();
        try {
            Statement stat = BaseDeDatos.getConecxionBD().createStatement();
            stat.execute(sql);
            BaseDeDatos.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(int codigo) {
        String sql = "DELETE FROM\"DIRECCION\"WHERE\"DIR_CODIGO\" = '"
                + codigo + "';";
        BaseDeDatos.conectar();
        try {
            Statement sta = BaseDeDatos.getConecxionBD().createStatement();
            sta.execute(sql);
            BaseDeDatos.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Direcciones direcciones) {

        String sql = "UPDATE\"PERSONA\"SET\"DIR_CALLE_PRINCIPAL\" = '"
                + direcciones.getcPrincipal() + "',"
                + "\"DIR_CALLE_SECUNDARIA\" = ' " + direcciones.getcSecundaria()+ "',"
                + "\"DIR_CODIGO\" = " + direcciones.getCodigo() + ",' "
                + "\"DIR_CEDULA\" = " + direcciones.getCedula() + "',' "
                + "\"DIR_NUMERO_CASA\" = " + direcciones.getNumCasa() + ")";

        BaseDeDatos.conectar();
        try {
            Statement sta = BaseDeDatos.getConecxionBD().createStatement();
            sta.execute(sql);
            BaseDeDatos.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Direcciones buscar(int codigo) throws Exception {
        Direcciones direcciones = new Direcciones();
        String sql = "SELECT*FROM\"PERSONA\"WHERE\"DIR_CODIGO\"="
                + "'" + codigo + "'";
        BaseDeDatos.conectar();
        try {
            Statement sta = BaseDeDatos.getConecxionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);
            res.next();
            direcciones.setcPrincipal(res.getString("DIR_CALLE_PRINCIPAL"));
            direcciones.setcSecundaria(res.getString("DIR_CALLE_SECUNDARIA"));
            direcciones.setCodigo(res.getInt("DIR_CODIGO"));
            direcciones.setCedula(res.getString("DIR_CEDULA"));
            direcciones.setNumCasa(res.getString("DIR_NUMERO_CASA"));
            res.close();
            res.close();
            BaseDeDatos.desconectar();
        } catch (SQLException ex) {
            System.out.println("");
        }
        return direcciones;
    }
}
