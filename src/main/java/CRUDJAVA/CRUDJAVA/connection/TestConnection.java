package CRUDJAVA.CRUDJAVA.connection;

import java.sql.Connection;
import java.sql.SQLException;
import modelo.Cliente;
import repositorio.ClienteRepository;

public class TestConnection {
	public static void main(String[] args) throws SQLException {
        Connection connection = DBConnection.getConnection();

        if(connection != null) {
               System.out.println("conecto");
           }else {
               System.out.println("no se conecto");
           }
           DBConnection.closeConnection(connection);
           
           Cliente cliente = new Cliente("Freddy", "freddy@gmail.com", "9876543");
           //ClienteRepository.save(cliente);
           
           //ClienteRepository.update(cliente);
	}
        
        
}


