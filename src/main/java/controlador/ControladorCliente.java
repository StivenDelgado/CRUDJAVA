/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Cliente;
import repositorio.ClienteRepository;
import servicio.ServicioCliente;

/**
 *
 * @author DIEGO ANDRES
 */
public class ControladorCliente {
    
    ServicioCliente servicioCliente;
        public void save(int id ,String nombre,String email,String telefono){
        servicioCliente.save(new Cliente(id, nombre, email, telefono));
    }
    
    public ArrayList<Cliente> listarClientes(){
        return servicioCliente.listarClientes();
    }
    
    public void update (int id ,String nombre,String email,String telefono){
        servicioCliente.update(new Cliente(id, nombre, email, telefono));
    }
    
    public void delete(int id ,String nombre,String email,String telefono){
        servicioCliente.delete(new Cliente(id, nombre, email, telefono));
    }
 
}

