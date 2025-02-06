package CRUDJAVA.CRUDJAVA.connection;

import java.sql.Connection;
import java.sql.SQLException;
import modelo.Cliente;
import modelo.Pedido;
import repositorio.ClienteRepository;
import repositorio.PedidoRepository;

public class TestConnection {
	public static void main(String[] args) throws SQLException {
        Connection connection = DBConnection.getConnection();

        if(connection != null) {
               System.out.println("conecto");
           }else {
               System.out.println("no se conecto");
           }
           DBConnection.closeConnection(connection);
           
           Cliente cliente = new Cliente("Juan", "juan@gmail.com", "9876543");
           //ClienteRepository.save(cliente);
           cliente.setId(5);
           //ClienteRepository.update(cliente);
           //ClienteRepository.listarClientes();
           //ClienteRepository.delete(cliente);
           
           
           //PedidoRepository.listarPedidos();
           
           Pedido pedido = new Pedido(cliente, 3000);
           //PedidoRepository.save(pedido, cliente.getId());
           //pedido.setIdPedido(3);
           //PedidoRepository.update(pedido);
           //PedidoRepository.delete(pedido);

	}
        
        
}


