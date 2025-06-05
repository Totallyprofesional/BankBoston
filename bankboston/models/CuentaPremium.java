/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston.models;

public class CuentaPremium extends Cuenta {
    private double valor;
   
    public CuentaPremium (int saldo, int monto, int creditoPremium, double valor){ 
        super(saldo, monto);
        
        // Cuenta Premium tiene 500.000 de crédito
        this.saldo = 500000;
        this.valor =  saldo * 0.03;
    }    

    @Override 
    public void mostrarDatos() { 
        System.out.println("Cuenta Premium: " + cuentaCorriente);
        System.out.println("Saldo: " + saldo);
    }
    
    // Cobra porcentaje de saldo por giro
    @Override
    public void girarSaldo(int valor) {
        this.saldo += valor;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public int getSaldo() {
        return saldo;
    }
}

