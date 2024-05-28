package modelo;

import java.util.*;
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

    public Ferramenta() {
        this.dao = new FerramentaDAO();
    }

    public Ferramenta(int id, String nome, String marca, Double custo, int quantidade, java.sql.Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
        this.dao = new FerramentaDAO();
    }

    // Getters e Setters

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

    public ArrayList<Ferramenta> getMinhaLista() {
        return dao.getMinhaLista();
    }

    public boolean InsertFerramentaBD(String nome, String marca, double custo) {
        Ferramenta objeto = new Ferramenta(0, nome, marca, custo, 1, new java.sql.Date(System.currentTimeMillis()));

        try {
            return dao.InsertFerramentaBD(objeto);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteFerramentaBD(int id) {
        dao.DeleteFerramentaBD(id);
        return true;
    }

    public boolean UpdateFerramentaBD(int id, String nome, String marca, double custo) {
        return dao.UpdateFerramentaBD(id, nome, marca, custo);
    }

    public Ferramenta carregaFerramenta(int id) {
        return dao.carregaFerramenta(id);
    }

    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
}
