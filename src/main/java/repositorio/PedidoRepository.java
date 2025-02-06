/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import CRUDJAVA.CRUDJAVA.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Pedido;

/**
 *
 * @author juand
 */
public class PedidoRepository {   
    public void save(Pedido pedido) {

        String query = "INSERT INTO pedidos (cliente_id, total) VALUES(?,?)";

        try (Connection connection = DBConnection.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, pedido.getCliente().getId());
            ps.setDouble(2, pedido.getTotal());

            ps.executeUpdate();
            System.out.print("Cliente guardado correctamente.");

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public ArrayList<Pedido> listarPedidos() {
        //Erecordatorio para mi el 0 significa que esta vacia osea false 
        String query = "SELECT * FROM pedidos as p INNER JOIN clientes as c ON p.cliente_id = c.id_cliente";
        ArrayList<Pedido> lista = new ArrayList<Pedido>();
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("id_pedido");
                String nombre = rs.getString("nombre_cliente");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                
                int idPedido = rs.getInt("id_pedido");
                Double total = rs.getDouble("total");
                String fecha = rs.getString("fecha_pedido");
                
                Cliente cliente = new Cliente(idCliente,nombre, email, telefono);
                Pedido pedido = new Pedido(idPedido, cliente, fecha, total);
                System.out.println(cliente.getNombre());
                lista.add(pedido);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(lista.size());
        return lista;
    }

    public boolean update(Pedido pedido) {
        String query = "UPDATE pedidos SET total = ? WHERE id_pedido = ?";

        try (Connection connection = DBConnection.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDouble(1, pedido.getTotal());
            ps.setInt(2, pedido.getIdPedido());


            System.out.print("Cliente actulizado correctamente.");
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String query = "DELETE FROM pedidos WHERE id_pedido = ?";

        try (Connection connection = DBConnection.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            System.out.print(ps.executeUpdate());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


    

}
