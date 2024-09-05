package util;

import exception.SistemaRHDBException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {

   private static final String url = "jdbc:postgresql://localhost:5432/RTC";
   private static final String user = "postgres";
   private static final String password = "password";

    public Connection conexao() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void fecharConexao(Connection connection) throws SQLException {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
    }
}
