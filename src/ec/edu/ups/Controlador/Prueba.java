/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.Controlador;
import ec.edu.ups.Controlador.ControladorPersona;
import ec.edu.ups.modelo.Principal;
/**
 *
 * @author Fernanda
 */
public class Prueba {
    public static void main(String[] args) {
        Principal persona = new Principal("Franklin", "Orellana", "0105599915", 22, new java.util.Date(), "099850306", 120.30);
        ControladorPersona cp = new ControladorPersona();
        cp.crear(persona);
    }
}
