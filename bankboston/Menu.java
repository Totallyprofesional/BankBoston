/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston;

import java.util.List; 
import java.util.Scanner;
import bankboston.managers.BankManager;
import bankboston.models.Cliente;
import bankboston.models.Cuenta;
import java.util.InputMismatchException;
 
public class Menu {
    private Scanner sc;
    private BankManager bankManager;
    private Cliente clienteActual;
    private Cuenta cuentaActual;
    
    public Menu() {
        sc = new Scanner(System.in);
        bankManager = BankManager.getInstancia();
        clienteActual = null;
        cuentaActual = null;
    }
     
    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN BANK BOSTON =====");
            System.out.println("Clientes: " + bankManager.getCantidadClientes());
            System.out.println("\n=======================================");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos cliente");
            System.out.println("3. Depositar en cuenta");
            System.out.println("4. Girar desde cuenta");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.print("\n Ingrese una opción: ");          
               
            try {
                opcion = sc.nextInt(); 
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido");
                sc.nextLine();
            }
            
            switch (opcion) {
                case 1:
                    registrarCliente(sc);       
                    break;
                case 2:
                    verDatosCliente(sc);
                    break;
                case 3: 
                    depositarCuenta(sc);  
                    break;
                case 4:
                    girarCuenta(sc);
                    break;
                case 5:
                    consultarSaldo(sc);
                    break;
                case 6:
                    System.out.println("Saliendo del menú");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }         
        } while (opcion != 6);
    } 

    public void registrarCliente(Scanner sc) {
        System.out.println("\n===== REGISTRO DE CLIENTE =====");
        System.out.print("Ingrese rut (sin guión y puntos): "); 
        String rut = sc.nextLine();
        
        if (bankManager.buscarCliente(rut) != null) {
            System.out.println("Error: Ya existe un cliente con ese RUT");
            return;
        }
        
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese apellido paterno: ");
        String apellidoPaterno = sc.nextLine();
        System.out.print("Ingrese apellido materno: ");
        String apellidoMaterno = sc.nextLine();
        System.out.print("Ingrese domicilio: ");
        String domicilio = sc.nextLine();
        System.out.print("Ingrese comuna: ");
        String comuna = sc.nextLine();    
        System.out.print("Ingrese teléfono: ");
        int teléfono = sc.nextInt();
          
        try {     
            Cliente nuevoCliente = new Cliente(rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, teléfono);      
            if (nuevoCliente.registrarCliente() && bankManager.agregarCliente(nuevoCliente)) {         
                clienteActual = nuevoCliente;
                 
                cuentaActual = new Cuenta(0); 
                clienteActual.setCuenta(cuentaActual);
                System.out.print("Cuenta creada exitosamente: ");
                cuentaActual.mostrarDatos();
                
            }
        } catch (IllegalArgumentException e) { 
            System.out.println("Error: " + e.getMessage());          
        } 
    }
    
    // Metodo para verificar rut
    public void verificarRut(Scanner sc) {
        System.out.print("Ingrese RUT del cliente: ");
        String rut = sc.nextLine();
        
        Cliente nuevoCliente = bankManager.buscarCliente(rut);
        if (nuevoCliente != null) {
            System.out.println("Abriendo cuenta:");
            nuevoCliente.verDatosCliente();
        } else {
            System.out.println("No se encontró ningún cliente con ese RUT");
        } 
    }
    
    public void verDatosCliente(Scanner sc) {
        verificarRut(sc);
        
        if (clienteActual != null) {  
            cuentaActual.mostrarDatos();
        } else {
            System.out.println("No hay datos de cliente");
        }
    }     
    
    private void depositarCuenta(Scanner sc) {
        verificarRut(sc);
        cuentaActual.mostrarDatos();
        
        int monto = 0;
        
        try {
            System.out.println("Ingrese monto");
            monto = sc.nextInt();
            cuentaActual.depositarSaldo(monto);  
            System.out.println("Saldo actual: " + cuentaActual.getSaldo());
        } catch (InputMismatchException e) {
            System.out.println("Valor no válido");
        }   
    }
        
    private void girarCuenta(Scanner sc) {
        verificarRut(sc);
        cuentaActual.mostrarDatos();
        
        int monto = 0;
        
        try {
            System.out.println("Ingrese monto");
            monto = sc.nextInt();
            cuentaActual.girarSaldo(monto);  
            System.out.println("Saldo actual: " + cuentaActual.getSaldo());
        } catch (InputMismatchException e) {
            System.out.println("Valor no válido");
        }   
    } 
        
    private void consultarSaldo(Scanner sc) {
        System.out.print("Ingrese RUT del cliente: ");
        String rut = sc.nextLine();
        
        Cliente nuevoCliente = bankManager.buscarCliente(rut);
        if (nuevoCliente != null) {  
            System.out.println("Saldo actual: " + cuentaActual.getSaldo());
        } else {
            System.out.println("No se encontró ningún cliente con ese RUT");
        }   
    }
}

  
