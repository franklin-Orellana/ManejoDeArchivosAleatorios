package ec.edu.ups.modelo;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Date;
import javax.swing.JOptionPane;

public class Persona {

    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    private Date fechaNacimineto;
    private String celular;
    private double salario;

    public Persona() {

    }

    public Persona(String nombre, String apellido, String cedula, int edad,Date fechaNacimineto, String celular, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.fechaNacimineto = fechaNacimineto;
        this.celular = celular;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {

        this.nombre = nombre;
        boolean si = true;
        for (int i = 0; i < nombre.length(); i++) {
            if ((nombre.charAt(i) < 60 || nombre.charAt(i) > 100 && nombre.charAt(i) < 97 || nombre.charAt(i) > 122) && nombre.charAt(i) != 32) {
                si = false;

            }
        }
        if (si) {
            if (nombre.contains(" ")) {

                this.nombre = nombre;
            } else {
                throw new Exception("Ingrese sus dos nombres");
            }
        } else {
            throw new Exception("Ingrese solo letras");
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws Exception {
        boolean si = true;
        for (int i = 0; i < apellido.length(); i++) {
            if ((apellido.charAt(i) < 60 || apellido.charAt(i) > 100 && apellido.charAt(i) < 97 || apellido.charAt(i) > 122) && apellido.charAt(i) != 32) {
                si = false;

            }
        }
        if (si) {
            if (apellido.contains(" ")) {

                this.apellido = apellido;
            } else {
                throw new Exception("Ingrese sus dos Apellidos");
            }
        } else {
            throw new Exception("Ingrese solo letras");
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) throws Exception {
        if (cedula.length() == 10) {
            if (validacion(cedula) == true) {
                this.cedula = cedula;
            } else {
                throw new Exception("Ingrese cedula correcta");
            }
        }

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 20 && edad <= 35) {
            this.edad = edad;
        } else {
            System.out.println("Edad no permitida");
        }
    }
    
    public Date getFechaNacimineto() {
        return fechaNacimineto;
    }

    public void setFechaNacimineto(Date fechaNacimineto)  {
      this.fechaNacimineto = fechaNacimineto;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) throws Exception {
        if (celular.length() == 10) {
            this.celular = celular;
        } else {
            throw new Exception("Ingrese un numero de celular valido");
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) throws Exception {
        if (salario != 0) {
            this.salario = salario;
        } else {
            throw new Exception(" ");
        }
    }

    public static boolean validacion(String x) {
        int sum = 0;
        int a[] = new int[x.length() / 2];
        int b[] = new int[(x.length() / 2)];
        int c = 0;
        int d = 1;
        for (int i = 0; i < x.length() / 2; i++) {
            a[i] = Integer.parseInt(String.valueOf(x.charAt(c)));
            c = c + 2;
            if (i < (x.length() / 2) - 1) {
                b[i] = Integer.parseInt(String.valueOf(x.charAt(d)));
                d = d + 2;
            }
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * 2;
            if (a[i] > 9) {
                a[i] = a[i] - 9;
            }
            sum = sum + a[i] + b[i];
        }
        int aux = sum / 10;
        int dec = (aux + 1) * 10;
        if ((dec - sum) == Integer.parseInt(String.valueOf(x.charAt(x.length() - 1)))) {
            return true;
        } else if (sum % 10 == 0 && x.charAt(x.length() - 1) == '0') {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", edad=" + edad + ", fechaNacimineto=" + fechaNacimineto + ", celular=" + celular + ", salario=" + salario + '}';
    }
    
    

}
