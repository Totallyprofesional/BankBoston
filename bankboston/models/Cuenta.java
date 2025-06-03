/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston.models;

import java.time.LocalDate;

public abstract class Cuenta { 
    protected LocalDate fechaCreacion;
    protected int contadorCuenta = 1000;   
    protected int cuentaCorriente;
    protected int saldo; 
    protected int monto;

    public Cuenta(int saldo, int monto) {
        this.cuentaCorriente = ++contadorCuenta;
        this.saldo = saldo;
        this.monto = monto;
        this.fechaCreacion = LocalDate.now();
    } 
 
    public abstract void mostrarDatos(); 
      
    public abstract void girarSaldo(int monto);
 
    public void depositarSaldo(int monto) {
        this.saldo += monto;
    }

    public int getCuentaCorriente() {
        return cuentaCorriente;
    }

    public int getSaldo() {
        return saldo;
    }
    
}