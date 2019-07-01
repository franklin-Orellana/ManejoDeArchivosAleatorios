package ec.edu.ups.modelo;

public class Direcciones {
    private int codigo;
    private String cedula;
    private String cPrincipal;
    private String numCasa;
    private String cSecundaria;

    public Direcciones() {
    }

    public Direcciones(int codigo, String cedula, String cPrincipal, String numCasa, String cSecundaria) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.cPrincipal = cPrincipal;
        this.numCasa = numCasa;
        this.cSecundaria = cSecundaria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getcPrincipal() {
        return cPrincipal;
    }

    public void setcPrincipal(String cPrincipal) {
        this.cPrincipal = cPrincipal;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    public String getcSecundaria() {
        return cSecundaria;
    }

    public void setcSecundaria(String cSecundaria) {
        this.cSecundaria = cSecundaria;
    }
    
    
}
