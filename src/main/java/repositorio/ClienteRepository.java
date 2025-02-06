/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import CRUDJAVA.CRUDJAVA.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Cliente;

/**
 *
 * @author juand
 */
public class ClienteRepository {

    public static void save(Cliente cliente) {

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

}
