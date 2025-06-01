/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston.models;

public class Cuenta {
    private static int contadorCuenta = 1000; 
    private int cuentaCorriente;
    private int saldo;

    public Cuenta(int saldo) {
        this.cuentaCorriente = ++contadorCuenta;
        this.saldo = saldo;
    }

    public void mostrarDatos() {
        System.out.println("Cuenta Corriente: " + this.cuentaCorriente);
        System.out.println("Saldo: " + this.saldo);
    }

    public void depositarSaldo(int monto) {
        this.saldo += monto;
    }

    public void girarSaldo(int monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que 0");
        }
        if (monto > this.saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= monto;
    }

    public int getCuentaCorriente() {
        return cuentaCorriente;
    }

    public int getSaldo() {
        return saldo;
    }

}
