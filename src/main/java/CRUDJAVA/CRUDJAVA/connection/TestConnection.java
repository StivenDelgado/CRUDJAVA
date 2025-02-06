package CRUDJAVA.CRUDJAVA.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String[] args) throws SQLException {
        Connection connection = DBConnection.getConnection();

        if(connection != null) {
               System.out.println("conecto");
           }else {
               System.out.println("no se conecto");
           }
           DBConnection.closeConnection(connection);
	}
}
