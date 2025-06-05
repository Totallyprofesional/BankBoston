/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston.models;   

public class CuentaNormal extends Cuenta { 
 
    public CuentaNormal (int saldo, int monto){ 
        super(saldo, monto); 
    } 

    @Override
    public void mostrarDatos() {
        System.out.println("Cuenta Ahorro: " + cuentaCorriente);
        System.out.println("Saldo: " + saldo);
    } 
     
    // Giro normal 
    @Override
    public void girarSaldo(int monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que 0");
        }
        if (monto > this.saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= monto;
    }
    
}