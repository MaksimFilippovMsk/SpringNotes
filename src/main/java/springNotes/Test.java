package springNotes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection("mysql:localhost:3031/mysql","root","root");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
