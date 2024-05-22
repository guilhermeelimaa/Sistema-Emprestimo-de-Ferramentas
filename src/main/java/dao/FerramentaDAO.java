package DAO;

import modelo.Ferramenta;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FerramentaDAO {

    public static ArrayList<Ferramenta> MinhaLista = new ArrayList<>();

    public int maiorID() throws SQLException {
        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_ferramenta");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    public Connection getConexao() {
        Connection connection = null;

        try {

            // Carregando o JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Configurando a conexão
            String server = "localhost"; // Caminho do MySQL
            String database = "db_softwarea3";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: Não conectado");
            }

            return connection;

        } catch (ClassNotFoundException e) { // Driver não encontrado
            System.out.println("O driver não foi encontrado. " + e.getMessage());
            return null;

        } catch (SQLException e) {
            System.out.println("Não foi possível conectar...");
            return null;
        }
    }

    public ArrayList getMinhaLista() {

        MinhaLista.clear(); // Limpa o ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramenta");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                double custo = res.getDouble("custo");

                Ferramenta objeto = new Ferramenta(id, nome, marca, custo);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    public boolean InsertFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO tb_ferramenta(id, nome, marca ,custo) VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getMarca());
            stmt.setDouble(4, objeto.getCusto());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public boolean DeleteFerramentaBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_ferramenta WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }

    public boolean UpdateFerramentaBD(int id, String nome, String marca, double custo) {
        String sql = "UPDATE tb_ferramenta SET nome = ?, marca = ?, custo = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, marca);
            stmt.setDouble(3, custo);
            stmt.setInt(4, id);

            int rowsAffected = stmt.executeUpdate();
            stmt.close();

            return rowsAffected > 0;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public Ferramenta carregaFerramenta(int id) {

        Ferramenta objeto = new Ferramenta();
        objeto.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramenta WHERE id = " + id);
            res.next();

            objeto.setId(res.getInt("id"));
            objeto.setNome(res.getString("nome"));
            objeto.setMarca(res.getString("marca"));
            objeto.setCusto(res.getDouble("custo"));

            stmt.close();

        } catch (SQLException erro) {
        }
        return objeto;
    }
}
