/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Pedido;
import servicio.ServicioPedido;

/**
 *
 * @author DIEGO ANDRES
 */
public class ControladorPedido {
    ServicioPedido servicioPedido;
    public void save(String nombre, String email, String telefono ,double total){
        servicioPedido.save(new Pedido(new Cliente(nombre, email, telefono), total));
    }
    public ArrayList<Pedido> listarPedidos(){
        return servicioPedido.listarPedidos();
    }
    public void update(int idPedido, int idcliente, String nombre, String email, String telefono, String fechaPedido, double total){
        servicioPedido.update(new Pedido(idPedido, new Cliente(nombre, email, telefono), fechaPedido, total));
    }
    public void delete(int idPedido, int idcliente, String nombre, String email, String telefono, String fechaPedido, double total){
        servicioPedido.delete(new Pedido(idPedido, new Cliente(nombre, email, telefono), fechaPedido, total));
    }
}
