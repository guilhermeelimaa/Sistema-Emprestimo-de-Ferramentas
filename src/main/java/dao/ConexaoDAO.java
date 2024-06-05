package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    public Connection getConexao() {
        Connection connection = null; // instância da conexão
        try {
            /**
            * Carregando o JDBC Driver
            */
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            /**
            * Configurando a conexão
            */
            String server = "localhost";
            /**
            * Caminho do MySQL
            */
            String database = "db_softwarea3";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, user, password);

            /**
            * Testando a conexão
            */
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: Não CONECTADO!");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            /**
            * Driver não foi encontrado
            */
            System.out.println("O driver nao foi encontrado. " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }
}
   