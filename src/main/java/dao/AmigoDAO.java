package DAO;

import modelo.Amigo;
import java.util.ArrayList;
import java.sql.Connection;
import dao.ConexaoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe responsável por acessar e manipular os dados da tabela 'tb_amigo' no
 * banco de dados.
 */
public class AmigoDAO {
    
    /**
     * Criação de objeto responsável pela conexão com o banco de dados.
     */
    ConexaoDAO conexaoDAO = new ConexaoDAO();

    /**
     * Lista estática que armazena objetos da classe Amigo.
     */
    public static ArrayList<Amigo> MinhaLista = new ArrayList<Amigo>();

    /**
     * Construtor padrão da classe AmigoDAO.
     */
    public AmigoDAO() {
    }

    /**
     * Método para obter o maior ID da tabela 'tb_amigo'.
     *
     * @return O maior ID presente na tabela 'tb_amigo'.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public int maiorID() throws SQLException {
        int maiorID = 0;
        try {
            Statement stmt = conexaoDAO.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_amigo");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            // Tratamento de exceção aqui, se necessário
        }
        return maiorID;
    }

    /**
     * Retorna a Lista de Amigos.
     *
     * @return A lista de amigos.
     */
    public ArrayList getMinhaLista() {

        MinhaLista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = conexaoDAO.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigo");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String telefone = res.getString("telefone");

                Amigo objeto = new Amigo(id, nome, telefone);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    /**
     * Insere um amigo no banco de dados.
     *
     * @param objeto O objeto Amigo a ser inserido no banco de dados.
     * @return true se a inserção for bem-sucedida, false caso contrário.
     */
    public boolean InsertAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO tb_amigo(id, nome, telefone) VALUES(?,?,?)";

        try {
            PreparedStatement stmt = conexaoDAO.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTelefone());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    /**
     * Deleta um amigo do banco de dados pelo ID.
     *
     * @param id O ID do amigo a ser excluído.
     * @return true se a exclusão for bem-sucedida, false caso contrário.
     */
    public boolean DeleteAmigoBD(int id) {
        try {
            Statement stmt = conexaoDAO.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_amigo WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }

    /**
     * Atualiza os dados de um amigo no banco de dados.
     *
     * @param objeto O objeto Amigo com os novos dados.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     */
    public boolean UpdateAmigoBD(Amigo objeto) {

        String sql = "UPDATE tb_amigo set nome = ? ,telefone = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conexaoDAO.getConexao().prepareStatement(sql);

            stmt.setInt(3, objeto.getId());
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getTelefone());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    /**
     * Verifica se um amigo com o nome especificado já existe no banco de dados.
     *
     * @param nomeAmigo O nome do amigo a ser verificado.
     * @return true se o amigo existir, false caso contrário.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public boolean amigoExiste(String nomeAmigo) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tb_amigo WHERE nome = ?";
        try (Connection con = conexaoDAO.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nomeAmigo);
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        }
    }

    /**
     * Carrega um amigo do banco de dados pelo ID.
     *
     * @param id O ID do amigo a ser carregado.
     * @return O objeto Amigo carregado com os dados do banco de dados.
     */
    public Amigo carregaAmigo(int id) {

        Amigo objeto = new Amigo();
        objeto.setId(id);

        try {
            Statement stmt = conexaoDAO.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigo WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setTelefone(res.getString("telefone"));

            stmt.close();

        } catch (SQLException erro) {
        }
        return objeto;
    }
}
