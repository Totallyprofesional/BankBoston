/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston.models;
 
public class Cliente implements Interfaz {
    private String rut;
    private String nombre; 
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private int tel�fono;    
    private Cuenta cuenta; 

    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String comuna, int tel�fono) {
        if (!validarRut(rut)) {
            throw new IllegalArgumentException("RUT no v�lido");
        }
        
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.tel�fono = tel�fono;
    }
    
    private boolean validarRut(String rut) {
        if (rut == null || rut.isEmpty()) {
            return false;
        } else {
        return rut.length() == 9;
        }
    }
    
    public boolean registrarCliente() {       
        if (validarRut(rut)) {
            System.out.println("\n Cliente registrado correctamente: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
            return true;
        } 
        return false;    
    }
    
    @Override
    public void verDatosCliente() {
        System.out.println("\n========== Datos del cliente ==========");
        System.out.println("RUT: " + this.rut);
        System.out.println("Nombre completo: " + nombre + "" + apellidoPaterno + "" + apellidoMaterno);
        System.out.println("Domicilio: " + this.domicilio); 
        System.out.println("Comuna: " + this.comuna);
        System.out.println("Tel�fono: " + this.tel�fono); 
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
}
