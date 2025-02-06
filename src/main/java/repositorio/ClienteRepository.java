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

/**
 *
 * @author juand
 */
public class ClienteRepository {

    public void save(Cliente cliente) {

        String query = "INSERT INTO clientes (nombre_cliente, email, telefono) VALUES(?,?,?)";

        try (Connection connection = DBConnection.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefono());

            ps.executeUpdate();
            System.out.print("Cliente guardado correctamente.");

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public ArrayList<Cliente> listarClientes() {
        //Erecordatorio para mi el 0 significa que esta vacia osea false 
        String query = "SELECT * FROM clientes";
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre_cliente");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                Cliente cliente = new Cliente(idCliente, nombre, email, telefono);
                lista.add(cliente);
            }
        } catch (SQLException ex) {

        }
        return lista;
    }

    public boolean update(Cliente cliente) {
        String query = "UPDATE clientes SET nombre_cliente = ?, email = ?, telefono = ? WHERE id_cliente = ?";

        try (Connection connection = DBConnection.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefono());
            ps.setInt(4, cliente.getId());

            System.out.print("Cliente actulizado correctamente.");
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(Cliente cliente) {
        String query = "DELETE FROM clientes WHERE id_cliente = ?";

        try (Connection connection = DBConnection.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cliente.getId());

            System.out.print("Cliente borrado correctamente.");
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
