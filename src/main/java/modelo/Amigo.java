package modelo;

import java.util.*;
import DAO.AmigoDAO;
import java.sql.SQLException;

public class Amigo {

    private int id;
    private String nome;
    private String telefone;
    private final AmigoDAO dao;

    /**
     * Construtor padrão da classe Amigo.
     */
    public Amigo() {
        this.dao = new AmigoDAO();
    }

    /**
     * Construtor da classe Amigo.
     *
     * @param nome O nome do amigo.
     * @param telefone O telefone do amigo.
     */
    public Amigo(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.dao = new AmigoDAO();
    }

    /**
     * Construtor da classe Amigo.
     *
     * @param id O ID do amigo.
     * @param nome O nome do amigo.
     * @param telefone O telefone do amigo.
     */
    public Amigo(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dao = new AmigoDAO();
    }

    /**
     * Getters e Setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Telefone: " + this.getTelefone()
                + "\n -----------";
    }

    /**
     * Retorna a lista de amigos.
     *
     * @return A lista de amigos.
     */
    public ArrayList<Amigo> getMinhaListaDeAmigos() {
        return dao.getMinhaLista();
    }

    /**
     * Insere um amigo no banco de dados.
     *
     * @param id O ID do amigo.
     * @param nome O nome do amigo.
     * @param telefone O telefone do amigo.
     * @return true se a inserção for bem-sucedida, false caso contrário.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public boolean InsertAmigoBD(int id, String nome, String telefone) throws SQLException {
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.InsertAmigoBD(objeto);
        return true;
    }

    /**
     * Insere um amigo no banco de dados.
     *
     * @param nome O nome do amigo.
     * @param telefone O telefone do amigo.
     * @return true se a inserção for bem-sucedida, false caso contrário.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public boolean InsertAmigoBD(String nome, String telefone) throws SQLException {
        int id = this.maiorID() + 1;
        return InsertAmigoBD(id, nome, telefone);
    }

    /**
     * Deleta um amigo do banco de dados pelo ID.
     *
     * @param id O ID do amigo a ser excluído.
     * @return true se a exclusão for bem-sucedida, false caso contrário.
     */
    public boolean DeleteAmigoBD(int id) {
        dao.DeleteAmigoBD(id);
        return true;
    }

    /**
     * Atualiza os dados de um amigo no banco de dados.
     *
     * @param id O ID do amigo.
     * @param nome O novo nome do amigo.
     * @param telefone O novo telefone do amigo.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     */
    public boolean UpdateAmigoBD(int id, String nome, String telefone) {
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.UpdateAmigoBD(objeto);
        return true;
    }

    /**
     * Carrega um amigo do banco de dados pelo ID.
     *
     * @param id O ID do amigo a ser carregado.
     * @return O objeto Amigo carregado com os dados do banco de dados.
     */
    public Amigo carregaAmigo(int id) {
        return dao.carregaAmigo(id);
    }

    /**
     * Retorna o maior ID dos amigos no banco de dados.
     *
     * @return O maior ID dos amigos no banco de dados.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
}
