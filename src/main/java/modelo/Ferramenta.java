package modelo;

import java.util.ArrayList;
import DAO.FerramentaDAO;
import java.sql.SQLException;

public class Ferramenta {

    private int id;
    private String nome;
    private String marca;
    private Double custo;
    private int quantidade;
    private java.sql.Date dataCadastro;
    private final FerramentaDAO dao;

    /**
     * Construtor padrão da classe Ferramenta.
     */
    public Ferramenta() {
        this.dao = new FerramentaDAO();
    }

    /**
     * Construtor da classe Ferramenta.
     *
     * @param id O ID da ferramenta.
     * @param nome O nome da ferramenta.
     * @param marca A marca da ferramenta.
     * @param custo O custo da ferramenta.
     * @param quantidade A quantidade da ferramenta.
     * @param dataCadastro A data de cadastro da ferramenta.
     */
    public Ferramenta(int id, String nome, String marca, Double custo, int quantidade, java.sql.Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
        this.dao = new FerramentaDAO();
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public java.sql.Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(java.sql.Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Marca: " + this.getMarca()
                + "\n Custo: " + this.getCusto()
                + "\n Quantidade: " + this.getQuantidade()
                + "\n Data de Cadastro: " + this.getDataCadastro()
                + "\n -----------";
    }

    /**
     * Retorna a lista de ferramentas.
     *
     * @return A lista de ferramentas.
     */
    public ArrayList<Ferramenta> getMinhaLista() {
        return dao.getMinhaLista();
    }

    /**
     * Insere uma ferramenta no banco de dados.
     *
     * @param nome O nome da ferramenta.
     * @param marca A marca da ferramenta.
     * @param custo O custo da ferramenta.
     * @return true se a inserção for bem-sucedida, false caso contrário.
     */
    public boolean InsertFerramentaBD(String nome, String marca, double custo) {
        Ferramenta objeto = new Ferramenta(0, nome, marca, custo, 1, new java.sql.Date(System.currentTimeMillis()));

        try {
            return dao.InsertFerramentaBD(objeto);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deleta uma ferramenta do banco de dados pelo ID.
     *
     * @param id O ID da ferramenta a ser excluída.
     * @return true se a exclusão for bem-sucedida, false caso contrário.
     */
    public boolean DeleteFerramentaBD(int id) {
        dao.DeleteFerramentaBD(id);
        return true;
    }

    /**
     * Atualiza os dados de uma ferramenta no banco de dados.
     *
     * @param id O ID da ferramenta.
     * @param nome O nome da ferramenta.
     * @param marca A marca da ferramenta.
     * @param custo O custo da ferramenta.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     */
    public boolean UpdateFerramentaBD(int id, String nome, String marca, double custo) {
        return dao.UpdateFerramentaBD(id, nome, marca, custo);
    }

    /**
     * Carrega uma ferramenta do banco de dados pelo ID.
     *
     * @param id O ID da ferramenta a ser carregada.
     * @return O objeto Ferramenta carregado com os dados do banco de dados.
     */
    public Ferramenta carregaFerramenta(int id) {
        return dao.carregaFerramenta(id);
    }

    /**
     * Retorna o maior ID das ferramentas no banco de dados.
     *
     * @return O maior ID das ferramentas no banco de dados.
     * @throws SQLException se ocorrer um erro ao acessar o banco de dados.
     */
    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
}
