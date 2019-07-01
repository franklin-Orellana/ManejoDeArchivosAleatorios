/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ControladorDirecciones;

import ec.edu.ups.modelo.Direcciones;

/**
 *
 * @author Fernanda
 */
public class Prueba {
    public static void main(String[] args) {
        Direcciones direccion = new Direcciones(1, "0105599914", "Antonio Vallejo", "2-98", "y Eugenio Espejo");
        ControladorDirecciones cd = new ControladorDirecciones();
        cd.crear(direccion);
    }
}
