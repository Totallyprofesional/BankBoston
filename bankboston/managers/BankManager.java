/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import bankboston.models.Cliente;

public class BankManager {
    private Map < String, Cliente > clientes;
    private int contadorClientes;
    
    private static BankManager instancia;
    
    private BankManager() {
        this.clientes = new HashMap<>();
        this.contadorClientes = 1000;
    }
    
    public static BankManager getInstancia() {
        if (instancia == null) {
            instancia = new BankManager();
        }
        return instancia;
    }
    
    public boolean agregarCliente(Cliente cliente) {
        if (clientes.containsKey(cliente.getRut())) {
            return false;
        }
        clientes.put(cliente.getRut(), cliente);
        return true;
    }
      // Revision
    public Cliente buscarCliente(String rut) {
        return clientes.get(rut);
    }
    
    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes.values());
    }
    
    public int generarContadorClientes() {
        return ++contadorClientes;
    }
    
    public int getCantidadClientes() {
        return clientes.size();
    }
    
}
