/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankboston;

import java.util.Scanner; 
import bankboston.managers.BankManager;
import bankboston.models.Cliente;  
import bankboston.models.Cuenta;
import bankboston.models.CuentaNormal;  
import bankboston.models.CuentaAhorro; 
import bankboston.models.CuentaPremium;

public class BankBoston {
    public static Scanner sc = new Scanner(System.in);
    public static BankManager bankManager; 
    public static Cliente clienteActual; 
    public static Cuenta CuentaActual;  
    public static CuentaNormal CuentaNormal;  
    public static CuentaAhorro CuentaAhorro;
    public static CuentaPremium CuentaPremium;   
 
    public static void main(String[] args) {
        System.out.println("Menú Bank Boston");
             
        Menu menu = new Menu(sc, bankManager, clienteActual, CuentaActual, CuentaNormal, CuentaAhorro, CuentaPremium);  
        menu.mostrarMenu(); 
    }  
}  
                  