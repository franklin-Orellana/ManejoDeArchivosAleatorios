/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ControladorPersona;
import ec.edu.ups.ControladorPersona.ControladorPersona;
import ec.edu.ups.modelo.Persona;
/**
 *
 * @author Fernanda
 */
public class Prueba {
    public static void main(String[] args) {
        Persona persona = new Persona("Franklin", "Orellana", "0105599916", 22, new java.util.Date(), "099850306", 120.30);
        ControladorPersona cp = new ControladorPersona();
        cp.crear(persona);
    }
}
