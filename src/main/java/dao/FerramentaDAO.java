package DAO;

import modelo.Ferramenta;
import java.sql.*;
import java.util.ArrayList;

public class FerramentaDAO {

    public static ArrayList<Ferramenta> MinhaLista = new ArrayList<>();

    public int maiorID() throws SQLException {
        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_ferramenta");
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
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String server = "localhost";
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
        } catch (ClassNotFoundException e) {
            System.out.println("O driver não foi encontrado. " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar...");
            return null;
        }
    }

    public ArrayList<Ferramenta> getMinhaLista() {
        MinhaLista.clear();
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramenta");
            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                double custo = res.getDouble("custo");
                int quantidade = res.getInt("quantidade");
                Date dataCadastro = res.getDate("dataCadastro");

                Ferramenta objeto = new Ferramenta(id, nome, marca, custo, quantidade, dataCadastro);
                MinhaLista.add(objeto);
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return MinhaLista;
    }

    public boolean InsertFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO tb_ferramenta(id, nome, marca ,custo, quantidade, dataCadastro) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getMarca());
            stmt.setDouble(4, objeto.getCusto());
            stmt.setInt(5, objeto.getQuantidade());
            stmt.setDate(6, objeto.getDataCadastro());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public boolean atualizarQuantidadeFerramenta(Ferramenta ferramenta) throws SQLException {
        String sql = "UPDATE tb_ferramenta SET quantidade = ? WHERE nome = ?";
        try (Connection con = getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, ferramenta.getQuantidade());
            stmt.setString(2, ferramenta.getNome());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean DeleteFerramentaBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_ferramenta WHERE id = " + id);
            stmt.close();
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return true;
    }

    public boolean UpdateFerramentaBD(int id, String nome, String marca, double custo) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("UPDATE tb_ferramenta SET nome = '" + nome + "',marca = '" + marca + "', custo = " + custo + " WHERE id = " + id);
            stmt.close();
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return true;
    }

    public Ferramenta carregaFerramenta(int id) {
        Ferramenta objeto = new Ferramenta();
        objeto.setId(id);
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramenta WHERE id = " + id);
            while (res.next()) {
                objeto.setId(res.getInt("id"));
                objeto.setNome(res.getString("nome"));
                objeto.setMarca(res.getString("marca"));
                objeto.setCusto(res.getDouble("custo"));
                objeto.setQuantidade(res.getInt("quantidade"));
                objeto.setDataCadastro(res.getDate("dataCadastro"));
            }
            stmt.close();
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return objeto;
    }
    
public ArrayList<String> listarNomesFerramentas() {
    ArrayList<String> nomesFerramentas = new ArrayList<>();
    try {
        Statement stmt = this.getConexao().createStatement();
        ResultSet res = stmt.executeQuery("SELECT nome FROM tb_ferramenta");
        while (res.next()) {
            String nome = res.getString("nome");
            nomesFerramentas.add(nome);
        }
        stmt.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return nomesFerramentas;
}


    public Ferramenta buscarFerramentaPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM tb_ferramenta WHERE nome = ?";
        try (Connection con = getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Ferramenta ferramenta = new Ferramenta();
                    ferramenta.setId(rs.getInt("id"));
                    ferramenta.setNome(rs.getString("nome"));
                    ferramenta.setMarca(rs.getString("marca"));
                    ferramenta.setCusto(rs.getDouble("custo"));
                    ferramenta.setQuantidade(rs.getInt("quantidade"));
                    ferramenta.setDataCadastro(rs.getDate("dataCadastro"));
                    return ferramenta;
                }
            }
        }
        return null;
    }
}
