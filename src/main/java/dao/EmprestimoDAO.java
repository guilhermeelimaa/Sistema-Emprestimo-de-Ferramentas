package DAO;

import modelo.Emprestimo;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmprestimoDAO {

    public static ArrayList<Emprestimo> MinhaLista = new ArrayList<>();

    public EmprestimoDAO() {
    }

    public int maiorID() throws SQLException {
        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) as id FROM tb_emprestimo");
            if (res.next()) {
                maiorID = res.getInt("id");
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
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

            // Testando a conexão
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: Não CONECTADO!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("O driver nao foi encontrado. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
        }
        return connection;
    }

    // Retorna a Lista de Emprestimo
    public ArrayList<Emprestimo> getMinhaLista() {
        MinhaLista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimo");
            while (res.next()) {
                int id = res.getInt("id");
                String amigo = res.getString("amigo");
                String ferramenta = res.getString("ferramenta");
                String dataaquisicao = res.getString("dataaquisicao");
                String dataentrega = res.getString("dataentrega");
                Emprestimo objeto = new Emprestimo(id, amigo, ferramenta, dataaquisicao, dataentrega);
                MinhaLista.add(objeto);
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return MinhaLista;
    }

    public boolean InsertEmprestimoBD(Emprestimo objeto) {
        String sql = "INSERT INTO tb_emprestimo(id, amigo, ferramenta, dataaquisicao, dataentrega) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getAmigo());
            stmt.setString(3, objeto.getFerramenta());
            stmt.setString(4, objeto.getDataaquisicao());
            stmt.setString(5, objeto.getDataentrega());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
    }

    public boolean DeleteEmprestimoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_emprestimo WHERE id = " + id);
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return true;
    }

    public boolean UpdateEmprestimoBD(Emprestimo objeto) {
        String sql = "UPDATE tb_emprestimo SET amigo = ?, ferramenta = ?, dataaquisicao = ?, dataentrega = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getAmigo());
            stmt.setString(2, objeto.getFerramenta());
            stmt.setString(3, objeto.getDataaquisicao()); 
            stmt.setString(4, objeto.getDataentrega()); 
            stmt.setInt(5, objeto.getId()); 

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
    }

    public Emprestimo carregaEmprestimo(int id) {
        Emprestimo objeto = new Emprestimo();
        objeto.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimo WHERE id = " + id);
            if (res.next()) {
                objeto.setAmigo(res.getString("amigo"));
                objeto.setFerramenta(res.getString("ferramenta"));
                objeto.setDataaquisicao(res.getString("dataaquisicao"));
                objeto.setDataentrega(res.getString("dataentrega"));
            }
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return objeto;
    }
}
