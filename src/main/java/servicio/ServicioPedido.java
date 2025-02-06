/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Pedido;
import repositorio.PedidoRepository;

/**
 *
 * @author DIEGO ANDRES
 */
public class ServicioPedido {
    PedidoRepository pedidoRepository;
    public void save(Pedido pedido){
        pedidoRepository.save(pedido);
    }
    public ArrayList<Pedido> listarPedidos(){
        return pedidoRepository.listarPedidos();
    }
    public void update(Pedido pedido){
        pedidoRepository.update(pedido);
    }
    public void delete(Pedido pedido){
        pedidoRepository.delete(pedido);
    }
}
