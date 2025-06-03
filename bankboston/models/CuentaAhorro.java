/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston.models; 
import java.time.LocalDate;
 
public class CuentaAhorro extends Cuenta {
    private LocalDate fechaCreaci�n;
    
    public CuentaAhorro (int saldo, int monto){ 
        super(saldo, monto);
        this.fechaCreaci�n = LocalDate.now();
    }   

    @Override
    public void mostrarDatos() {
        System.out.println("Cuenta Ahorro: " + cuentaCorriente);
        System.out.println("Saldo: " + saldo);
    } 
  
    // Bloquea giro hasta 6 meses desde creacion de la cuenta
    @Override
    public void girarSaldo(int valor) { 
        relojRetiro(valor);   
    }
    
    public void relojRetiro (int monto){    
        LocalDate d�a = LocalDate.now();
        LocalDate fechaRetiro = fechaCreaci�n.plusMonths(6);
        
        if (d�a == fechaRetiro){
           this.saldo -= monto;;       
        } else { 
            System.out.println("No se puede girar saldo. Fecha de retiro: " + fechaRetiro);
        }          
    }
    
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}

