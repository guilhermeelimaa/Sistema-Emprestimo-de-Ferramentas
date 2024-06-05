package DAO;

import modelo.Emprestimo;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmprestimoDAO {

    /**
     * Lista estática que armazena objetos da classe Emprestimo.
     */
    public static ArrayList<Emprestimo> MinhaLista = new ArrayList<>();

    /**
     * Construtor padrão da classe EmprestimoDAO.
     */
    public EmprestimoDAO() {
    }

    /**
     * Método para obter o maior ID da tabela 'tb_emprestimo'.
     *
     * @return O maior ID presente na tabela 'tb_emprestimo'.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
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

    /**
     * Método para obter uma conexão com o banco de dados.
     *
     * @return Uma conexão com o banco de dados.
     */
    public Connection getConexao() {
        Connection connection = null;
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
        } catch (ClassNotFoundException e) {
            /**
             * Driver não foi encontrado
             */
            System.out.println("O driver nao foi encontrado. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
        }
        return connection;
    }

    /**
     * Retorna a Lista de Emprestimos.
     *
     * @return A lista de emprestimos.
     */
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
                String status = res.getString("status");
                Emprestimo objeto = new Emprestimo(id, amigo, ferramenta, dataaquisicao, dataentrega, status);
                MinhaLista.add(objeto);
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return MinhaLista;
    }

    /**
     * Insere um emprestimo no banco de dados.
     *
     * @param objeto O objeto Emprestimo a ser inserido no banco de dados.
     * @return true se a inserção for bem-sucedida, false caso contrário.
     */
    public boolean InsertEmprestimoBD(Emprestimo objeto) {
        String sql = "INSERT INTO tb_emprestimo(id, amigo, ferramenta, dataaquisicao, dataentrega, status) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getAmigo());
            stmt.setString(3, objeto.getFerramenta());
            stmt.setString(4, objeto.getDataaquisicao());
            stmt.setString(5, objeto.getDataentrega());
            stmt.setString(6, objeto.getStatus());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
    }

    public boolean updateStatusEmprestimoBD(int id, String status, String dataEntrega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = this.getConexao();
            String sql = "UPDATE tb_emprestimo SET status = ?, dataentrega = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setString(2, dataEntrega);
            stmt.setInt(3, id);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Deleta um emprestimo do banco de dados pelo ID.
     *
     * @param id O ID do emprestimo a ser excluído.
     * @return true se a exclusão for bem-sucedida, false caso contrário.
     */
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

    /**
     * Atualiza os dados de um emprestimo no banco de dados.
     *
     * @param objeto O objeto Emprestimo com os novos dados.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     */
    public boolean UpdateEmprestimoBD(Emprestimo objeto) {
        String sql = "UPDATE tb_emprestimo SET amigo = ?, ferramenta = ?, dataaquisicao = ?, dataentrega = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getAmigo());
            stmt.setString(2, objeto.getFerramenta());
            stmt.setString(3, objeto.getDataaquisicao());
            stmt.setString(4, objeto.getDataentrega());
            stmt.setString(5, objeto.getStatus());
            stmt.setInt(6, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
    }

    /**
     * Carrega um emprestimo do banco de dados pelo ID.
     *
     * @param id O ID do emprestimo a ser carregado.
     * @return O objeto Emprestimo carregado com os dados do banco de dados.
     */
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
                objeto.setStatus(res.getString("status"));
            }
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return objeto;
    }
}
