package modelo;

import DAO.EmprestimoDAO;
import java.util.*;
import java.sql.SQLException;

public class Emprestimo {

    private int id;
    private String amigo;
    private String ferramenta;
    private String dataaquisicao;
    private String dataentrega;
    private final EmprestimoDAO dao;

    /**
     * Construtor padrão da classe Emprestimo.
     */
    public Emprestimo() {
        this.dao = new EmprestimoDAO();
    }

    /**
     * Construtor da classe Emprestimo.
     *
     * @param id O ID do empréstimo.
     * @param amigo O nome do amigo.
     * @param ferramenta O nome da ferramenta.
     * @param dataaquisicao A data de aquisição.
     * @param dataentrega A data de entrega.
     */
    public Emprestimo(int id, String amigo, String ferramenta, String dataaquisicao, String dataentrega) {
        this.id = id;
        this.amigo = amigo;
        this.ferramenta = ferramenta;
        this.dataaquisicao = dataaquisicao;
        this.dataentrega = dataentrega;
        this.dao = new EmprestimoDAO();
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

    public String getAmigo() {
        return amigo;
    }

    public void setAmigo(String amigo) {
        this.amigo = amigo;
    }

    public String getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(String ferramenta) {
        this.ferramenta = ferramenta;
    }

    public String getDataaquisicao() {
        return dataaquisicao;
    }

    public void setDataaquisicao(String dataaquisicao) {
        this.dataaquisicao = dataaquisicao;
    }

    public String getDataentrega() {
        return dataentrega;
    }

    public void setDataentrega(String dataentrega) {
        this.dataentrega = dataentrega;
    }

    @Override
    public String toString() {
        return "\n Amigo: " + this.getAmigo()
                + "\n Ferramenta: " + this.getFerramenta()
                + "\n Data Aquisição: " + this.getDataaquisicao()
                + "\n Data Entrega: " + this.getDataentrega()
                + "\n -----------";
    }

    /**
     * Retorna a lista de empréstimos.
     *
     * @return A lista de empréstimos.
     */
    public ArrayList<Emprestimo> getMinhaLista() {
        return dao.getMinhaLista();
    }

    /**
     * Insere um empréstimo no banco de dados.
     *
     * @param id O ID do empréstimo.
     * @param amigo O nome do amigo.
     * @param ferramenta O nome da ferramenta.
     * @param dataaquisicao A data de aquisição.
     * @param dataentrega A data de entrega.
     * @return true se a inserção for bem-sucedida, false caso contrário.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public boolean InsertEmprestimoBD(int id, String amigo, String ferramenta, String dataaquisicao, String dataentrega) throws SQLException {
        Emprestimo objeto = new Emprestimo(id, amigo, ferramenta, dataaquisicao, dataentrega);
        dao.InsertEmprestimoBD(objeto);
        return true;
    }

    /**
     * Deleta um empréstimo do banco de dados pelo ID.
     *
     * @param id O ID do empréstimo a ser excluído.
     * @return true se a exclusão for bem-sucedida, false caso contrário.
     */
    public boolean DeleteEmprestimoBD(int id) {
        dao.DeleteEmprestimoBD(id);
        return true;
    }

    /**
     * Atualiza os dados de um empréstimo no banco de dados.
     *
     * @param id O ID do empréstimo.
     * @param amigo O nome do amigo.
     * @param ferramenta O nome da ferramenta.
     * @param dataaquisicao A data de aquisição.
     * @param dataentrega A data de entrega.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     */
    public boolean UpdateEmprestimoBD(int id, String amigo, String ferramenta, String dataaquisicao, String dataentrega) {
        Emprestimo objeto = new Emprestimo(id, amigo, ferramenta, dataaquisicao, dataentrega);
        dao.UpdateEmprestimoBD(objeto);
        return true;
    }

    /**
     * Carrega um empréstimo do banco de dados pelo ID.
     *
     * @param id O ID do empréstimo a ser carregado.
     * @return O objeto Emprestimo carregado com os dados do banco de dados.
     */
    public Emprestimo carregaEmprestimo(int id) {
        return dao.carregaEmprestimo(id);
    }

    /**
     * Retorna o maior ID dos empréstimos no banco de dados.
     *
     * @return O maior ID dos empréstimos no banco de dados.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
}
