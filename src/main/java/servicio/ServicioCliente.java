/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import modelo.Cliente;
import repositorio.ClienteRepository;

/**
 *
 * @author DIEGO ANDRES
 */
public class ServicioCliente {
    ClienteRepository clienteRepository = new ClienteRepository();
    
    public void save(Cliente cliente){
        clienteRepository.save(cliente);
    }
    
    public ArrayList<Cliente> listarClientes(){
        return clienteRepository.listarClientes();
    }
    
    public void update (Cliente cliente){
        clienteRepository.update(cliente);
    }
    
    public void delete(Cliente cliente){
        clienteRepository.delete(cliente);
    }
}
